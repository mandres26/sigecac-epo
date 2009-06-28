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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Registrar Nivel" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />
        <h:form>
            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
                <h:panelGrid columns="2" width="91%">
                    <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" id="btnGuardar" value="Guardar" accesskey="G" action="#{NivelController.registrar}" />
                    <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" id="btnCancelar" value="Cancelar" accesskey="C" action="#{NivelController.cancelar}" />
                </h:panelGrid>
            </fieldset>
            <br/>
            <br/>

            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblIdCriterio" for="txtIdCriterio" value="Nombre de Criterio: " />
                <h:inputText styleClass="inputText" id="txtIdCriterio" value="#{NivelController.nivel.fidCriterio.idCriterio}" readonly="true" />
                <h:outputLabel styleClass="outputLabel" id="lblNombreCriterio" value="Nombre de Criterio: " />
                <h:inputText styleClass="inputText" id="txtNombreCriterio" value="#{NivelController.nivel.fidCriterio.nombre}" readonly="true"/>
                <%--h:commandButton style="margin-right: 60px" title= "Buscar" id="btnBuscar" image="/img/buscar.png" accesskey="B" action="#{NivelController.listarCriterio}" /--%>
            </h:panelGrid>
            <%--h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Código de Criterio: " />
                <h:inputText styleClass="inputText" id="txtIdCriterio" value="#{NivelController.criterioSeleccionado.idCriterio}" readonly="true"/>

                <h:outputLabel styleClass="outputLabel" value="Nombre de Criterio: " />
                <h:selectOneMenu value="#{NivelController.criterioSeleccionado}" onchange="submit()">
                    <f:selectItem itemLabel="Seleccione un Criterio..." />
                    <f:selectItems value="#{NivelController.comboCriteriosxCapacidad}" />
                </h:selectOneMenu>
            </h:panelGrid--%>
            <br/>
            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblNombre" for="txtNombre" value="Nombre:" />
                <h:inputText styleClass="inputText" id="txtNombre" value="#{NivelController.nivel.nombre}" >
                    <f:validateLength
                        maximum="100"
                        />
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputText>

                <h:outputLabel styleClass="outputLabel" id="lblDescripcion" for="itaDescripcion" value="Descripción: " />
                <h:inputTextarea styleClass="inputTextarea" id = "itaDescripcion" value="#{NivelController.nivel.descripcion}" cols="50" >
                    <f:validateLength
                        maximum="255"
                        />
                   <f:validator validatorId="alphaNumValidator"/>
                </h:inputTextarea>

            </h:panelGrid>
        <br/>
        </h:form>
    </t:div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>

