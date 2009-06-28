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
        <span class="titulo"><h:outputText value="Listado de Alumnos" /></span>
        <BR>
        <BR>
        <BR>

        <center>

            <h:messages id="messages" showDetail="true" />

            <h:form id="frmListaAlumnos">

                <t:panelGrid columns="2" cellpadding="1" cellspacing="10" >
                    <h:commandLink id="btnNuevo" value="Nuevo" accesskey="N" action="#{AlumnoController.nuevo}"/>
                    <h:commandLink id="btnExportar" value="Exportar" accesskey="E" target="_blank" action="#{ReporteController.exportarListarAlumnos}"/>
                </t:panelGrid>

                <h:dataTable id="tblAlumnos"
                             value="#{AlumnoController.alumnos}"
                             var="item"
                             border="1"
                             cellpadding="2" cellspacing="2"
                             rows="10">
                    <h:column>
                        <f:facet name="header"><h:outputText value="Código" /></f:facet>
                        <h:outputText value="#{item.idPersona}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header"><h:outputText value="Nombres" /></f:facet>
                        <h:outputText value="#{item.nombres}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header"><h:outputText value="Apellidos" /></f:facet>
                        <h:outputText value="#{item.apellidoPaterno} #{item.apellidoMaterno}" />
                    </h:column>
                    <h:column>
                        <h:commandButton id="btnMostrar" action="mostrar" image="/img/ver.png">
                            <f:setPropertyActionListener target="#{AlumnoController.alumno}" value="#{item}" />
                        </h:commandButton>
                    </h:column>
                    <h:column>
                        <h:commandButton id="btnEditar" action="editar" image="/img/editar.png">
                            <f:setPropertyActionListener target="#{AlumnoController.alumno}" value="#{item}" />
                        </h:commandButton>
                    </h:column>
                    <h:column>
                        <h:commandButton id="btnEliminar" action="#{AlumnoController.eliminar}" image="/img/eliminar.png">
                            <f:setPropertyActionListener target="#{AlumnoController.alumno}" value="#{item}" />
                        </h:commandButton>
                    </h:column>
                </h:dataTable>

            </h:form>

        </center>

    </div>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
