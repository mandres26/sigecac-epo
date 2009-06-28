 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.be.Peticion;
import java.io.InputStream;
import java.util.List;
import javax.naming.Context;
import edu.upn.sigecac.epo.bc.PeticionLocal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.myfaces.custom.fileupload.UploadedFile;

/**
 *
 * @author texai
 */
public class PeticionController {

    private PeticionLocal local;
    private List<Peticion> listaPeticiones;
    private Peticion peticion;
    private String peticion_horaInicio;
    private String peticion_horaFin;
    private String peticion_fechaInicio;
    private String peticion_fechaFin;
    private String selAsignacion = "curso";
    private String selModo = "individual";
    private Peticion itemSeleccionado;
    private UploadedFile archivo;

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public Peticion getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(Peticion itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
    }

    public String getPeticion_fechaFin() {
        return peticion_fechaFin;
    }

    public void setPeticion_fechaFin(String peticion_fechaFin) {
        this.peticion_fechaFin = peticion_fechaFin;
    }

    public String getPeticion_fechaInicio() {
        return peticion_fechaInicio;
    }

    public void setPeticion_fechaInicio(String peticion_fechaInicio) {
        this.peticion_fechaInicio = peticion_fechaInicio;
    }

    public String getPeticion_horaFin() {
        return peticion_horaFin;
    }

    public void setPeticion_horaFin(String peticion_horaFin) {
        this.peticion_horaFin = peticion_horaFin;
    }

    public String getPeticion_horaInicio() {
        return peticion_horaInicio;
    }

    public void setPeticion_horaInicio(String peticion_horaInicio) {
        this.peticion_horaInicio = peticion_horaInicio;
    }

    public Peticion getPeticion() {
        return peticion;
    }

    public void setPeticion(Peticion peticion) {
        this.peticion = peticion;
    }

    public String nuevo() {
        peticion = new Peticion();
        return "peticion_Nuevo";
    }

    public String guardar() {
        try {
            /*
            //DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat dfm = new SimpleDateFormat("MM-dd-yy HH:mm:ss");
            DateFormat dfm2 = new SimpleDateFormat("MM-dd-yy");
            Date inicio = dfm.parse( dfm2.parse(peticion_fechaInicio).toString() + " " + peticion_horaInicio);
            Date fin = dfm.parse( dfm2.parse(peticion_fechaFin).toString() + " "  + peticion_horaFin);
            this.peticion.setInicio(inicio);
            this.peticion.setFin(fin);
             */

            /*FILE UPLOAD*/
            InputStream stream = archivo.getInputStream();
            long size = archivo.getSize();
            byte [] buffer = new byte[(int)size];
            stream.read(buffer, 0, (int)size);
            stream.close();
            peticion.setReferencia(buffer);
            

            //this.peticion.setInicio(new Date());
            //this.peticion.setFin(new Date());
            local.registrar(peticion);
        } catch (Exception ex) {
            Logger.getLogger(PeticionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }

    public List<Peticion> listar() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public List<Peticion> getListaPeticiones() {
        listaPeticiones = listar();
        return listaPeticiones;
    }

    public void setListaPeticiones(List<Peticion> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }

    public String getSelModo() {
        return selModo;
    }

    public void setSelModo(String selModo) {
        this.selModo = selModo;
    }

    public PeticionController() {
        local = lookup();
    }

    public String getSelAsignacion() {
        return selAsignacion;
    }

    public void setSelAsignacion(String selAsignacion) {
        this.selAsignacion = selAsignacion;
    }

    private PeticionLocal lookup() {
        try {
            Context c = new InitialContext();
            return (PeticionLocal) c.lookup("java:comp/env/PeticionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

