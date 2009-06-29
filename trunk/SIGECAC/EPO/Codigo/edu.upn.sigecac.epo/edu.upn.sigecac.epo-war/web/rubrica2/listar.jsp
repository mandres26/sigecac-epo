<%-- 
    Document   : listar
    Created on : 28/05/2009, 07:25:48 PM
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

    <span class="titulo">Listar: rubricas</span>
    <BR>
    <BR>
    <BR>

    <h:form>
        
        <t:dataTable value="#{Rubrica.listaRubrica}" var="item" styleClass="formulario">
            <h:column>
                <f:facet name="header"><h:outputText value="Nombre de la Rubrica" /></f:facet>
                <h:outputText id="nombre" value="#{item.nombre}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Codigo de la Rubrica" /></f:facet>
                <h:outputText id="inicio" value="#{item.codigo}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Ver Detalle" /></f:facet>
                <h:commandButton styleClass="commandButton" id="btnVerDetalle" value="Ver Detalle" action="#{Rubrica.verDetalleRubrica}">
                    <f:setPropertyActionListener target="#{Rubrica.rubricaSeleccionada}" value="#{item}" />
                </h:commandButton>
            </h:column>
            <f:facet name="footer">
                <h:panelGrid columns="2">
                    <h:commandButton styleClass="commandButton_Main" id="btnVolver" value="Volver" action="volver"/>
                    <h:commandButton styleClass="commandButton_Main" id="btnNuevo" value="Nuevo" action="#{Rubrica.nuevo}"/>
                </h:panelGrid>
            </f:facet>
        </t:dataTable>
        
    </h:form>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>