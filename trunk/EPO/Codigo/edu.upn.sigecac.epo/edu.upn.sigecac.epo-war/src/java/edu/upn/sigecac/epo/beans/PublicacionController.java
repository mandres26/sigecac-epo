/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.PublicacionLocal;
import edu.upn.sigecac.epo.be.Peticion;
import edu.upn.sigecac.epo.be.Publicacion;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.myfaces.custom.fileupload.UploadedFile;

/**
 *
 * @author Programador
 */
public class PublicacionController {

    private PublicacionLocal local;
    private Publicacion publicacion;
    private List<Publicacion> listaPublicaciones;
    private String cadenaDeBusqueda;
    private Peticion peticionSeleccionada;
    private Publicacion publicacionSeleccionada;
    private UploadedFile archivo;

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }


    public Publicacion getPublicacionSeleccionada() {
        return publicacionSeleccionada;
    }

    public void setPublicacionSeleccionada(Publicacion publicacionSeleccionada) {
        this.publicacionSeleccionada = publicacionSeleccionada;
    }


    public void setListaPublicaciones(List<Publicacion> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }

    public Peticion getPeticionSeleccionada() {
        return peticionSeleccionada;
    }

    public void setPeticionSeleccionada(Peticion peticionSeleccionada) {
        this.peticionSeleccionada = peticionSeleccionada;
    }

    public String getCadenaDeBusqueda() {
        return cadenaDeBusqueda;
    }

    public void setCadenaDeBusqueda(String cadenaDeBusqueda) {
        this.cadenaDeBusqueda = cadenaDeBusqueda;
    }

    public List<Publicacion> getResultadoBusqueda() {
        return resultadoBusqueda;
    }

    public void setResultadoBusqueda(List<Publicacion> resultadoBusqueda) {
        this.resultadoBusqueda = resultadoBusqueda;
    }
    private List<Publicacion> resultadoBusqueda;

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public String calificarPublicacion(){
        
        return "publicacion_calificar";
    }

    public PublicacionController() {
        local = lookup();
    }


    public List<Publicacion> listar() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public List<Publicacion> getListaPublicaciones() {
        listaPublicaciones = listar();
        return listaPublicaciones;
    }

    private PublicacionLocal lookup() {
        try {
            Context c = new InitialContext();
            return (PublicacionLocal) c.lookup("java:comp/env/PublicacionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String nuevo() {
        publicacion = new Publicacion();
        publicacion.setFidPeticion(peticionSeleccionada);
        return "publicacion_nuevo";
    }

    public String guardar(){
        try {
            /*FILE UPLOAD*/
            InputStream stream = archivo.getInputStream();
            long size = archivo.getSize();
            byte [] buffer = new byte[(int)size];
            stream.read(buffer, 0, (int)size);
            stream.close();
            publicacion.setArchivo(buffer);
            
            local.registrar(publicacion);
            
        } catch (Exception ex) {
            Logger.getLogger(PeticionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }




    public String realizarBusqueda() {
        try {
            this.resultadoBusqueda = local.buscarPorTitulo(cadenaDeBusqueda);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return "publicacion_resultadosBusqueda";
    }



}
