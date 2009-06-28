package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.gcu.bc.CarreraFacadeLocal;
import edu.upn.sigecac.gcu.be.Carrera;
import edu.upn.sigecac.pac.bc.DetalleMatrizAlineamientoObjetivosEducacionalesFacadeLocal;
import edu.upn.sigecac.pac.bc.MatrizAlineamientoObjetivosEducacionalesFacadeLocal;
import edu.upn.sigecac.pac.bc.ObjetivoEducacionalFacadeLocal;
import edu.upn.sigecac.pac.bc.ResultadoProgramaFacadeLocal;
import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales;
import edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales;
import edu.upn.sigecac.pac.be.ObjetivoEducacional;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class ObjetivoEducacionalController {

    @EJB
    private MatrizAlineamientoObjetivosEducacionalesFacadeLocal matrizAlineamientoObjetivosEducacionalesFacade;
    @EJB
    private DetalleMatrizAlineamientoObjetivosEducacionalesFacadeLocal detalleMatrizAlineamientoObjetivosEducacionalesFacade;
    @EJB
    private CarreraFacadeLocal carreraFacade;
    @EJB
    private ResultadoProgramaFacadeLocal resultadoProgramaFacade;
    Carrera carreraSeleccionada;
    private ObjetivoEducacionalFacadeLocal local;
    public ObjetivoEducacional objetivo;
    public List<ObjetivoEducacional> listaObjetivos;
    public List<ResultadoPrograma> listaResultados;
    public boolean habilitado = false;
    private List<ObjetivoEducacional> listaObjetivosTemporal;
    private List<ResultadoPrograma> listaResultadosTemporal;
    private ResultadoPrograma resultadoProgramaTexto;
    private List<MatrizObjetivoAdapter> listaMatriz;
    private MatrizObjetivoAdapter matrizSeleccionada;
    private MatrizAlineamientoObjetivosEducacionales matriz;
    private ResultadoPrograma resultadoSeleccionado;
    private ObjetivoEducacionalController delegateObjetivo;

    public ObjetivoEducacionalController() {
        local = lookupObjetivoEducacionalFacadeBean();
        listaObjetivos = new ArrayList<ObjetivoEducacional>();
        listaResultados = new ArrayList<ResultadoPrograma>();
        listarObjetivosEducacionales();
        listaObjetivosTemporal = new ArrayList<ObjetivoEducacional>();
        listaResultadosTemporal = new ArrayList<ResultadoPrograma>();
        carreraSeleccionada = new Carrera();
        listaMatriz = new ArrayList<MatrizObjetivoAdapter>();
        matrizSeleccionada = new MatrizObjetivoAdapter();
        matriz = new MatrizAlineamientoObjetivosEducacionales();
    }

    public List<ObjetivoEducacional> getListaObjetivosTemporal() {
        return listaObjetivosTemporal;
    }

    public void setListaObjetivosTemporal(List<ObjetivoEducacional> listaObjetivosTemporal) {
        this.listaObjetivosTemporal = listaObjetivosTemporal;
    }

    public List<ResultadoPrograma> getListaResultadosTemporal() {
        return listaResultadosTemporal;
    }

    public void setListaResultadosTemporal(List<ResultadoPrograma> listaResultadosTemporal) {
        this.listaResultadosTemporal = listaResultadosTemporal;
    }

    public Carrera getCarreraSeleccionada() {
        return carreraSeleccionada;
    }

    public void setCarreraSeleccionada(Carrera carreraSeleccionada) {
        this.carreraSeleccionada = carreraSeleccionada;
    }

    public ResultadoPrograma getResultadoProgramaTexto() {
        return resultadoProgramaTexto;
    }

    public void setResultadoProgramaTexto(ResultadoPrograma resultadoProgramaTexto) {
        this.resultadoProgramaTexto = resultadoProgramaTexto;
    }

    public List<MatrizObjetivoAdapter> getListaMatriz() {
        return listaMatriz;
    }

    public void setListaMatriz(List<MatrizObjetivoAdapter> listaMatriz) {
        this.listaMatriz = listaMatriz;
    }

    public MatrizObjetivoAdapter getMatrizSeleccionada() {
        return matrizSeleccionada;
    }

    public void setMatrizSeleccionada(MatrizObjetivoAdapter matrizSeleccionada) {
        this.matrizSeleccionada = matrizSeleccionada;
    }

    public MatrizAlineamientoObjetivosEducacionales getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizAlineamientoObjetivosEducacionales matriz) {
        this.matriz = matriz;
    }

    public ResultadoPrograma getResultadoSeleccionado() {
        return resultadoSeleccionado;
    }

    public void setResultadoSeleccionado(ResultadoPrograma resultadoSeleccionado) {
        this.resultadoSeleccionado = resultadoSeleccionado;
    }


    private ObjetivoEducacionalFacadeLocal lookupObjetivoEducacionalFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ObjetivoEducacionalFacadeLocal) c.lookup("java:comp/env/ObjetivoEducacionalFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<ObjetivoEducacional> getListaObjetivos() {
        return listaObjetivos;
    }

    public void setListaObjetivos(List<ObjetivoEducacional> listaObjetivos) {
        this.listaObjetivos = listaObjetivos;
    }

    public List<ResultadoPrograma> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<ResultadoPrograma> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public ObjetivoEducacionalFacadeLocal getLocal() {
        return local;
    }

    public void setLocal(ObjetivoEducacionalFacadeLocal local) {
        this.local = local;
    }

    public ObjetivoEducacional getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ObjetivoEducacional objetivo) {
        this.objetivo = objetivo;
    }

    public void crearObjetivoEducacional(ObjetivoEducacional objetivo) throws Exception {
        try {
            objetivo.setFid_Carrera(carreraSeleccionada.getIdCarrera());
            local.create(objetivo);
            listaObjetivos = local.findAll();
        } catch (Exception e) {
            local = lookupObjetivoEducacionalFacadeBean();
            throw new Exception(e.getStackTrace().toString(), e);
        }
    }

    public void actualizarObjetivoEducacional(ObjetivoEducacional objetivo) throws Exception {
        try {
            local.edit(objetivo);
        } catch (Exception e) {
            local = lookupObjetivoEducacionalFacadeBean();
            throw new Exception(e.getStackTrace().toString(), e);
        }

    }

    public List<ObjetivoEducacional> listarObjetivoEducacionales() throws Exception {
        try {
            return local.findAll();
        } catch (Exception e) {
            local = lookupObjetivoEducacionalFacadeBean();
            throw new Exception(e.getStackTrace().toString(), e);
        }
    }

 
    public List<ObjetivoEducacional> listarObjetivoEducacionalesxEstado() throws Exception {
        try {
            return local.listarxEstado(habilitado);
        } catch (Exception e) {
            local = lookupObjetivoEducacionalFacadeBean();
            throw new Exception(e.getStackTrace().toString(), e);
        }

    }

    //Metodos del Controller
    public String listarObjetivosEducacionales() {
        try {
            getListaObjetivos().clear();
            listaObjetivos = this.listarObjetivoEducacionales();
        } catch (Exception e) {
        } finally {
            return "";
        }
    }

    public String listarObjetivosEducacionalesxEstado() {
        try {
            getListaObjetivos().clear();
            listaObjetivos = this.listarObjetivoEducacionalesxEstado();
        } catch (Exception e) {
        } finally {
            return "";
        }
    }

    public String guardarObjetivoEducacional() {
        try {
            if (carreraSeleccionada.getIdCarrera() != null && !objetivo.getNombre().equals("") && !objetivo.getNombre().isEmpty()) {
                this.crearObjetivoEducacional(objetivo);
                objetivo = new ObjetivoEducacional();
                mostrarMensaje("Éxito: ", "El registro del Objetivo Educacional se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            }else{
                mostrarMensaje("Error: ", "Ingrese un nombre de Objetivo Educacional y seleccione una Carrera.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listarObjetivo";
    }

    public String actualizarObjetivoEducacional() {
        try {
            if (!objetivo.getNombre().equals("") && !objetivo.getNombre().isEmpty()) {
                this.actualizarObjetivoEducacional(objetivo);
                
                this.cancelar();
                mostrarMensaje("Éxito: ", "La actualzación del Objetivo Educacional se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            }else{
                mostrarMensaje("Error: ", "Ingrese un nombre de Objetivo Educacional.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
        }
        return "listarObjetivo";
    }


    public ObjetivoEducacional buscarObjetivos(Long id) throws Exception {
        try {
            return local.find(id);
        } catch (Exception e) {
            local = lookupObjetivoEducacionalFacadeBean();
            throw new Exception(e.getStackTrace().toString(), e);
        }

    }

    public String deshabilitarObjetivoEducacional() {
        try {
            objetivo.setEstado(false);
            this.actualizarObjetivoEducacional(objetivo);
            return "";

        } catch (Exception e) {
        }
        return "";
    }

    public String cancelar() {
        return "listarObjetivo";
    }

    public String navegarNuevo() {
        objetivo = new ObjetivoEducacional();
        return "nuevoObjetivo";
    }

    public String navegarActualizar() {
        return "actualizarObjetivo";
    }

    public String navegarMostrar() {
        return "mostrarObjetivo";
    }

    public String navegarListar() {
        listarObjetivosEducacionales();
        return "listarObjetivo";
    }

    public String navegarReporte() {
        return "reporte";
    }

    public static synchronized HttpServletResponse getResponse() {
        ExternalContext ctx;
        try {
            ctx = FacesContext.getCurrentInstance().getExternalContext();
            return (HttpServletResponse) ctx.getResponse();
        } catch (Exception ex) {
            return null;
        }
    }

    public String exportarListarObjetivos() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ObjetivoEducacionalController oec = (ObjetivoEducacionalController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "ObjetivoEducacionalController");
            List<ObjetivoEducacional> lista = oec.listarObjetivoEducacionalesxEstado();
            if (lista != null) {
                if (lista.size() > 0) {
                    File entrada = new File("C:/Reportes/pac_reporteObjetivoEducaional.jasper");
                    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
                    Map p = new HashMap();
                    //este parametro se pasa cuando tenemos sub reportes que necesitan una ruta para que el compilador las pueda encontrar
                    p.put("usuario", "Jorge Sanchez");
                    //p.put("SUBREPORT_DIR", "C:/Reportes/");
                    JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), p, ds);
                    HttpServletResponse response = getResponse();
                    JRPdfExporter exporter = new JRPdfExporter();
                    List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
                    jasperPrintList.add(print);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    response.setContentType("application/pdf");

//                    response.setHeader("Content-Disposition", "Reporte_Alumnos");
                    Date fecha = new Date();
                    response.addHeader("Content-Disposition", "filename=" + "Reporte_Objetivo_Educacional_" + fecha.toString() + ".pdf");

                    exporter.getParameters().putAll(p);
                    exporter.exportReport();
                    facesContext.responseComplete();
                } else {
                    mostrarMensaje("Advertencia.", "Asegúrese de haber registrado los objetivos educacionales", FacesMessage.SEVERITY_WARN);
                }
//            } else {
//                mostrarMensaje("Advertencia.", "Asegúrese de haber registrado algunos alumnos", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "";
    }

//Metodo para mostrar mensajes en la pagina

    public void mostrarMensaje(String resumen, String detalle, FacesMessage.Severity severidad) {
        try {
            FacesMessage fm = new FacesMessage(severidad, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        }
    }

    public String ReporteExcel() {
        try {
            Class.forName("com.sun.sql.jdbc.sqlserver.SQLServerDriver");
            Connection cnn = DriverManager.getConnection("jdbc:sun:sqlserver://localhost:1433;databaseName=SIGECAC", "sa", "adminadmin");
            File entrada = new File("C:\\Reporte\\pac_reporteObjetivoEducaional.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteObjetivoEducaional.xls"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
            exporterXLS.exportReport();
            ouputStream.write(byteArrayOutputStream.toByteArray());
            ouputStream.flush();
            ouputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String ReporteWord() {
        try {
            Class.forName("com.sun.sql.jdbc.sqlserver.SQLServerDriver");
            Connection cnn = DriverManager.getConnection("jdbc:sun:sqlserver://localhost:1433;databaseName=SIGECAC", "sa", "adminadmin");
            File entrada = new File("C:\\Reporte\\pac_reporteObjetivoEducaional.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteObjetivoEducaional.rtf"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JRRtfExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
            exporter.exportReport();
            ouputStream.write(byteArrayOutputStream.toByteArray());
            ouputStream.flush();
            ouputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String ReporteTxt() {
        try {
            Class.forName("com.sun.sql.jdbc.sqlserver.SQLServerDriver");
            Connection cnn = DriverManager.getConnection("jdbc:sun:sqlserver://localhost:1433;databaseName=SIGECAC", "sa", "adminadmin");
            File entrada = new File("C:\\Reporte\\pac_reporteObjetivoEducaional.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteObjetivoEducaional.txt"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JRTextExporter exporter = new JRTextExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
            exporter.exportReport();
            ouputStream.write(byteArrayOutputStream.toByteArray());
            ouputStream.flush();
            ouputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String ReporteHtml() {
        try {
            Class.forName("com.sun.sql.jdbc.sqlserver.SQLServerDriver");
            Connection cnn = DriverManager.getConnection("jdbc:sun:sqlserver://localhost:1433;databaseName=SIGECAC", "sa", "adminadmin");
            File entrada = new File("C:\\Reporte\\pac_reporteObjetivoEducaional.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteObjetivoEducaional.html"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JRHtmlExporter exporter = new JRHtmlExporter();
            exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, ouputStream);
            exporter.exportReport();
            ouputStream.write(byteArrayOutputStream.toByteArray());
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public Carrera buscarCarrera(Long id) {
        try {
            return carreraFacade.find(id);
        } catch (Exception e) {
        }
        return carreraSeleccionada;
    }

    public SelectItem[] getComboCarreras() {
        List<Carrera> listaCarrera;
        try {
            listaCarrera = new ArrayList<Carrera>();
            listaCarrera = carreraFacade.findAll();
            SelectItem[] comboCarreras = new SelectItem[listaCarrera.size()];
            for (int i = 0; i < listaCarrera.size(); i++) {
                comboCarreras[i] = new SelectItem(listaCarrera.get(i), listaCarrera.get(i).getNombre());
            }
            return comboCarreras;

        } catch (Exception e) {
            //Mensaje al usuario
            listaCarrera = new ArrayList<Carrera>();
            SelectItem[] comboCarreras = new SelectItem[1];
            comboCarreras[0] = new SelectItem(new Carrera(), "No hay Carreras");
            return comboCarreras;
        }

    }

    public ResultadoPrograma buscarResultado(Long id) throws Exception {
        try {
            return resultadoProgramaFacade.find(id);
        } catch (Exception e) {
            ResultadoPrograma rp = new ResultadoPrograma();
            rp.setIdResultadoPrograma(new Long(0));
            rp.setNombre("No hay Resultados del Programa registrados.");
            return rp;
        }
    }

    public void listarObjetivosxEstado() {
        try {
            listaObjetivos.clear();
            listaObjetivosTemporal.clear();
            listaObjetivos = delegateObjetivo.listarObjetivoEducacionalesxEstado();
        } catch (Exception ex) {
            Logger.getLogger(ResultadoProgramaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public String agregarLista() {

        try {
            if (ObjetivoEducacionalController.this.resultadoSeleccionado.getIdResultadoPrograma() != null) {
                ResultadoPrograma rp = new ResultadoPrograma();
                //rp = buscarResultado(resultadoProgramaTexto.getIdResultadoPrograma());
                rp = buscarResultado(resultadoSeleccionado.getIdResultadoPrograma());
                for (ObjetivoEducacional oe : listaObjetivosTemporal) {
                    MatrizObjetivoAdapter obj = new MatrizObjetivoAdapter();
                    obj.setObjetivoEducacional(oe);
                    obj.setResultadoPrograma(rp);
                    listaMatriz.add(obj);
                }
            } else {
                mostrarMensaje("Error: ", "Debe seleccionar por lo menos un Resultado del Programa y un Objetivo Educacional.", FacesMessage.SEVERITY_ERROR);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String eliminardeLista() {
        listaMatriz.remove(matrizSeleccionada);
        mostrarMensaje("Éxito: ", "La eliminación del Detalle la Matriz de Objetivos Educacionales se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
        return "";
    }

    public String registrarMatriz() {
        try {
            if (listaMatriz.size() > 0 && !matriz.getNombre().isEmpty() && !matriz.getNombre().equals("") && resultadoSeleccionado.getIdResultadoPrograma() != null) {
                matriz.setFecha(new Date());
                matrizAlineamientoObjetivosEducacionalesFacade.registrar(matriz);
                for (MatrizObjetivoAdapter mat : listaMatriz) {
                    DetalleMatrizAlineamientoObjetivosEducacionales det = new DetalleMatrizAlineamientoObjetivosEducacionales();
                    det.setFidObjetivoEducacional(mat.getObjetivoEducacional());
                    det.setFidResultadoPrograma(mat.getResultadoPrograma());
                    det.setFidMatrizObjetivosEducacionales(matriz);
                    detalleMatrizAlineamientoObjetivosEducacionalesFacade.registrar(det);
                }
                cancelarMatriz();
                
                mostrarMensaje("Éxito: ", "El registro de la Matriz de Objetivos Educacionales se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            }else{
                //mostrarMensaje("Error: ", "Ingrese un nombre para la Matriz de Objetivos Educacionales, seleccione un Resultado del Programa y la lista de Objetivos Educacionales a ser agregados.", FacesMessage.SEVERITY_ERROR);
               mostrarMensaje("Error: ", "Error en el registro de la Matriz de Objetivos Educacionales.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
           mostrarMensaje("Error: ", "Error en el registro de la Matriz de Objetivos Educacionales.", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarMatrizObjetivosEducacionales";
    }

    public String cancelarMatriz() {
        matriz = new MatrizAlineamientoObjetivosEducacionales();
        listaMatriz.clear();        
        return "listarMatrizObjetivosEducacionales";
    }
}
