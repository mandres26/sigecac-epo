<%--
    Document   : nuevoSubArea
    Created on : 12/04/2009, 05:28:04 PM
    Author     : supervisor
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br /><br /><br />
    <div class="centrar">

        <h1>Editar Edicion de Curso</h1>
        <h:form  id="frmEdicionEdicion" prependId="false">
            <h:messages/>
            <h:panelGrid columns="2" >
                <h:outputLabel value="Cursos"/>
                <h:selectOneMenu id="cmbArea" value="#{EdicionCurso.edicionCurso.fxIdcurso.idCurso}">
                    <f:selectItems value="#{EdicionCurso.listaCursos}" ></f:selectItems>
                </h:selectOneMenu>

                <h:outputLabel value="Edicion"/>
                <h:inputText id="Edicion" value="#{EdicionCurso.edicionCurso.edicion}" >
                    <f:validateLength
                        maximum="6"
                        minimum="6"/>
                    <f:validator
                        validatorId="numeroValidator"/>
                </h:inputText>
                <h:outputLabel value="Descripcion"/>
                <h:inputTextarea id="Descripcion"  rows="10" cols="30" value="#{EdicionCurso.edicionCurso.descripcion}">
                    <f:validateLength
                        maximum="59"
                        minimum="10"/>
                    <f:validator
                        validatorId="textoValidator"/>
                </h:inputTextarea>

                <h:panelGroup />
                <h:panelGroup>
                    <h:commandButton id="btnGuardar" action="#{EdicionCurso.editarEdicionCurso}" value="Guardar" />
                    <h:commandButton id="btnLimpiar" action="listar_edicion" value="Cancelar" />
                </h:panelGroup>

            </h:panelGrid>
        </h:form>
    </div>
    <br /><br /><br /><br /><br /><br />
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
