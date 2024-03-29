<%--
    Document   : index
    Created on : 26/04/2009, 1:30:08 PM
    Author     : Nancy Espinola
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
    <br /><br />
    <span class="titulo">Nueva Esquema de Grupo</span>
    <br /><br /><br />


    <h:form>

        <h:messages showDetail="true" />


        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            
            <h:outputLabel styleClass="outputLabel" for="cboClase" value="Clase" />
            <h:selectOneMenu id="cboClase" styleClass="selectOneMenu" value="#{EsquemaGrupo.selClase}" converter="ClaseConverter">
                <f:selectItems value="#{Clase.itemsClases}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Seleccionar a que clase se esta asignando este Trabajo" />


            <h:outputLabel styleClass="outputLabel" for="txtNombre" value="Nombre" />
            <h:inputText styleClass="inputText jqNombre" id="txtNombre" required="true" value="#{EsquemaGrupo.esquemaGrupo.nombre}" />
            <h:outputText styleClass="outputText" value="Ingresar el Nombre del Esquema de Grupos que va a registrar" />


            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Guardar" action="#{EsquemaGrupo.Registrar}" />
                <h:commandButton styleClass="commandButton_Main" value="Volver" action="volver" />
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>


    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>