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

    <BR>
    <div class="centrar">
        <span class="titulo"><h:outputText value="Registrar Grupo Objetivo" /></span>
        <BR>
        <BR>
        <BR>

        <center>

            <h:messages id="messages" showDetail="true" />

            <h:form id="idFormulario">

                <h:panelGrid columns="2">

                    <h:outputLabel value="Nombres:" for="Nombres"/>
                    <h:inputText id="Nombres" value="#{GrupoObjetivoController.grupoObjetivo.nombre}" />

                    <h:outputLabel value="Descripción:" for="Descripcion"/>
                    <h:inputTextarea id="Descripcion" value="#{GrupoObjetivoController.grupoObjetivo.descripcion}" cols="50" />

                    <h:panelGroup/>
                    <BR>

                    <h:panelGroup/>
                    <h:panelGroup>

                        <h:commandButton id="btnGuardar" value="Guardar" accesskey="G" action="#{GrupoObjetivoController.registrar}" />
                        <h:commandButton id="btnCancelar" value="Cancelar" accesskey="C" action="#{GrupoObjetivoController.cancelar}" />

                    </h:panelGroup>

                </h:panelGrid>

            </h:form>

        </center>

    </div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
