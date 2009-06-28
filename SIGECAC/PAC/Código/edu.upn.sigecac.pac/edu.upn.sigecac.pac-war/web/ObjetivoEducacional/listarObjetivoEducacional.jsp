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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Listar Objetivos Educacionales" /></span>

    <t:div>
        <h:form id="frmListarObjetivoEducacional">

           <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
            <h:panelGrid columns="1" width="91%">
                <h:commandButton style="font-weight: bold; margin-left:270px; margin-right: auto; background:navy; color:white" accesskey="N" id="btnNuevo" value="Nuevo" action="#{ObjetivoEducacionalController.navegarNuevo}"  />
            </h:panelGrid>
           </fieldset>
            <br/>
            <br/>         
            <h:messages id="lblMessages" showDetail="true"/>

            <h:dataTable styleClass="formulario" cellpadding="10"
                         id="objetivoEducacional" var="oe" border="1" value="#{ObjetivoEducacionalController.listaObjetivos}">
    
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

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="" />
                    </f:facet>
                    <h:commandButton id="btnMostrar" value="Mostrar" action="#{ObjetivoEducacionalController.navegarMostrar}" image="/img/ver.png" title="Mostrar">
                        <f:setPropertyActionListener target="#{ObjetivoEducacionalController.objetivo}" value="#{oe}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="" />
                    </f:facet>
                    <h:commandButton id="btnActualizar" value="Actualizar" action="#{ObjetivoEducacionalController.navegarActualizar}" image="/img/editar.png" title="Actualizar">
                        <f:setPropertyActionListener target="#{ObjetivoEducacionalController.objetivo}" value="#{oe}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel styleClass="outputLabel" value="" />
                    </f:facet>
                    <h:commandButton id="btnEliminar" value="Eliminar" action="#{ObjetivoEducacionalController.deshabilitarObjetivoEducacional}" image="/img/eliminar.png" title="Deshabilitar">
                        <f:setPropertyActionListener target="#{ObjetivoEducacionalController.objetivo}" value="#{oe}" />
                    </h:commandButton>
                </h:column>
            </h:dataTable>
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>

