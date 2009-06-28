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
    <!--<script language="javascript" src="/epo/_js/periodo_nuevo.js" type="text/javascript"></script>-->
    <br /><br />
    <span class="titulo">Nuevo Periodo Académico</span>
    <br /><br /><br />

    <!--<input type="button" id="jqTestId" class="jqTest" value="Test" />-->

    <h:form enctype="multipart/form-data">
        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            <h:outputLabel styleClass="outputLabel" for="txtNombre" value="Nombre" />
            <h:inputText styleClass="inputText jqNombre" id="txtNombre" required="true" value="#{PeriodoAcademico.periodoAcademico.nombre}" />
            <h:outputText styleClass="outputText" value="aaa" />

            <h:outputLabel styleClass="outputLabel" value="Fecha de Inicio"/>
            <h:panelGroup>
                <div class="inputCalendar">
                    <t:inputCalendar renderAsPopup="true" id="txtFechaI" required="true" value="#{PeriodoAcademico.periodoAcademico.inicio}" />
                </div>
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="bbb" />

            <h:outputLabel styleClass="outputLabel" value="Fecha de Fin"/>
            <h:panelGroup>
                <div class="inputCalendar">
                    <t:inputCalendar renderAsPopup="true" id="txtFechaF" required="true" value="#{PeriodoAcademico.periodoAcademico.fin}" />
                </div>
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="ccc" />


            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Guardar" action="#{PeriodoAcademico.guardar}" />
                <h:commandButton styleClass="commandButton_Main" value="Volver" action="volver" />
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>


    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>