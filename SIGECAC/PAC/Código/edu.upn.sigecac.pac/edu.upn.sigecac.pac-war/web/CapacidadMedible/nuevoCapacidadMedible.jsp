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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Registrar Capacidad Medible" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />

        <h:form>
            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">               
               <h:panelGrid columns="2" width="91%">
                   <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" id="btnGuardar" value="Guardar" accesskey="G" action="#{CapacidadMedibleController.registrar}" />
                   <h:commandButton style="font-weight: bold; margin-left:60; margin-right: auto; background:navy; color:white" id="btnCancelar" value="Cancelar" accesskey="C" action="#{CapacidadMedibleController.cancelar}" />
                </h:panelGrid>
            </fieldset>
            <br/>
            <br/>

            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblIdResultadoPrograma" for="txtIdResultadoPrograma" value="Código de Resultado del Programa: " />
                <h:inputText styleClass="inputText" id="txtIdResultadoPrograma" value="#{CapacidadMedibleController.capacidadMedible.fidResultadoPrograma.idResultadoPrograma}" readonly="true"/>
                <h:outputLabel styleClass="outputLabel" id="lblNombreResultadoPrograma" value="Nombre de Resultado del Programa: " />
                <h:inputText styleClass="inputText" id="txtNombreResultadoPrograma" value="#{CapacidadMedibleController.capacidadMedible.fidResultadoPrograma.nombre}" readonly="true"/>
                <%--h:commandButton style="margin-right: 60px" title= "Buscar" id="btnBuscar" image="/img/buscar.png" accesskey="B" action="#{CapacidadMedibleController.listarResultados}" /--%>
            </h:panelGrid>

            <%--h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Código de Resultado del Programa: " />
                <h:inputText styleClass="inputText" id="txtIdResultadoPrograma" value="#{CapacidadMedibleController.resultadoSeleccionado.idResultadoPrograma}" readonly="true"/>
                <h:outputLabel styleClass="outputLabel" value="Nombre de Resultado del Programa: " />
                <h:selectOneMenu value="#{CapacidadMedibleController.resultadoSeleccionado}" onchange="submit()">
                    <f:selectItem itemLabel="Seleccione un Resultado de Programa..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboResultados}" />
                </h:selectOneMenu>
            </h:panelGrid--%>
            <%--h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Código de Resultado del Programa: " />
                <h:inputText styleClass="inputText" id="txtIdResultadoPrograma" value="#{CapacidadMedibleController.resultadoSeleccionado.idResultadoPrograma}" readonly="true"/>
                <h:outputLabel styleClass="outputLabel" value="Nombre de Resultado del Programa: " />
                <h:selectOneMenu value="#{CapacidadMedibleController.resultadoSeleccionado}" >
                    <f:selectItem itemValue="#{CapacidadMedibleController.resultadoSeleccionado.idResultadoPrograma}" itemLabel="#{CapacidadMedibleController.resultadoSeleccionado.nombre}"  />
                </h:selectOneMenu>
            </h:panelGrid--%>
            <br/>
            
            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblNombre" for="txtNombre" value="Nombre:" />
                <h:inputText styleClass="inputText" id="txtNombre"  value="#{CapacidadMedibleController.capacidadMedible.nombre}" maxlength="100" >
                    <f:validateLength maximum="100" />
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputText>
                
                <h:outputLabel styleClass="outputLabel" id="lblDescripcion" for="itaDescripcion" value="Descripción: " />
                <h:inputTextarea styleClass="inputTextarea" id = "itaDescripcion" value="#{CapacidadMedibleController.capacidadMedible.descripcion}" cols="50" >
                    <f:validateLength maximum="255" />
                    <f:validator validatorId="alphaNumValidator"/>
                    
                </h:inputTextarea>
              
            </h:panelGrid>
        <br/>
        </h:form>
    </t:div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>

