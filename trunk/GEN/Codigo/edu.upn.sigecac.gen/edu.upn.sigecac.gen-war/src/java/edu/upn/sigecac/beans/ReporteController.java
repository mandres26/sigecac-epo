/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.AlumnoFacadeLocal;
import edu.upn.sigecac.gen.be.Alumno;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

/**
 *
 * @author Administrador
 */
public class ReporteController {

    public static synchronized HttpServletResponse getResponse() {
        ExternalContext ctx;
        try {
            ctx = FacesContext.getCurrentInstance().getExternalContext();
            return (HttpServletResponse) ctx.getResponse();
        } catch (Exception ex) {
            return null;
        }
    }

    public String exportarListarAlumnos() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            AlumnoController alumnoController = (AlumnoController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "AlumnoController");
            List<Alumno> lista = alumnoController.getAlumnos();
            if (lista != null) {
                if (lista.size() > 0) {

                    File entrada = new File("C:/Reportes/gen_listaAlumnos.jasper");
                    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
                    Map p = new HashMap();
                    //este parametro se pasa cuando tenemos sub reportes que necesitan una ruta para que el compilador las pueda encontrar
                    //p.put("SUBREPORT_DIR", "C:/Reportes/");
                    JasperPrint print = JasperFillManager.fillReport(new FileInputStream(entrada), p, ds);
                    HttpServletResponse response = getResponse();
                    JRPdfExporter exporter = new JRPdfExporter();
                    List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
                    jasperPrintList.add(print);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    exporter.setParameter(JRPdfExporterParameter.METADATA_TITLE, "Sistema Integrado de Administración Tributaria Municipal - SIAT");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_SUBJECT, "Servicio de Administración Tributaria de Trujillo - SATT");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_AUTHOR, "Servicio de Administración Tributaria de Trujillo - SATT");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_CREATOR, "Sistema Integrado de Administración Tributaria Municipal - SIAT");
                    exporter.setParameter(JRPdfExporterParameter.METADATA_KEYWORDS, "SATT,SAT,Tributaria,Impuesto,Impuestos,Renta,Papeletas,Vehículo,Vehícular,Predio,Fiscalización,Descarga");
                    exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
                    exporter.setParameter(JRPdfExporterParameter.IS_COMPRESSED, Boolean.TRUE);

                    response.setContentType("application/pdf");
//                    response.setHeader("Content-Disposition", "Reporte_Alumnos");
                    Date fecha = new Date();
                    response.addHeader("Content-Disposition", "filename=" + "Reporte_Alumnos_" + fecha.toString() + ".pdf");

                    exporter.getParameters().putAll(p);
                    exporter.exportReport();
                    facesContext.responseComplete();
                } else {
                    mostrarMensaje("Advertencia.", "Asegúrese de haber registrado algunos alumnos", FacesMessage.SEVERITY_WARN);
                }
            } else {
                mostrarMensaje("Advertencia.", "Asegúrese de haber registrado algunos alumnos", FacesMessage.SEVERITY_WARN);
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

    private AlumnoFacadeLocal lookupAlumnoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AlumnoFacadeLocal) c.lookup("java:comp/env/AlumnoFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
