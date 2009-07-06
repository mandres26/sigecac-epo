<%--
    Document   : seleccionarPublicar
    Created on : 13/04/2009, 02:49:44 AM
    Author     : texai
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <h:form enctype="multipart/form-data">

        <BR>
        <BR>

        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            <h:outputLabel styleClass="outputLabel" for="txtTitulo" value="Título del Trabajo" />
            <h:inputText styleClass="inputText" value="#{Publicacion.publicacion.titulo}" id="txtTitulo" required="false" />
            <h:outputText styleClass="outputText" value="Nombre Descriptivo de la Publicación del Trabajo" />

            <h:outputLabel styleClass="outputLabel" value="Archivo a subir"/>
            <t:inputFileUpload styleClass="inputFileUpload" id="file2" value="#{Publicacion.archivo}" onselect="submit()" />
            <h:outputText styleClass="outputText" value="Especifique la ruta del archivo a subir" />

            <h:outputLabel styleClass="outputLabel" for="txtKeywords" value="Palabras clave (separadas por coma)" />
            <h:inputText styleClass="inputText" value="#{Publicacion.publicacion.keywords}" id="txtKeywords" required="false" />
            <h:outputText styleClass="outputText" value="Ingrese las palabras clave relevantes a su publicación. Estas palabras claves se usaran para las búsquedas." />

            <h:outputLabel styleClass="outputLabel" for="txtAbstract" value="Abstract (5000 caracteres max.)"/>
            <h:inputTextarea styleClass="inputTextarea" value="#{Publicacion.publicacion.resumen}" id="txtAbstract" required="false" />
            <h:outputText styleClass="outputText" value="Ingrese un abtract de no mas de 5000 caracteres." />

            <h:outputLabel styleClass="outputLabel" for="bitComentarios" value="¿Deseas que tu publicacion pueda recibir comentarios?" />
            <h:panelGroup>
                <h:selectBooleanCheckbox id="bitComentarios" value="#{Publicacion.publicacion.recibirComentaios}" />
                <h:outputLabel for="bitComentarios" value="Si deseo recibir comentarios" />
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="Marque esta casilla si es que usted desea recibir comentarios de otros usuarios de ePortafolio." />


            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="PUBLICAR" action="#{Publicacion.guardarTrabajoPropio}" />
                <h:commandButton styleClass="commandButton" value="Volver" action="volver" />
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>
    <br>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>