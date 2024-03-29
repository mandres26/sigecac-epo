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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Mostrar Nivel" /></span>

    <t:div>
        <h:messages id="messages" showDetail="true" />
        <h:form>
         <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
         <h:panelGrid columns="2" width="91%">
              <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" id="btnActualizar" value="Actualizar" accesskey="A" action="actualizarNivel" />
              <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" id="btnCancelar" value="Cancelar" accesskey="C" action="#{NivelController.cancelar}" />
        </h:panelGrid>
         </fieldset>
         <br/>
         <br/>

       <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblCodigoCriterio" value="Criterio: " for="CodigoCriterio"/>
                <h:outputText styleClass="outputText" id="CodigoCriterio" value="#{NivelController.nivel.fidCriterio.nombre}" />

                <h:outputLabel styleClass="outputLabel" id="lblCodigo" value="C�digo: " for="Codigo"/>
                <h:outputText styleClass="outputText" id="Codigo" value="#{NivelController.nivel.idNivel}" />

                <h:outputLabel styleClass="outputLabel" id="lblNombre" value="Nombre: " for="Nombre"/>
                <h:outputText styleClass="outputText" id="Nombre" value="#{NivelController.nivel.nombre}" />

                <h:outputLabel styleClass="outputLabel" id="lblDescripcion" value="Descripci�n: " for="Descripcion"/>
                <h:inputTextarea styleClass="inputTextarea" readonly="true" id="Descripcion" value="#{NivelController.nivel.descripcion}" />
         </h:panelGrid>
        <br/>
        </h:form>
    </t:div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>


