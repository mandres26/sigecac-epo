<%--
    Document   : nuevoCurso
    Created on : 12/04/2009, 05:21:30 PM
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
        <h1>Registrar Nuevo Curso</h1>
        <h:messages/>
        <h:form id="frmNuevoCursos" prependId="false">
            <h:panelGrid columns="2" >
                
                <h:outputLabel value="Codigo Curso"/>
                <h:inputText id="Codigo" value="#{Curso.curso.codigo}" >
                    <f:validateLength
                        maximum="6"
                        minimum="2"/>
                    <f:validator
                        validatorId="textoValidator"/>
                </h:inputText>
                <h:outputLabel value="Nombre"/>
                <h:inputText id="Nombre" value="#{Curso.curso.nombre}" >
                    <f:validateLength
                        maximum="20"
                        minimum="5"/>
                    <f:validator
                        validatorId="textoValidator"/>
                </h:inputText>

                <h:outputLabel value="Abreviatura"/>
                <h:inputText id="Abreviatura" value="#{Curso.curso.abreviatura}" >
                    <f:validateLength
                        maximum="8"
                        minimum="2"/>
                    <f:validator
                        validatorId="textoValidator"/>
                </h:inputText>

                <h:outputLabel value="Descripcion"/>
                <h:inputTextarea id="Descripcion"  rows="10" cols="30" value="#{Curso.curso.descripcion}">
                    <f:validateLength
                        maximum="100"
                        minimum="10"/>
                    <f:validator
                        validatorId="textoValidator"/>
                </h:inputTextarea>

                <h:outputLabel value="Creditos"/>
                <h:inputText id="txtCreditos" value="#{Curso.curso.nrocreditos}" required="true" >
                   <f:validateLongRange minimum="1" maximum="10" />

                </h:inputText>

                <h:outputLabel value="HorasTecnicas"/>
                <h:inputText id="txtHorasTecnica" value="#{Curso.curso.horastecnicas}"  required="true" >
                      <f:validateLength
                        maximum="3"
                        minimum="1"/>
                   
                </h:inputText>

                <h:outputLabel value="HorasPractica"/>
                <h:inputText id="txtHorasPractica" value="#{Curso.curso.horaspracticas}" required="true" >
                     <f:validateLongRange minimum="1" maximum="10" />

                </h:inputText>

                <h:outputLabel value="HorasLaboratorio"/>
                <h:inputText id="txtHorasLaboratorio" value="#{Curso.curso.horaslaboratorio}" required="true" >
                   <f:validateLongRange minimum="1" maximum="10" />
             
                </h:inputText>

                <h:outputLabel value="SubArea"/>
                <h:selectOneMenu  value="#{Curso.subArea.idSubArea}">
                    <f:selectItems value="#{Curso.listaSubAreas}" />
                </h:selectOneMenu>

                .          <h:panelGroup />
                <h:panelGroup>
                    <h:commandButton id="btnGuardar" action="#{Curso.crearCurso}" value="Guardar" />
                    <h:commandButton id="btnLimpiar"  action="listar" value="Cancelar" />
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