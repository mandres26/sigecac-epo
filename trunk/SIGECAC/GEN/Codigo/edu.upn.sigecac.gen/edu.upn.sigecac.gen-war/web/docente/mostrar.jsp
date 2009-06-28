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
        <span class="titulo"><h:outputText value="Mostrar Docente" /></span>
        <BR>
        <BR>
        <BR>

        <center>

            <h:messages id="messages" showDetail="true" />

            <h:form id="idFormulario">

                <h:panelGrid columns="2">

                    <h:outputLabel value="Código:" for="Codigo"/>
                    <h:outputText id="Codigo" value="#{DocenteController.docente.idPersona}" />

                    <h:outputLabel value="Nombres:" for="Nombres"/>
                    <h:outputText id="Nombres" value="#{DocenteController.docente.nombres}" />

                    <h:outputLabel value="Apellido Materno:" for="ApellidoMaterno"/>
                    <h:outputText id="ApellidoMaterno" value="#{DocenteController.docente.apellidoMaterno}" />

                    <h:outputLabel value="Apellido Paterno:" for="ApellidoPaterno"/>
                    <h:outputText id="ApellidoPaterno" value="#{DocenteController.docente.apellidoPaterno}" />

                    <h:outputLabel value="Tipo Docente:" for="Tipo Docente"/>
                    <h:outputText id="TipoDocente" value="#{DocenteController.docente.tipo}" />

                    <h:panelGroup/>
                    <BR>

                    <h:panelGroup/>
                    <h:panelGroup>

                        <h:commandButton id="btnEditar" value="Editar" accesskey="E" action="editar" />
                        <h:commandButton id="btnCancelar" value="Cancelar" accesskey="C" action="#{DocenteController.cancelar}" />

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
