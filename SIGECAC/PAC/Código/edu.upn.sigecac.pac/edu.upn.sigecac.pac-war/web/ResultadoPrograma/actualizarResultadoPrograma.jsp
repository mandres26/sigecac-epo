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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Actualizar Resultado del Programa" /></span>

    <t:div>
        <h:form>
         <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
            <h:panelGrid columns="2">

                <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" id="btnGuardar" accesskey="G" value="Guardar" action = "#{ResultadoProgramaController.actualizar_Resultados}"  />
                <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" id="btnCancelar" accesskey="C" value="Cancelar" action ="#{ResultadoProgramaController.navegarListar}" />
            </h:panelGrid>
        </fieldset>
         <br/>
         <br/>

            <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

                <h:outputLabel styleClass="outputLabel" id="lblCodigo" for="txtCodigo" value="Código: " />
                <h:outputText styleClass="outputText" id="txtCodigo" value="#{ResultadoProgramaController.resultado.idResultadoPrograma}"/>
                <h:inputHidden />

                <h:outputLabel styleClass="outputLabel" value="Carrera: " for="cmbCarrera"/>
                <h:selectOneMenu styleClass="selectOneMenu" id="cmbCarrera" value="#{ResultadoProgramaController.carreraSeleccionada}" >
                   <f:selectItem itemLabel="Seleccione una Carrera..." />
                   <f:selectItems value="#{ObjetivoEducacionalController.comboCarreras}" />
                </h:selectOneMenu>
                <h:inputHidden />

                <h:outputLabel styleClass="outputLabel" id="lblNombre" for="txtNombre" value="Nombre: " />
                <h:inputText id="txtNombre" value="#{ResultadoProgramaController.resultado.nombre}" required="true" requiredMessage="Ingrese un nombre.">
                    <f:validateLength maximum="100"/>
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputText>
                <h:message for="txtNombre"/>

                <h:outputLabel styleClass="outputLabel" id="lblDescripción" for="itaDescripcion" value="Descripción: " />
                <h:inputTextarea id = "itaDescripcion" rows="5" value="#{ResultadoProgramaController.resultado.descripcion}">
                    <f:validateLength maximum="255"/>
                    <f:validator validatorId="alphaNumValidator"/>
                </h:inputTextarea>
                <h:inputHidden />

                <h:outputLabel styleClass="outputLabel" value="Estado: " for="chkEstado"/>
                <h:selectBooleanCheckbox id="chkEstado"  value="#{ResultadoProgramaController.resultado.estado}"/>
                <h:inputHidden />
            </h:panelGrid>
        <br/>
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>