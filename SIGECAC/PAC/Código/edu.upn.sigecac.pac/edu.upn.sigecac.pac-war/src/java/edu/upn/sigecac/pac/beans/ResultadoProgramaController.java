package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.gcu.bc.CicloFacadeLocal;
import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.be.Carrera;
import edu.upn.sigecac.gcu.be.Ciclo;
import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.pac.bc.DetalleMatrizAlineamientoResultadosProgramaFacadeLocal;
import edu.upn.sigecac.pac.bc.MatrizAlineamientoResultadosProgramaFacadeLocal;
import edu.upn.sigecac.pac.bc.ResultadoProgramaFacadeLocal;
import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoResultadosPrograma;
import edu.upn.sigecac.pac.be.MatrizAlineamientoResultadosPrograma;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class ResultadoProgramaController {

    @EJB
    private DetalleMatrizAlineamientoResultadosProgramaFacadeLocal detalleMatrizAlineamientoResultadosProgramaFacade;
    @EJB
    private MatrizAlineamientoResultadosProgramaFacadeLocal matrizAlineamientoResultadosProgramaFacade;
    @EJB
    private CicloFacadeLocal cicloFacade;
    @EJB
    private CursoFacadeLocal cursoFacade;
    private Ciclo cicloSeleccionado;
    private List<Curso> listaCursos;
    private List<Curso> listaCursos2;
    private ResultadoProgramaFacadeLocal local;
    public ResultadoPrograma resultado;
    public List<ResultadoPrograma> listaResultados;
    public boolean habilitado = false;
    public ResultadoPrograma resultadoSeleccionado;
    private CapacidadMedible capacidadSeleccionada;
    private Criterio criterioSeleccionado;
    private List<Criterio> listaCriterios;
    private List<Criterio> listaCriteriosTemporal;
    private Carrera carreraSeleccionada;
    private List<ResultadoPrograma> listaResultadosTemporal;
    private List<CapacidadMedible> listaCapacidades;
    private CriterioController delegateCriterio;
    private String cicloTexto;
    private String cursoTexto;
    private List<MatrizResultadoAdapter> listaMatriz;
    private MatrizResultadoAdapter matrizSeleccionada;
    private MatrizAlineamientoResultadosPrograma matriz;
    private Curso cursoSeleccionado;

    public ResultadoProgramaController() {
        local = lookupResultadoProgramaFacade();
        resultado = new ResultadoPrograma();
        listaResultados = new ArrayList<ResultadoPrograma>();
        listaResultadosTemporal = new ArrayList<ResultadoPrograma>();
        listar_Resultados();
        resultadoSeleccionado = new ResultadoPrograma();
        capacidadSeleccionada = new CapacidadMedible();
        criterioSeleccionado = new Criterio();
        carreraSeleccionada = new Carrera();
        listaCriterios = new ArrayList<Criterio>();
        listaCriteriosTemporal = new ArrayList<Criterio>();
        delegateCriterio = new CriterioController();
        cicloSeleccionado = new Ciclo();
        listaCapacidades = new ArrayList<CapacidadMedible>();
        listaCursos = new ArrayList<Curso>();
        listaCursos2 = new ArrayList<Curso>();
        listaMatriz = new ArrayList<MatrizResultadoAdapter>();
        matrizSeleccionada = new MatrizResultadoAdapter();
        matriz = new MatrizAlineamientoResultadosPrograma();
    }

    public List<CapacidadMedible> getListaCapacidades() {
        return listaCapacidades;
    }

    public void setListaCapacidades(List<CapacidadMedible> listaCapacidades) {
        this.listaCapacidades = listaCapacidades;
    }

    public MatrizAlineamientoResultadosPrograma getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizAlineamientoResultadosPrograma matriz) {
        this.matriz = matriz;
    }

    public List<MatrizResultadoAdapter> getListaMatriz() {
        return listaMatriz;
    }

    public void setListaMatriz(List<MatrizResultadoAdapter> listaMatriz) {
        this.listaMatriz = listaMatriz;
    }

    public MatrizResultadoAdapter getMatrizSeleccionada() {
        return matrizSeleccionada;
    }

    public void setMatrizSeleccionada(MatrizResultadoAdapter matrizSeleccionada) {
        this.matrizSeleccionada = matrizSeleccionada;
    }

    public String getCursoTexto() {
        return cursoTexto;
    }

    public void setCursoTexto(String cursoTexto) {
        this.cursoTexto = cursoTexto;
    }

    public String getCicloTexto() {
        return cicloTexto;
    }

    public void setCicloTexto(String cicloTexto) {
        this.cicloTexto = cicloTexto;
    }

    public Ciclo getCicloSeleccionado() {
        return cicloSeleccionado;
    }

    public void setCicloSeleccionado(Ciclo cicloSeleccionado) {
        this.cicloSeleccionado = cicloSeleccionado;
    }

    public Carrera getCarreraSeleccionada() {
        return carreraSeleccionada;
    }

    public void setCarreraSeleccionada(Carrera carreraSeleccionada) {
        this.carreraSeleccionada = carreraSeleccionada;
    }

    public Criterio getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(Criterio criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public List<ResultadoPrograma> getListaResultadosTemporal() {
        return listaResultadosTemporal;
    }

    public void setListaResultadosTemporal(List<ResultadoPrograma> listaResultadosTemporal) {
        this.listaResultadosTemporal = listaResultadosTemporal;
    }

    private ResultadoProgramaFacadeLocal lookupResultadoProgramaFacade() {
        try {
            Context c = new InitialContext();
            return (ResultadoProgramaFacadeLocal) c.lookup("java:comp/env/ResultadoProgramaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<Criterio> getListaCriterios() {
        return listaCriterios;
    }

    public void setListaCriterios(List<Criterio> listaCriterios) {
        this.listaCriterios = listaCriterios;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Curso> getListaCursos2() {
        return listaCursos2;
    }

    public void setListaCursos2(List<Curso> listaCursos2) {
        this.listaCursos2 = listaCursos2;
    }

    public List<Criterio> getListaCriteriosTemporal() {
        return listaCriteriosTemporal;
    }

    public void setListaCriteriosTemporal(List<Criterio> listaCriteriosTemporal) {
        this.listaCriteriosTemporal = listaCriteriosTemporal;
    }

    public CapacidadMedible getCapacidadSeleccionada() {
        return capacidadSeleccionada;
    }

    public void setCapacidadSeleccionada(CapacidadMedible capacidadSeleccionada) {
        this.capacidadSeleccionada = capacidadSeleccionada;
    }

    public ResultadoPrograma getResultadoSeleccionado() {
        return resultadoSeleccionado;
    }

    public void setResultadoSeleccionado(ResultadoPrograma resultadoSeleccionado) {
        this.resultadoSeleccionado = resultadoSeleccionado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public ResultadoPrograma getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoPrograma resultado) {
        this.resultado = resultado;
    }

    public List<ResultadoPrograma> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<ResultadoPrograma> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public void crearResultados(ResultadoPrograma resultado) throws Exception {
        try {
            resultado.setFid_Carrera(carreraSeleccionada.getIdCarrera());
            local.create(resultado);
            listaResultados = local.findAll();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            local = lookupResultadoProgramaFacade();
            throw new Exception(e.getStackTrace().toString(), e);

        }

    }

    public void actualizarResultados(ResultadoPrograma resultado) throws Exception {
        try {
                local.edit(resultado);
           
        } catch (Exception e) {
            local = lookupResultadoProgramaFacade();
            throw new Exception(e.getStackTrace().toString(), e);
        }

    }

    public ResultadoPrograma buscarResultados(Long id) throws Exception {
        try {
            return local.find(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<ResultadoPrograma> listarResultados() throws Exception {
        try {
            return local.findAll();
        } catch (Exception e) {
            local = lookupResultadoProgramaFacade();
            throw new Exception(e.getStackTrace().toString(), e);
        }
    }
    //Metodos del Controller

    public String listar_Resultados() {
        try {
            getListaResultados().clear();
            listaResultados = this.listarResultados();
        } catch (Exception e) {
        } finally {
            return "";
        }
    }

    public String guardar_Resultados() {
        try {
            if (carreraSeleccionada.getIdCarrera() != null && !resultado.getNombre().equals("") && !resultado.getNombre().isEmpty()) {
                this.crearResultados(resultado);
                resultado = new ResultadoPrograma();
                mostrarMensaje("Éxito: ", "El registro del Resultado del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                 mostrarMensaje("Error: ", "Ingrese un nombre de Resultado del Programa y seleccione una Carrera.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listarResultado";
    }

    public String actualizar_Resultados() {
        try {
            if (carreraSeleccionada.getIdCarrera() != null && !resultado.getNombre().equals("") && !resultado.getNombre().isEmpty()) {
//              resultado.setFidCarrera(carreraSeleccionada);
                this.actualizarResultados(resultado);
                //resultado = new ResultadoPrograma();
                this.cancelar();
                mostrarMensaje("Éxito: ", "La actualzación del Resultado del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
               
            }else{
                 mostrarMensaje("Error: ", "Ingrese un nombre de Resultado del Programa y seleccione una Carrera.", FacesMessage.SEVERITY_ERROR); 
                 return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listarResultado";
    }


    public String deshabilitarObjetivoEducacional() {
        try {
            resultado.setEstado(false);
            this.actualizarResultados(resultado);
            return "";

        } catch (Exception e) {
        }
        return "";
    }

    public String listarResultadoProgramaxEstado() {
        try {
            getListaResultados().clear();
            listaResultados = this.listarResultadoProgramasxEstado();
        } catch (Exception e) {
        } finally {
            return "";
        }
    }

    public List<ResultadoPrograma> listarResultadoProgramasxEstado() throws Exception {
        try {
            return local.listarxEstado(habilitado);
        } catch (Exception e) {
            local = lookupResultadoProgramaFacade();
            throw new Exception(e.getStackTrace().toString(), e);
        }
    }

    public String cancelar() {
        return "listarResultado";
    }

    public String navegarNuevo() {
        return "nuevoResultado";
    }

    public String navegarActualizar() {
        return "actualizarResultado";
    }

    public String navegarMostrar() {
        return "mostrarResultado";
    }

    public String navegarListar() {
        listar_Resultados();
        return "listarResultado";
    }

    public String navegarReporte() {
        return "reporte";
    }

    public SelectItem[] getComboResultados() {
        List<ResultadoPrograma> listaResultados1;
        try {
            listaResultados1 = new ArrayList<ResultadoPrograma>();
            listaResultados1 = local.findAll();
            SelectItem[] comboResultados = new SelectItem[listaResultados1.size()];
            for (int i = 0; i < listaResultados1.size(); i++) {
                comboResultados[i] = new SelectItem(listaResultados1.get(i), listaResultados1.get(i).getNombre());
            }
            return comboResultados;

        } catch (Exception e) {
            //Mensaje al usuario
            listaResultados1 = new ArrayList<ResultadoPrograma>();
            SelectItem[] comboResultados = new SelectItem[1];
            comboResultados[0] = new SelectItem(new ResultadoPrograma(), "No hay Resultados de Programa");
            return comboResultados;
        }
    }

    public String calcularCombo() {
        getComboCapacidadesxResultado();
        return "";
    }

    public SelectItem[] getComboCapacidadesxResultado() {
        List<CapacidadMedible> lista;
        try {
            lista = new ArrayList<CapacidadMedible>();
            CapacidadMedibleController delegateCapacidad = new CapacidadMedibleController();
            lista = delegateCapacidad.capacidadxResultado(resultadoSeleccionado);
            SelectItem[] comboCapacidades = new SelectItem[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                comboCapacidades[i] = new SelectItem(lista.get(i), lista.get(i).getNombre());
            }
            listarCriteriosxCapacidades();
            return comboCapacidades;

        } catch (Exception e) {
            //Mensaje al usuario
            lista = new ArrayList<CapacidadMedible>();
            SelectItem[] comboCapacidades = new SelectItem[1];
            comboCapacidades[0] = new SelectItem(new CapacidadMedible(), "No hay Capacidades Medibles");

            return comboCapacidades;
        }

    }

    public void listarCriteriosxCapacidades() {
        try {
            listaCriterios.clear();
            listaCriteriosTemporal.clear();
            listaCriterios = delegateCriterio.criterioxCapacidad(capacidadSeleccionada);
        } catch (Exception ex) {
            Logger.getLogger(ResultadoProgramaController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public String exportarListarResultados() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ResultadoProgramaController rpc = (ResultadoProgramaController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "ResultadoProgramaController");
            List<ResultadoPrograma> lista = rpc.listarResultadoProgramasxEstado();
            if (lista != null) {
                if (lista.size() > 0) {
                    File entrada = new File("C:/Reportes/pac_reporteResultadoPrograma.jasper");
                    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
                    Map p = new HashMap();
                    //este parametro se pasa cuando tenemos sub reportes que necesitan una ruta para que el compilador las pueda encontrar
                    //p.put("SUBREPORT_DIR", "C:/Reportess/");
                    p.put("usuario", "Jorge Sanchez");
                    JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), p, ds);
                    HttpServletResponse response = getResponse();
                    JRPdfExporter exporter = new JRPdfExporter();
                    List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
                    jasperPrintList.add(print);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    exporter.setParameter(JRPdfExporterParameter.METADATA_TITLE, "Sistema de Resultado Programa");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_SUBJECT, "Reporte Resultado Programa");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_AUTHOR, "Sistema de Resultado Programa - PAC");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_CREATOR, "Sistema de Gestion Academica - SIGECAC");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_KEYWORDS, "PAC,SIGECAC");
                    exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
                    exporter.setParameter(JRPdfExporterParameter.IS_COMPRESSED, Boolean.TRUE);

                    response.setContentType("application/pdf");

//                    response.setHeader("Content-Disposition", "Reporte_Alumnos");
                    Date fecha = new Date();
                    response.addHeader("Content-Disposition", "filename=" + "Reporte_Resultado_Programa_" + fecha.toString() + ".pdf");

                    exporter.getParameters().putAll(p);
                    exporter.exportReport();
                    facesContext.responseComplete();
                } else {
                    mostrarMensaje("Advertencia: ", "Asegúrese de haber registrado los Resultados del Programa", FacesMessage.SEVERITY_WARN);
                }
//            } else {
//                mostrarMensaje("Advertencia.", "Asegúrese de haber registrado algunos alumnos", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "";
    }

    public String ReporteResultadoPrograma() {
        try {
            //if (listaObjetivos != null) {
            Class.forName("com.sun.sql.jdbc.sqlserver.SQLServerDriver");
            Connection cnn = DriverManager.getConnection("jdbc:sun:sqlserver://localhost:1433;databaseName=SIGECAC", "sa", "adminadmin");
            File entrada = new File("C:\\Reporte\\pac_reporteResultadoPrograma.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream output = new FileOutputStream(new File("C:\\Reporte\\pac_reporteResultadoPrograma.pdf"));
            JasperExportManager.exportReportToPdfStream(print, output);
            output.close();
        //mostrar un mensaje con la ruta donde se guardo el archivo
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String ReporteExcel() {
        try {
            Class.forName("com.sun.sql.jdbc.sqlserver.SQLServerDriver");
            Connection cnn = DriverManager.getConnection("jdbc:sun:sqlserver://localhost:1433;databaseName=SIGECAC", "sa", "adminadmin");
            File entrada = new File("C:\\Reporte\\pac_reporteResultadoPrograma.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteResultadoPrograma.xls"));
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
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteResultadoPrograma.rtf"));
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
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteResultadoPrograma.txt"));
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
            File entrada = new File("C:\\Reporte\\pac_reporteResultadoPrograma.jasper");
            JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), null, cnn);
            OutputStream ouputStream = new FileOutputStream(new File("C:\\Reporte\\pac_reporteResultadoPrograma.html"));
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

    public Curso buscarCurso(Long id) {
        try {
            return cursoFacade.buscar(id);
        } catch (Exception e) {
            Curso c = new Curso();
            c.setIdCurso(new Long(0));
            c.setNombre("No hay Cursos registrados.");
            return c;
        }
    }

    public Ciclo buscarCiclo(Long id) {
        try {
            return cicloFacade.find(id);
        } catch (Exception e) {
            Ciclo c = new Ciclo();
            c.setIdCiclo(new Long(0));
            c.setCiclo("No hay Ciclos");
            return c;
        }
    }

    public SelectItem[] getComboCiclos() {
        List<Ciclo> listaCiclos;
        try {
            listaCiclos = new ArrayList<Ciclo>();
            listaCiclos = cicloFacade.findAll();
            SelectItem[] comboCiclos = new SelectItem[listaCiclos.size()];
            int i = 0;
            for (Ciclo c : listaCiclos) {
                comboCiclos[i++] = new SelectItem(c, c.getCiclo());
            }
            return comboCiclos;

        } catch (Exception e) {
            //Mensaje al usuario
            listaCiclos = new ArrayList<Ciclo>();
            SelectItem[] comboCiclos = new SelectItem[1];
            Ciclo c = new Ciclo();
            c.setIdCiclo(new Long(0));
            c.setCiclo("No hay Ciclos registrados");
            comboCiclos[0] = new SelectItem(null, c.getCiclo());
            return comboCiclos;
        }

    }

    public SelectItem[] getComboCursoXCiclo() {
        List<Ciclo> lista;
        try {
            cicloTexto = cicloSeleccionado.getIdCiclo().toString();
            lista = cicloFacade.findByName(cicloSeleccionado.getCiclo());
            SelectItem[] comboCursoCiclo = new SelectItem[lista.size()];
            int i = 0;
            for (Ciclo c : lista) {
                comboCursoCiclo[i++] = new SelectItem(c.getFkCurso(), c.getFkCurso().getNombre());
            }
            return comboCursoCiclo;

        } catch (Exception e) {
            //Mensaje al usuario
            lista = new ArrayList<Ciclo>();
            SelectItem[] comboCursoCiclo = new SelectItem[1];
            comboCursoCiclo[0] = new SelectItem("0", "No hay Cursos.");
//            cambiarListaCriterios();
            return comboCursoCiclo;
        }

    }

    public String agregarLista() {
        try {
            if (ResultadoProgramaController.this.cursoSeleccionado.getIdCurso() != null){
            Curso cur = new Curso();
            cursoTexto = cursoSeleccionado.getIdCurso().toString();
            cur = buscarCurso(new Long(Integer.parseInt(cursoTexto)));

            for (Criterio c : listaCriteriosTemporal) {
                MatrizResultadoAdapter res = new MatrizResultadoAdapter();
                res.setCriterio(c);
                res.setCurso(cur);
                listaMatriz.add(res);
            }
            }else{
                mostrarMensaje("Error: ", "Debe seleccionar por lo menos un Criterio y un Curso.", FacesMessage.SEVERITY_ERROR);
            }
            
        } catch (Exception e) {
        }

        return "";
    }

    public String eliminardeLista() {
        listaMatriz.remove(matrizSeleccionada);
        mostrarMensaje("Éxito: ", "La eliminación de la Matriz de Resultados del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
        return "";
    }

    public String guardar_Matriz() {
        try {
            if (listaMatriz.size() > 0 && !matriz.getNombre().equals("") && !matriz.getNombre().isEmpty()) {
                matriz.setFecha(new Date());
                matrizAlineamientoResultadosProgramaFacade.create(matriz);
                for (MatrizResultadoAdapter mat : listaMatriz) {
                    DetalleMatrizAlineamientoResultadosPrograma det = new DetalleMatrizAlineamientoResultadosPrograma();
                    det.setFidCriterio(mat.getCriterio());
                    det.setFid_Curso(mat.getCurso().getIdCurso());
                    det.setFidMatrizResultadosPrograma(matriz);
                    detalleMatrizAlineamientoResultadosProgramaFacade.create(det);

                }
                cancelarMatriz();
                mostrarMensaje("Éxito: ", "El registro de la Matriz de Resultados del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            }else{
                mostrarMensaje("Error: ", "Error en el registro de la Matriz de Resultados del Programa.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return"";
        }
        return "listarMatrizResultadoPrograma";
    }

    public String cancelarMatriz() {
        matriz = new MatrizAlineamientoResultadosPrograma();
        
        listaMatriz.clear();
        return "listarMatrizResultadoPrograma";
        
    }

    public Curso getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(Curso cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    public void mostrarMensaje(String resumen, String detalle, FacesMessage.Severity severidad) {
        try {
            FacesMessage fm = new FacesMessage(severidad, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        }
    }
}
