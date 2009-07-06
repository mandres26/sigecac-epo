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
    <style>
        .smallBox{
            /*width: 142px !important;*/
            height: 50px !important;
        }
    </style>

    <br /><div class="titulo">Nuevo Criterio</div><br /><br />


    <h:form styleClass="formulario">

        <h:panelGrid columns="3" cellpadding="10" cellspacing="0" border="0">

            <h:outputLabel styleClass="outputLabel" for="txtNombre" value="Nombre" />
            <h:inputText styleClass="inputTextSmall" id="txtNombre" required="true" value="#{Rubrica.criterioEvaluacion.nombre}" />
            <h:outputText styleClass="outputText" value="" />

            <h:outputLabel styleClass="outputLabel" for="txtPeso" value="Peso" />
            <h:inputText styleClass="inputTextSmall" id="txtPeso" required="false" value="#{Rubrica.criterioEvaluacion.peso}" />
            <h:outputText styleClass="outputText" value="Ingrese el peso del criterio" />

            <h:outputLabel styleClass="outputLabel" for="txtComentario" value="Comentarios" />
            <h:inputTextarea styleClass="inputTextarea"  id="txtComentario" required="false" value="#{Rubrica.criterioEvaluacion.comentario}" />
            <h:outputText styleClass="outputText" value="Ingrese un comentario." />



            <h:outputLabel styleClass="outputLabel" for="txtN1" value="Nivel 1" />
            <h:panelGroup>
                <h:outputLabel styleClass="outputLabel" for="txtN1" value="Nombre" /><br />
                <h:inputText styleClass="inputTextSmall" id="txtN1" required="true" value="#{Rubrica.n1.nombre}" />
                <h:outputLabel styleClass="outputLabel" for="txtN1d" value="Descripción" /><br /><br />
                <h:inputTextarea styleClass="inputTextarea smallBox"  id="txtN1d" required="false" value="#{Rubrica.n1.descripcion}" />
                
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="" />


            <h:outputLabel styleClass="outputLabel" for="txtN2" value="Nivel 2" />
            <h:panelGroup>
                <h:outputLabel styleClass="outputLabel" for="txtN2" value="Nombre" /><br />
                <h:inputText styleClass="inputTextSmall" id="txtN2" required="true" value="#{Rubrica.n2.nombre}" />
                <h:outputLabel styleClass="outputLabel" for="txtN2d" value="Descripción" /><br />
                <h:inputTextarea styleClass="inputTextarea smallBox"  id="txtN2d" required="false" value="#{Rubrica.n2.descripcion}" />
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="" />


            <h:outputLabel styleClass="outputLabel" for="txtN3" value="Nivel3" />
            <h:panelGroup>
                <h:outputLabel styleClass="outputLabel" for="txtN3" value="Nombre" /><br />
                <h:inputText styleClass="inputTextSmall" id="txtN3" required="true" value="#{Rubrica.n3.nombre}" />
                <h:outputLabel styleClass="outputLabel" for="txtN3d" value="Descripción" /><br />
                <h:inputTextarea styleClass="inputTextarea smallBox"  id="txtN3d" required="false" value="#{Rubrica.n3.descripcion}" />
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="" />


            <h:outputLabel styleClass="outputLabel" for="txtN4" value="Nivel 4" />
            <h:panelGroup>
                <h:outputLabel styleClass="outputLabel" for="txtN4" value="Nombre" /><br />
                <h:inputText styleClass="inputTextSmall" id="txtN4" required="true" value="#{Rubrica.n4.nombre}" />
                <h:outputLabel styleClass="outputLabel" for="txtN4d" value="Descripción" /><br />
                <h:inputTextarea styleClass="inputTextarea smallBox"  id="txtN4d" required="false" value="#{Rubrica.n4.descripcion}" />
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="" />

            

            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Ok" action="#{Rubrica.agregarCriterio2}" />
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