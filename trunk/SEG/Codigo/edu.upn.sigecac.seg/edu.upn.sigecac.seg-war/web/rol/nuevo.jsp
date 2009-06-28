<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
<%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
<%@include file="../WEB-INF/jspf/cabecera.jspf" %>
<%@include file="../WEB-INF/jspf/navbar.jspf" %>
<%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
<%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
<%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
<%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

<br/>
<div class="centrar">
    <span class="titulo"><h:outputText value="Registro de Rol" /></span>
    <BR>
    <BR>
    <BR>

    <center>
        <h:form id="frmRegistro" prependId="false">
        <h:messages styleClass="error_message" />
        <br/>
        <t:panelGrid columns="2">
        <t:outputLabel value="Nombre:" for="Nombre"/>
        <t:panelGroup>
            <t:inputText
                id="Nombre"
                value="#{RolController.rol.nombre}"
                size="40">
            <f:validateLength
                maximum="70"
                minimum="5" />
            <f:validator
                validatorId="textoValidator"/>
            </t:inputText>
        </t:panelGroup>
        <t:outputLabel value="Activo:" for="Activo"/>
        <t:selectBooleanCheckbox
            id="Activo"
            value="#{RolController.rol.estado}" />
        <h:panelGroup/>
        <t:panelGroup>
            <br>
            <t:commandButton id="btnGuardar"
                             action="#{RolController.guardar}"
                             value="Guardar"/>
            <t:commandButton id="btnCancelar"
                             action="retornar"
                             value="Cancelar"/>
        </t:panelGroup>
        </t:panelGrid>
        </h:form>
    </center>

</div>

<%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
<%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
<%@include file="../WEB-INF/jspf/pie.jspf" %>
<%@include file="../WEB-INF/jspf/html_fin.jspf" %>

</f:view>