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

    <span class="titulo">Listar: Periodo Académico</span>
    <BR>
    <BR>
    <BR>
        <h:messages id="messages" showDetail="true" />

    <h:form>
        <t:dataTable value="#{PeriodoAcademico.listaPeriodosAcademicos}" var="item" preserveDataModel="true" varDetailToggler="detailToggler" styleClass="formulario">
            <h:column>
                <f:facet name="header"><h:outputText value="Nombre del Periodo Académico" /></f:facet>
                <h:outputText id="nombre" value="#{item.nombre}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Inicio" /></f:facet>
                <h:outputText id="inicio" value="#{item.inicio}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Fin" /></f:facet>
                <h:outputText id="fin" value="#{item.fin}" />
            </h:column>


            <h:column>
                <f:facet name="header"><h:outputText value="Editar" /></f:facet>
                <h:commandButton styleClass="commandButton_Main" id="btnEditar" value="Editar" action="periodo_editar">
                    <f:setPropertyActionListener target="#{PeriodoAcademico.periodoAcademico}" value="#{item}" />
                </h:commandButton>
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Eliminar" /></f:facet>
                <h:commandButton styleClass="commandButton_Main" id="btnEliminar" value="Eliminar" action="#{PeriodoAcademico.eliminar}">
                    <f:setPropertyActionListener target="#{PeriodoAcademico.periodoAcademico}" value="#{item}" />
                </h:commandButton>
            </h:column>


            <f:facet name="footer">
                <h:panelGrid columns="2">
                    <h:commandButton styleClass="commandButton_Main" id="btnVolver" value="Volver" action="volver"/>
                    <h:commandButton styleClass="commandButton_Main" id="btnNuevo" value="Nuevo" action="#{PeriodoAcademico.nuevo}"/>
                </h:panelGrid>
            </f:facet>
        </t:dataTable>
    </h:form>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>