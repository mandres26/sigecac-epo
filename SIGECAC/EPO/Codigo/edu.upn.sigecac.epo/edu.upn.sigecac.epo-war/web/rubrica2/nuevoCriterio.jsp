<%-- 
    Document   : nuevoCriterio
    Created on : 28/05/2009, 07:26:14 PM
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

    <br /><div class="titulo">Nuevo Criterio</div><br /><br />


    <h:form>
        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            <h:outputLabel styleClass="outputLabel" for="cboRP" value="Resultado de Programa" />
            <h:selectOneMenu id="cboRP" styleClass="selectOneMenu" value="#{Rubrica.resultadoProgramaSeleccionado}" converter="ResultadoProgramaConverter" onchange="submit()">
                <f:selectItem itemLabel="--- Seleccione un Resultado de Programa ---" />
                <f:selectItems value="#{Rubrica.listaRPAsItems}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" />

            <%--
            <h:outputText styleClass="outputText" rendered="#{Rubrica.resultadoProgramaSeleccionado!=null}" value="#{Rubrica.resultadoProgramaSeleccionado.idResultadoPrograma}" />
            <h:outputText styleClass="outputText" rendered="#{Rubrica.resultadoProgramaSeleccionado!=null}" value="#{Rubrica.resultadoProgramaSeleccionado.nombre}" />
            <h:outputText styleClass="outputText" rendered="#{Rubrica.resultadoProgramaSeleccionado!=null}" value="#{Rubrica.resultadoProgramaSeleccionado.descripcion}" />
            --%>


            <h:outputLabel styleClass="outputLabel" for="cboCM" value="Capacidad Medible" rendered="#{Rubrica.resultadoProgramaSeleccionado!=null}" />
            <h:selectOneMenu id="cboCM" styleClass="selectOneMenu" value="#{Rubrica.capacidadMedibleSeleccionada}" converter="CapacidadMedibleConverter" onchange="submit()" rendered="#{Rubrica.resultadoProgramaSeleccionado!=null}" >
                <f:selectItem itemLabel="--- Seleccione una Capacidad Medible ---" />
                <f:selectItems value="#{Rubrica.listaCMPorRPAsItems}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" rendered="#{Rubrica.resultadoProgramaSeleccionado!=null}" />

            <%--
            <h:outputText styleClass="outputText" rendered="#{Rubrica.capacidadMedibleSeleccionada!=null}" value="#{Rubrica.capacidadMedibleSeleccionada.idCapacidadMedible}" />
            <h:outputText styleClass="outputText" rendered="#{Rubrica.capacidadMedibleSeleccionada!=null}" value="#{Rubrica.capacidadMedibleSeleccionada.nombre}" />
            <h:outputText styleClass="outputText" rendered="#{Rubrica.capacidadMedibleSeleccionada!=null}" value="#{Rubrica.capacidadMedibleSeleccionada.descripcion}" />
            --%>


            <h:outputLabel styleClass="outputLabel" for="cboCriterio" value="Criterio" rendered="#{Rubrica.capacidadMedibleSeleccionada!=null}" />
            <h:selectOneMenu id="cboCriterio" styleClass="selectOneMenu" value="#{Rubrica.criterioSeleccionado}" converter="CriterioConverter" onchange="submit()" rendered="#{Rubrica.capacidadMedibleSeleccionada!=null}" >
                <f:selectItem itemLabel="--- Seleccione un Criterio ---" />
                <f:selectItems value="#{Rubrica.listaCriteriosPorCMAsItems}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" rendered="#{Rubrica.capacidadMedibleSeleccionada!=null}" />

            <%--
            <h:outputText styleClass="outputText" rendered="#{Rubrica.criterioSeleccionado!=null}" value="#{Rubrica.criterioSeleccionado.idCriterio}" />
            <h:outputText styleClass="outputText" rendered="#{Rubrica.criterioSeleccionado!=null}" value="#{Rubrica.criterioSeleccionado.nombre}" />
            <h:outputText styleClass="outputText" rendered="#{Rubrica.criterioSeleccionado!=null}" value="#{Rubrica.criterioSeleccionado.descripcion}" />
            --%>


            <h:outputLabel styleClass="outputLabel" for="lstNivel" value="Nivel" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:selectOneListbox id="lstNivel" styleClass="selectOneListbox" rendered="#{Rubrica.criterioSeleccionado!=null}" disabled="true" disabledClass="selectOneListbox_Disabled" converter="NivelConverter" >
                <f:selectItems value="#{Rubrica.listaNivelesPorCriterioAsItems}" />
            </h:selectOneListbox>
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" rendered="#{Rubrica.criterioSeleccionado!=null}" />


            <h:outputLabel styleClass="outputLabel" for="txtPeso" value="Peso" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:inputText styleClass="inputTextSmall" id="txtPeso" required="false" value="#{Rubrica.criterioEvaluacion.peso}" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" rendered="#{Rubrica.criterioSeleccionado!=null}" />

            <h:outputLabel styleClass="outputLabel" for="txtComentario" value="Comentarios" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:inputTextarea styleClass="inputTextarea"  id="txtComentario" required="false" value="#{Rubrica.criterioEvaluacion.comentario}" rendered="#{Rubrica.criterioSeleccionado!=null}" />
            <h:outputText styleClass="outputText" value="Descripción más completa de que es exactamente lo que se solicita al alumno o grupo." rendered="#{Rubrica.criterioSeleccionado!=null}" />



            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Ok" action="#{Rubrica.agregarCriterio}" />
                <h:commandButton styleClass="commandButton" id="btnVolver" value="Volver" action="volver"/>
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>


    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>