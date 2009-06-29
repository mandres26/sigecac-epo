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
    
    <br /><div class="titulo">Nueva R&uacute;brica</div><br /><br />

    <h:form>
        <h:panelGrid columns="1" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
            <h:panelGrid columns="2" styleClass="no-border" cellpadding="10" cellspacing="0" border="0">
                <h:panelGroup>
                    <h:outputLabel styleClass="outputLabel" for="txtCodigo" value="Código" />&nbsp;
                    <h:inputText styleClass="inputTextSmall" value="#{Rubrica.rubrica.codigo}" id="txtCodigo" required="false" size="3" />
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputLabel styleClass="outputLabel" for="txtNombre" value="Nombre" />&nbsp;
                    <h:inputText styleClass="inputText" value="#{Rubrica.rubrica.nombre}" id="txtNombre2" required="false"  />
                </h:panelGroup>
            </h:panelGrid>
            <t:dataTable value="#{Rubrica.listaCriteriosEvaluacion}" var="item" styleClass="formulario">
                <h:column>
                    <f:facet name="header"><h:outputText value="Criterio" /></f:facet>
                    <h:outputText id="nombre" value="#{item.fidPACCriterio.nombre}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Peso" /></f:facet>
                    <h:outputText id="inicio" value="#{item.peso}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Comentario" /></f:facet>
                    <h:outputText id="inicio2" value="#{item.comentario}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Eliminar" /></f:facet>
                    <h:commandButton styleClass="commandButton" id="btnEliminar" value="Eliminar" action="#{Rubrica.eliminarCriterio}">
                        <f:setPropertyActionListener target="#{Rubrica.criterioEvaluacionEliminar}" value="#{item}" />
                    </h:commandButton>
                </h:column>

            <f:facet name="footer">
                <h:panelGrid columns="1">
                    <h:commandButton styleClass="commandButton" id="btnAgregarCriterio" value="Agregar Criterio" action="#{Rubrica.nuevoCE2}"/>
                </h:panelGrid>
            </f:facet>

            </t:dataTable>
            <h:panelGroup>
                <h:commandButton styleClass="commandButton" id="btnVolver4" value="Volver" action="volver"/>
                <h:commandButton styleClass="commandButton_Main" id="btnVolver5" value="Guardar" action="#{Rubrica.registrar}"/>
            </h:panelGroup>
        </h:panelGrid>
        
        <br /><br />
    </h:form>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>