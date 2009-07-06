<%--
    Document   : seleccionarPublicar
    Created on : 13/04/2009, 02:49:44 AM
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
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <span class="titulo"><h:outputText value="Resultados" /></span>
    <BR>
    <BR>
    <BR>

    <h:form>
        <t:dataTable value="#{Publicacion.listaPublicaciones}"
                     var="item"
                     border="0"
                     preserveDataModel="true"
                     varDetailToggler="detailToggler"
                     styleClass="formulario">
            <h:column>
                <div style="border: 1px solid navy; margin: 10px; padding: 10px; text-align: center;">

                    <h:outputLabel styleClass="outputLabel" for="nombre" value="Título de la Petición: " />
                    <h:outputText id="nombre" value="#{item.titulo}" /><br />

                    <h:outputLabel styleClass="outputLabel" for="tipoArchivo" value="Tipo Archivo: " />
                    <h:outputText id="tipoArchivo" value="#{item.archivo}" /><br />

                    <h:outputLabel styleClass="outputLabel" for="inicio" value="Inicio: " />
                    <h:outputText id="inicio" value="#{item.keywords}" /><br />

                    <h:commandButton styleClass="commandButton_Main" id="btnMostrar" value="Selecionar" action="comentario_validar">
                        <f:setPropertyActionListener target="#{Publicacion.publicacionSeleccionada}" value="#{item}" />
                    </h:commandButton>
                </div>
            </h:column>
        </t:dataTable>

    </h:form>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>