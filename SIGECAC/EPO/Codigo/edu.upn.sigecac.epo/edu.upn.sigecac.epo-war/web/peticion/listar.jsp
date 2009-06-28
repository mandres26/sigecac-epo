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
    <%@include file="../WEB-INF/jspf/menu_secundario.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <span class="titulo"><h:outputText value="Trabajos Solicitados" /></span>
    <BR>
    <BR>
    <BR>

    <h:form>

        <t:dataTable value="#{Peticion.listaPeticiones}" var="item" preserveDataModel="true" varDetailToggler="detailToggler" styleClass="formulario">
            <h:column>
                <f:facet name="header"><h:outputText value="Título de la Petición" /></f:facet>
                <h:outputText id="nombre" value="#{item.nombre}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Tipo Archivo" /></f:facet>
                <h:outputText id="tipoArchivo" value="#{item.fidTipoArchivo.nombre}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Inicio" /></f:facet>
                <h:outputText id="inicio" value="#{item.inicio}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Fin" /></f:facet>
                <h:outputText id="fin" value="#{item.fin}" />
            </h:column>
            <f:facet name="footer">
                <h:panelGrid columns="2">
                    <h:commandButton styleClass="commandButton_Main" id="btnVolver" value="Volver" action="volver"/>
                    <h:commandButton styleClass="commandButton_Main" id="btnNuevo" value="Nuevo" action="#{Peticion.nuevo}"/>
                </h:panelGrid>
            </f:facet>
        </t:dataTable>

    </h:form>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>