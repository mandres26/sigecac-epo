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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Listar Matriz de Alineamiento de Objetivos Educacionales" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />

        <h:form>

         <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
            <h:panelGrid columns="1" width="91%">
                <h:commandButton style="font-weight: bold; margin-left:270px; margin-right: auto; background:navy; color:white" id="btnNuevo" value="Nuevo" accesskey="N" action="#{MatrizAlineamientoObjetivosEducacionalesController.nuevo}"/>
            </h:panelGrid>
         </fieldset>
         <br/>
         <br/>
            <h:dataTable styleClass="formulario" cellpadding="10"
                         id="tblCriterios"
                         value="#{MatrizAlineamientoObjetivosEducacionalesController.matricesAlineamientoObjetivosEducacionales}"
                         var="item"
                         border="1">

                <h:column>
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtCodigo" value="Código" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.idMatrizAlineamientoObjetivosEducacionales}" />
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
                    <f:facet name="header"><h:outputLabel styleClass="outputLabel" id="txtFecha" value="Fecha" /></f:facet>
                    <h:outputText styleClass="outputText" value="#{item.fecha}" />
                </h:column>

                <h:column>
                    <h:commandButton id="btnMostrar" title="Mostrar" action="mostrarMatrizObjetivosEducacionales" image="/img/ver.png">
                        <f:setPropertyActionListener target="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales}" value="#{item}" />
                    </h:commandButton>
                </h:column>

                <h:column>
                    <h:commandButton id="btnActualizar" title="Actualizar" action="actualizarMatrizObjetivosEducacionales" image="/img/editar.png">
                        <f:setPropertyActionListener target="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales}" value="#{item}" />
                    </h:commandButton>
                </h:column>

                <%--h:column>
                    <h:commandButton id="btnEliminar" title="Eliminar" action="#{MatrizAlineamientoObjetivosEducacionalesController.eliminar}" image="/img/eliminar.png">
                        <f:setPropertyActionListener target="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales}" value="#{item}" />
                    </h:commandButton>
                </h:column--%>
            </h:dataTable>
        <br/>
        </h:form>
    </t:div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
