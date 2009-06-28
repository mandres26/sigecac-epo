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

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Mostrar Objetivo Educacional" /></span>

    <t:div>
        <h:form>
         <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
            <h:panelGrid columns="2" width="91%">

                <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" id="btnActualizar" value="Actualizar" accesskey="A" action = "#{ObjetivoEducacionalController.navegarActualizar}"  />
                <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" id="btnCancelar" value="Cancelar" accesskey="C" action="#{ObjetivoEducacionalController.cancelar}" />
            </h:panelGrid>
        </fieldset>
         <br/>
         <br/>

            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" id="lblCodigo" for="txtCodigo" value="Código: " />
                <h:outputText styleClass="outputText" id="txtCodigo" value="#{ObjetivoEducacionalController.objetivo.idObjetivoEducacional}" />

                <h:outputLabel styleClass="outputLabel" value="Carrera" />
                <h:outputLabel styleClass="outputText" id="txtCarrera" value="#{ObjetivoEducacionalController.objetivo.fid_Carrera}" />

                <h:outputLabel styleClass="outputLabel" id="lblNombre" for="txtNombre" value="Nombre: " />
                <h:outputText styleClass="outputText" id="txtNombre" value="#{ObjetivoEducacionalController.objetivo.nombre}" />

                <h:outputLabel styleClass="outputLabel" id="lblDescripción" for="txtDescripcion" value="Descripción: " />
                <h:outputText styleClass="outputText" id = "txtDescripcion"  value="#{ObjetivoEducacionalController.objetivo.descripcion}" />

                <h:outputLabel styleClass="outputLabel" value="Estado: " for="txtEstado"/>
                <h:outputText styleClass="outputText" id = "txtEstado" rendered="#{ObjetivoEducacionalController.objetivo.estado==false}" value="Deshabilitado" />
                <h:outputText styleClass="outputText" id = "txtEstado1" rendered="#{ObjetivoEducacionalController.objetivo.estado==true}" value="Habilitado" />
            </h:panelGrid>
        <br/>
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
