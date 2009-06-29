<%-- 
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <%@include file="WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="WEB-INF/jspf/navbar.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br /><br />
    <div class="centrar" style="font-size:large; color:navy; font-weight:bold"><h:outputText value="Bienvenido a ePortafolio" /></div>
    <br /><br />
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    <div>
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar periodo académico" />
        <br />
        <h:outputText value="********************." />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de Periódo Académico hace referencia al intervalo correspondiente a un ciclo académico. Durante un mismo año existen tres periódos académicos, de enero a febrero; de marzo a julio y de agosto a diciembre." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar esquema de grupos" />
        <br />
        <h:outputText value="********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar grupos de alumnos" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar petición de trabajo" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Publicar trabajo solicitado" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Publicar trabajo propio" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Realizar búsqueda" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Ver detalle trabajo" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Validar comentario" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Ver detalle trabajo" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar alarma" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar Rúbrica" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Ver detalle Rúbrica" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Calificar Publicación de Trabajo" />
        <br />
        <h:outputText value="*********************." />
        <br />
        <br />
        <div class="centrar">
            <a href="#"><img src="/epo/img/menu_temp.jpg" border="0"/></a>
        </div>
    </div>

    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
    <%@include file="WEB-INF/jspf/html_fin.jspf" %>
</f:view>