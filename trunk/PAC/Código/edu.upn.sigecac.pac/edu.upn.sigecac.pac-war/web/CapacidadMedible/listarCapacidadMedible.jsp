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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Listar Capacidades Medibles" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />
        <h:form>

            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
               <h:panelGrid columns="1" width="91%">
                   <h:commandButton style="font-weight: bold; margin-left:270px; margin-right: auto; background:navy; color:white" id="btnNuevo" value="Nuevo" accesskey="N" action="#{CapacidadMedibleController.nuevo}" />
                </h:panelGrid>
            </fieldset>
            <br/>
            <br/>

             <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Resultados del Programa: " />
                <h:selectOneMenu value="#{CapacidadMedibleController.resultadoSeleccionado}" onchange="submit()" valueChangeListener="#{CapacidadMedibleController.processValueChange}">
                    <f:selectItem itemLabel="Seleccione un Resultado de Programa..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboResultados}" />
                </h:selectOneMenu>
            </h:panelGrid>

            <br/>

            <%--Al seleccionar un Resultado del Programa del combo debe aparecer una lista
            con las capacidades medibles del Resultado del Programa seleccionado--%>

            <h:dataTable styleClass="formulario" cellpadding="10"
                         id="tblCapacidadesMedibles"
                         value="#{CapacidadMedibleController.capacidadesMediblePorResultado}"
                         var="item"
                         border="1">

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="lblResultadoPrograma" value="Resultado del Programa" for="ResultadoPrograma"/></f:facet>
                    <h:outputText styleClass="outputText" id="ResultadoPrograma" value="#{item.fidResultadoPrograma.nombre}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtCodigo" value="Código" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.idCapacidadMedible}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtNombre" value="Nombre" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.nombre}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtDescripcion" value="Descripción" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.descripcion}" />
                </h:column>
                <%--h:column>
                   <h:commandButton id="btnSeleccionar" title="Seleccionar" action="seleccionarCapacidad" image="/img/navbar_flecha.png" >
                        <f:setPropertyActionListener target="#{CriterioController.criterio.fidCapacidadMedible}" value="#{item}" />
                    </h:commandButton>
                </h:column--%>
                <h:column>
                    <h:commandButton id="btnMostrar" title="Mostrar" action="mostrarCapacidad" image="/img/ver.png">
                        <f:setPropertyActionListener target="#{CapacidadMedibleController.capacidadMedible}" value="#{item}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <h:commandButton id="btnActualizar" title="Actualizar" action="actualizarCapacidad" image="/img/editar.png">
                        <f:setPropertyActionListener target="#{CapacidadMedibleController.capacidadMedible}" value="#{item}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <h:commandButton id="btnEliminar" title="Eliminar" action="#{CapacidadMedibleController.eliminar}" image="/img/eliminar.png">
                        <f:setPropertyActionListener target="#{CapacidadMedibleController.capacidadMedible}" value="#{item}" />
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
