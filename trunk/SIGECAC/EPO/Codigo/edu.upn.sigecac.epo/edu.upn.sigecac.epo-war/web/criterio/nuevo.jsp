<%--
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
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
    <%@include file="../WEB-INF/jspf/menu_secundario.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br /><div class="titulo">Nuevo Criterio</div><br /><br />


    <h:form>
        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">



            <h:outputLabel styleClass="outputLabel" for="txtPeso" value="Peso" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:inputText styleClass="inputTextSmall" id="txtPeso" required="false" value="#{Rubrica.criterioEvaluacion.peso}" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" rendered="#{Rubrica.criterioSeleccionado!=null}" />

            <h:outputLabel styleClass="outputLabel" for="txtComentario" value="Comentarios" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:inputTextarea styleClass="inputTextarea"  id="txtComentario" required="false" value="#{Rubrica.criterioEvaluacion.comentario}" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:outputText styleClass="outputText" value="Descripción más completa de que es exactamente lo que se solicita al alumno o grupo." rendered="#{Rubrica.criterioSeleccionado!=null}" />



            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Ok" action="#{Rubrica.agregarCriterio}" />
                <h:commandButton styleClass="commandButton" id="btnVolver" value="Volver" action="volver"/>
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>


    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>