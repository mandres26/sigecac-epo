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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Actualizar Matriz de Alineamiento de Objetivos Educacionales" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />

        <h:form>
         <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
          <h:panelGrid columns="2" width="91%">
              <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" id="btnGuardar" value="Guardar" accesskey="G" action="#{MatrizAlineamientoObjetivosEducacionalesController.actualizar}" />
              <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" id="btnCancelar" value="Cancelar" accesskey="C" action="#{MatrizAlineamientoObjetivosEducacionalesController.cancelar}" />
         </h:panelGrid>
         </fieldset>
         <br/>
         <br/>

            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblCodigo" for="txtCodigo" value="Codigo: " />
                <h:inputText styleClass="inputText" id="txtCodigo" value="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales.idMatrizAlineamientoObjetivosEducacionales}" readonly="true"/>

                <h:outputLabel styleClass="outputLabel" id="lblNombre" for="txtNombre" value="Nombre: " />
                <h:inputText styleClass="inputText" id="txtNombre" value="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales.nombre}" >
                    <f:validateLength maximum="100" />
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputText>

                <h:outputLabel styleClass="outputLabel" id="lblDescripción" for="itaDescripcion" value="Descripción: " />
                <h:inputTextarea styleClass="inputTextarea" id = "itaDescripcion" value="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales.descripcion}" cols="50">
                    <f:validateLength maximum="255" />
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputTextarea >

                <h:outputLabel styleClass="outputLabel" id="lblFecha" value="Fecha de Creación: " for="Fecha"/>
                <h:outputText styleClass="outputText" id="Fecha" value="#{MatrizAlineamientoObjetivosEducacionalesController.matrizAlineamientoObjetivosEducacionales.fecha}" />

            </h:panelGrid>
        <br/>
        </h:form>
    </t:div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>

