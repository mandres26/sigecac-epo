<%-- 
    Document   : listar
    Created on : 22/06/2009, 07:31:45 PM
    Author     : Nancy Espinola
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

    <span class="titulo">Ver detalle de Trabajo</span>
    <BR>
    <BR>
    <BR>

    <h:form>

        <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">
            <h:outputLabel styleClass="outputLabel" for="txtTitulo" value="Título del Trabajo" />
            <h:inputText styleClass="inputText" value="#{Publicacion.publicacionSeleccionada.titulo}" id="txtTitulo" readonly="true" />

            <h:outputLabel styleClass="outputLabel" for="txtKeywords" value="Palabras clave (separadas por coma)" />
            <h:inputText styleClass="inputText" value="#{Publicacion.publicacionSeleccionada.keywords}" id="txtKeywords" readonly="true" />

            <h:outputLabel styleClass="outputLabel" for="txtAbstract" value="Abstract (5000 caracteres max.)"/>
            <h:inputTextarea styleClass="inputTextarea" value="#{Publicacion.publicacionSeleccionada.resumen}" id="txtAbstract" readonly="true" />

            <h:outputLabel styleClass="outputLabel" for="bitComentarios" value="¿Deseas que tu publicacion pueda recibir comentarios?" />
            <h:panelGroup>
                <h:selectBooleanCheckbox id="bitComentarios" readonly="true" value="#{Publicacion.publicacionSeleccionada.recibirComentaios}" />
                <h:outputLabel for="bitComentarios" value="Si deseo recibir comentarios" />
            </h:panelGroup>

        </h:panelGrid>


        <t:dataTable value="#{Publicacion.listaComentariosValidados}" var="item" preserveDataModel="true" varDetailToggler="detailToggler" styleClass="formulario">
            <h:column>
                <f:facet name="header"><h:outputText value="Comentarios" /></f:facet>
                <h:outputText id="comentario" value="#{item.comentario}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Fecha" /></f:facet>
                <h:outputText id="fecha" value="#{item.fecha}" />
            </h:column>
            <f:facet name="footer">

                <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

                    <h:outputLabel styleClass="outputLabel" for="txtComentario" value="Comentario" />
                    <h:inputText styleClass="inputTextarea jqNombre" id="txtNombre" required="true" value="#{Publicacion.comentario.comentario}" />
                    <h:outputText styleClass="outputText" value="Ingrese su comentario" />

                    
                    <h:panelGroup />
                    <h:panelGroup>
                        <h:commandButton styleClass="commandButton_Main" value="Enviar" action="#{Publicacion.RegistrarComentario}" />
                        <h:commandButton styleClass="commandButton_Main" value="Volver" action="volver" />
                    </h:panelGroup>
                    <h:panelGroup />

                </h:panelGrid>
            </f:facet>
        </t:dataTable>
    </h:form>


    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>