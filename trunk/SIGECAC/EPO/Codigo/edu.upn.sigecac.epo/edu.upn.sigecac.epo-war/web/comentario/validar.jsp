<%--
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>

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
    <%@include file="../WEB-INF/jspf/menu_secundario.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>
    <br /><br /><br />
    <h:form>
    
    <t:dataTable value="#{Publicacion.listaComentariosNoValidados}" var="item" preserveDataModel="true" varDetailToggler="detailToggler" styleClass="formulario">
            <h:column>
                <f:facet name="header"><h:outputText value="Comentarios" /></f:facet>
                <h:outputText id="comentario" value="#{item.comentario}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Fecha" /></f:facet>
                <h:outputText id="fecha" value="#{item.fecha}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Validar" /></f:facet>
                <h:commandButton styleClass="commandButton" id="btnValidar" value="Validar" action="#{Comentario.validarComentario}">
                    <f:setPropertyActionListener target="#{Comentario.comentarioSeleccionado}" value="#{item}" />
                </h:commandButton>
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Descartar" /></f:facet>
                <h:commandButton styleClass="commandButton" id="btnDescartar" value="Descartar" action="#{Comentario.descartarComentario}">
                    <f:setPropertyActionListener target="#{Comentario.comentarioSeleccionado}" value="#{item}" />
                </h:commandButton>
            </h:column>
        </t:dataTable>


    </h:form>
    <br /><br />
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>