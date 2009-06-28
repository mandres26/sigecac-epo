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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Listar Criterios" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />

        <h:form>

         <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
            <h:panelGrid columns="1" width="91%">
                    <h:commandButton style="font-weight: bold; margin-left:270px; margin-right: auto; background:navy; color:white" id="btnNuevo" value="Nuevo" accesskey="N" action="#{CriterioController.nuevo}"/>
            </h:panelGrid>
         </fieldset>
         <br/>
         <br/>
         <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

                <h:outputLabel styleClass="outputLabel" value="Resultados del Programa: " />
                <h:selectOneMenu value="#{CriterioController.resultadoSeleccionado}" onchange="submit()">
                    <f:selectItem itemLabel="Seleccione un Resultado de Programa..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboResultados}" />
                </h:selectOneMenu>

<%--Al seleccionar un Resultado del combo debe aparecer en el siguiente combo
            sus capacidades medibles asignadas--%>

                 <h:outputLabel styleClass="outputLabel" value="Capacidad Medible: " rendered= "#{CriterioController.resultadoSeleccionado != null}" />
                 <h:selectOneMenu value="#{CriterioController.capacidadSeleccionada}" valueChangeListener="#{CriterioController.processValueChange}" onchange="submit()" rendered= "#{CriterioController.resultadoSeleccionado != null}">
                     <f:selectItem itemLabel="Seleccione una Capacidad Medible..." />
                     <f:selectItems value="#{CriterioController.comboCapacidadesxResultado}" />
                 </h:selectOneMenu>

                <%--Al seleccionar una Capacidad del combo debe aparecer una lista
            con sus criterios asignados--%>

             </h:panelGrid>
            <br/>
            <h:dataTable styleClass="formulario" cellpadding="10"
                         id="tblCriterios"
                         value="#{CriterioController.criteriosPorCapacidad}"
                         var="item"
                         border="1">

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtCodigoCapacidadMedible" value="Capacidad Medible" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.fidCapacidadMedible.nombre}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtCodigo" value="Código" /></f:facet>
                    <h:outputText styleClass="outputText"  value="#{item.idCriterio}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtNombre" value="Nombre" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.nombre}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtDescripcion" value="Descripción" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.descripcion}" />
                </h:column>

                <h:column>
                    <h:commandButton id="btnMostrar" title="Mostrar" action="mostrarCriterio" image="/img/ver.png">
                        <f:setPropertyActionListener target="#{CriterioController.criterio}" value="#{item}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <h:commandButton id="btnActualizar" title="Actualizar" action="actualizarCriterio" image="/img/editar.png">
                        <f:setPropertyActionListener target="#{CriterioController.criterio}" value="#{item}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <h:commandButton id="btnEliminar" title="Eliminar" action="#{CriterioController.eliminar}" image="/img/eliminar.png">
                        <f:setPropertyActionListener target="#{CriterioController.criterio}" value="#{item}" />
                    </h:commandButton>
                </h:column>
            </h:dataTable>
        <br/>
        </h:form>
    </t:div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
