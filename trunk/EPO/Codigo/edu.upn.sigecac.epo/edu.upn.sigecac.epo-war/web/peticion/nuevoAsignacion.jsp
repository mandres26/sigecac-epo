<%--
    Document   : nuevo
    Created on : 13/04/2009, 02:49:21 AM
    Author     : texai
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <style>
        .lblEsqDin tbody label{
            line-height: 20px;
        }
    </style>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>


    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>
    <span class="titulo"><h:outputText value="Registrar Petición de Trabajo - Asignación" /></span>
    <BR>
    <BR>
    <BR>

    <h:form>
        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            <%-- Asignar Trabajo a [Curso|Clase] --%>
            <h:outputLabel styleClass="outputLabel" for="rbtAsignarA" value="Asignar Trabajo a" />
            <h:selectOneRadio styleClass="selectOneRadio" id="rbtAsignarA" value="#{Peticion.selAsignacion}" layout="pageDirection" onchange="submit()">
                <f:selectItem id="itemTodoCruso" itemLabel="Todo un curso" itemValue="curso" />
                <f:selectItem id="itemTodoClase" itemLabel="Toda una clase" itemValue="clase" />
            </h:selectOneRadio>
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" />

            <%-- Modo de Publicación [Individual|Grupal] --%>
            <h:outputLabel styleClass="outputLabel" for="rbtModo" value="Modo de Publicación" />
            <h:selectOneRadio styleClass="selectOneRadio" id="rbtModo" layout="pageDirection" value="#{Peticion.selModo}" onchange="submit()">
                <f:selectItem id="itemIndividual" itemLabel="Individual" itemValue="individual" />
                <f:selectItem id="itemGrupal" itemLabel="Grupal" itemValue="grupal" />
            </h:selectOneRadio>
            <h:outputText styleClass="outputText" value="Descripción más completa de que es exactamente lo que se solicita al alumno o grupo." />

            <%-- Multiplicidad [_] --%>
            <h:outputLabel styleClass="outputLabel" for="chkMultiplicidad" value="Multiplicidad de temas" />
            <h:panelGroup>
                <h:selectBooleanCheckbox id="chkMultiplicidad" value="#{Peticion.peticion.grupal}" title="Se han repartido varios temas en este Trabajo" />
                <h:outputLabel for="chkMultiplicidad" value="Se han repartido varios temas en este Trabajo" />
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="Descripción más completa de que es exactamente lo que se solicita al alumno o grupo." />

            <%-- Curso --%>
            <h:outputLabel styleClass="outputLabel" value="Curso" rendered="#{Peticion.selAsignacion == 'curso'}" />
            <h:selectOneMenu styleClass="selectOneMenu" value="#{Clase.selCurso}" rendered="#{Peticion.selAsignacion == 'curso'}" converter="CursoConverter" onchange="submit()">
                <f:selectItems value="#{Curso.itemsCursos}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Seleccionar a que curso se esta asignando este Trabajo" rendered="#{Peticion.selAsignacion == 'curso'}" />

            <%-- Clase --%>
            <h:outputLabel styleClass="outputLabel" value="Clase" rendered="#{Peticion.selAsignacion == 'clase'}" />
            <h:selectOneMenu styleClass="selectOneMenu" value="#{EsquemaGrupo.selClase}" rendered="#{Peticion.selAsignacion == 'clase'}" converter="ClaseConverter" onchange="submit()">
                <f:selectItems value="#{Clase.itemsClases}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Seleccionar a que clase se esta asignando este Trabajo" rendered="#{Peticion.selAsignacion == 'clase'}" />

            <%-- Esquema de Grupos --%>
            <h:outputLabel styleClass="outputLabel" value="Esquema" rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'clase' && EsquemaGrupo.selClase != null}" />
            <h:selectOneMenu id="cboEsquema" styleClass="selectOneMenu" value="#{Peticion.peticion.fidEsquemaGrupo}" rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'clase' && EsquemaGrupo.selClase != null}" converter="EsquemaGrupoConverter">
                <f:selectItems value="#{EsquemaGrupo.itemsEsquemasGrupoPorClase}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Seleccionar a que clase se esta asignando este Trabajo" rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'clase' && EsquemaGrupo.selClase != null}" />

            <%-- Esquema de Grupos (Dinamico)--%>
            <h:outputLabel styleClass="outputLabel" value="Esquemas" rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'curso' && Clase.selCurso != null && EsquemaGrupo.selClase != null}" />
            <t:panelGroup colspan="2" rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'curso' && Clase.selCurso != null && EsquemaGrupo.selClase != null}">
                <t:dataTable styleClass="lblEsqDin" value="#{Clase.clasesPorCurso}" var="item" border="0" preserveDataModel="true" varDetailToggler="detailToggler"
                             rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'curso' && Clase.selCurso != null && EsquemaGrupo.selClase != null}">
                    <h:column>
                        <f:facet name="header"><h:outputText value="Clases"/></f:facet>
                        <h:outputLabel value="#{item.codigo}" /><br />
                    </h:column>
                    <h:column>
                        <f:facet name="header"><h:outputText value="Esquema de Grupo"/></f:facet>
                        <h:selectOneMenu id="cboEsquema" styleClass="selectOneMenu" converter="EsquemaGrupoConverter">
                            <f:selectItems value="#{EsquemaGrupo.itemsEsquemasGrupoPorClaseRV}" />
                        </h:selectOneMenu>
                    </h:column>
                </t:dataTable>
            </t:panelGroup>
            <h:outputText styleClass="outputText" value="Seleccionar el Esquema de Grupos para cada Clase" rendered="#{Peticion.selModo == 'grupal' && Peticion.selAsignacion == 'curso' && Clase.selCurso != null && EsquemaGrupo.selClase != null}" />

            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Guardar" action="#{Peticion.guardar}" rendered="#{EsquemaGrupo.selClase != null}" />
                <h:commandButton styleClass="commandButton_Main" value="Volver" action="volver" />
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>
    <br>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>