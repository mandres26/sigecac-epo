<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Registrar Matriz de Alineamiento de Resultados del Programa" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />

        <h:form>
            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
                <h:panelGrid columns="2" width="91%">
                    <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" accesskey="G" id="btnGuardar" value="Guardar" action = "#{ResultadoProgramaController.guardar_Matriz}" />
                    <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" accesskey="C" id="btnCancelar" value="Cancelar" action = "#{ResultadoProgramaController.cancelarMatriz}" />
                </h:panelGrid>
            </fieldset>
            <br/>
            <br/>

            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

                <h:outputLabel styleClass="outputLabel" value="Matriz: " />
                <h:inputText value="#{ResultadoProgramaController.matriz.nombre}"  >
                    <f:validateLength maximum="100" />
                     <f:validator validatorId="alphaNumValidator"/>
                 </h:inputText>

                <h:outputLabel styleClass="outputLabel" value="Descripción: " />
                <h:inputTextarea value="#{ResultadoProgramaController.matriz.descripcion}" >
                    <f:validateLength maximum="255" />
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputTextarea >

                <h:outputLabel styleClass="outputLabel" value="Resultados del Programa: " />
                <h:selectOneMenu value="#{ResultadoProgramaController.resultadoSeleccionado}" onchange="submit()">
                    <f:selectItem itemLabel="Seleccione un Resultado de Programa..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboResultados}" />
                    <a4j:support event="onchange" ajaxSingle="true" reRender="cboCapacidad,lista1" />
                </h:selectOneMenu>

                <h:outputLabel styleClass="outputLabel" value="Capacidad Medible: " />
                <h:selectOneMenu id="cboCapacidad" value="#{ResultadoProgramaController.capacidadSeleccionada}" onchange="submit()" rendered="#{ResultadoProgramaController.resultadoSeleccionado != null}">
                    <f:selectItem itemLabel="Seleccione una Capacidad Medible..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboCapacidadesxResultado}" />
                    <a4j:support event="onchange" ajaxSingle="true" reRender="lista1" />
                </h:selectOneMenu>
            </h:panelGrid>
            <br/>
            <h:panelGrid columns="2" styleClass="formulario" style="margin-left:19px" cellpadding="10" cellspacing="0" border="0">
                <rich:listShuttle sourceValue="#{ResultadoProgramaController.listaCriterios}" id="lista1"
                                  targetValue="#{ResultadoProgramaController.listaCriteriosTemporal}" var="items"
                                  sourceCaptionLabel="Lista de Criterios: "
                                  targetCaptionLabel="Criterios Seleccionados: " >
                    <rich:column>
                        <h:outputText value="#{items.nombre}"></h:outputText>
                    </rich:column>
                </rich:listShuttle>
            </h:panelGrid>
            <br/>
            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Ciclo: " />
                <h:selectOneMenu value="#{ResultadoProgramaController.cicloSeleccionado}">
                    <f:selectItem itemLabel="Seleccione un Ciclo..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboCiclos}" />
                    <a4j:support event="onchange" ajaxSingle="true" reRender="cboCurso" />
                </h:selectOneMenu>

                <h:outputLabel styleClass="outputLabel" value="Curso: " />
                <h:selectOneMenu id="cboCurso" value="#{ResultadoProgramaController.cursoSeleccionado}">
                    <f:selectItem itemLabel="Seleccione un Curso..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboCursoXCiclo}" />
                </h:selectOneMenu>
            </h:panelGrid>
            <br/>

            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
                <a4j:commandButton reRender="listaMatriz" action="#{ResultadoProgramaController.agregarLista}" value="Agregar" style="font-weight: bold; margin-left:260px; margin-right: auto; background:navy; color:white" />
            </fieldset>
            <br/>
            <br/>
            <h:panelGrid columns="2" styleClass="formulario" style="margin-left:17px" cellpadding="10" cellspacing="0" border="0">
                <rich:dataTable id="listaMatriz" value="#{ResultadoProgramaController.listaMatriz}" var="mat" width="100%" columnClasses="center"
                                rows="10" reRender="ds">
                    <f:facet name="header">
                        <h:outputText value="Matriz de Resultados del Programa"/>
                    </f:facet>
                    <rich:column sortBy="#{mat.curso.nombre}">
                        <f:facet name="header">
                            <h:outputText value="Curso"/>
                        </f:facet>
                        <h:outputText value="#{mat.curso.nombre}"/>
                    </rich:column>
                    <rich:column sortBy="#{mat.criterio.nombre}">
                        <f:facet name="header">
                            <h:outputText value="Criterio"/>
                        </f:facet>
                        <h:outputText value="#{mat.criterio.nombre}"/>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header">
                        </f:facet>
                        <h:commandButton value="Eliminar" action="#{ResultadoProgramaController.eliminardeLista}" image="/img/eliminar.png" title="Eliminar">
                            <f:setPropertyActionListener target="#{ResultadoProgramaController.matrizSeleccionada}" value="#{mat}" />
                        </h:commandButton>
                    </rich:column>
                    <f:facet name="footer">
                        <rich:datascroller id="ds"></rich:datascroller>
                    </f:facet>
                </rich:dataTable>
                <br/>
            </h:panelGrid>
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>