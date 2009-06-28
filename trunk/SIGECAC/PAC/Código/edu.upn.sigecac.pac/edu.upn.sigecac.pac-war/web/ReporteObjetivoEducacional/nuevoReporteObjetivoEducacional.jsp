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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Reporte de Objetivos Educacionales" /></span>

    <t:div>
        <h:form>
            <h:panelGrid columns="4" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Habilitados: " />
                <h:selectBooleanCheckbox style="margin-left:10px" value="#{ObjetivoEducacionalController.habilitado}" />
                <h:commandButton style="font-weight: bold; margin-left: 20px; background:navy; color:white" id="btnGenerar" value="Generar" action = "#{ObjetivoEducacionalController.listarObjetivosEducacionalesxEstado}"/>
                 <h:commandLink styleClass="outputLabel" id="btnExportar" value="Exportar" accesskey="E" target="_blank" action="#{ObjetivoEducacionalController.exportarListarObjetivos}"/>
                 
           </h:panelGrid>
           <br/>
          
            <br/>
            <h:messages id="lblMessages" showDetail="true"/>

            <h:dataTable styleClass="formulario" cellpadding="10" border = "1"
                         id="objetivoEducacional" var="oe" value="#{ObjetivoEducacionalController.listaObjetivos}" >
                <f:facet name="header">
                    <h:outputLabel styleClass="outputLabel" id="lblHeader" value="Reporte de Objetivos Educacionales" />
                </f:facet>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="Código" />
                    </f:facet>
                    <h:outputText styleClass="outputText" value="#{oe.idObjetivoEducacional}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="Nombre" />
                    </f:facet>
                    <h:outputText styleClass="outputText" value="#{oe.nombre}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="Descripción" />
                    </f:facet>
                    <h:outputText styleClass="outputText" value="#{oe.descripcion}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="Estado" />
                    </f:facet>
                    <h:outputText styleClass="outputText" rendered="#{oe.estado==false}" value="Desabilitado" />
                    <h:outputText styleClass="outputText" rendered="#{oe.estado==true}" value="Habilitado" />
                </h:column>
            </h:dataTable>
            <br/>
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>