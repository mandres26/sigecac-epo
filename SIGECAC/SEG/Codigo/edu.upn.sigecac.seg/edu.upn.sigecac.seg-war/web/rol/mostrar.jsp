<%--
    Document   : mostrar
    Created on : 02/05/2009, 09:25:52 AM
    Author     : Adminred
--%>

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
    <div class="centrar"><h1><h:outputText value="Mostrar Rol" /></h1></div>
    <br/>
    <center>
        <h:form id="frmMostrar" prependId="false">
            <h:messages/>
            <t:panelGrid columns="2">
                <t:outputLabel value="Codigo:" for="Id"/>
                <t:outputText
                    id="Id"
                    value="#{RolController.rol.idRol}"/>
                <t:outputLabel value="Nombre:" for="Nombre"/>
                <t:outputText
                    id="Nombre"
                    value="#{RolController.rol.nombre}"/>
                <t:outputLabel value="Activo:" for="Activo"/>
                <t:selectBooleanCheckbox
                    value="#{RolController.rol.estado}"
                    disabled="true"/>
                <t:panelGroup/>
                <t:panelGroup>
                    <br/>
                    <t:commandButton
                        id="btnVolver"
                        action="retornar"
                        value="Volver"/>
                </t:panelGroup>
            </t:panelGrid>
        </h:form>
    </center>
   
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>