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

    <span class="titulo">Listar: Comentario</span>
    <BR>
    <BR>
    <BR>

       <h:form>
           <t:dataTable value="#{Comentario.listaComentarios}" var="item" preserveDataModel="true" varDetailToggler="detailToggler" styleClass="formulario">
            <h:column>
                <f:facet name="header"><h:outputText value="Comentarios" /></f:facet>
                <h:outputText id="comentario" value="#{item.comentario}" />
            </h:column>
            <f:facet name="footer">

        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            <h:outputLabel styleClass="outputLabel" for="txtComentario" value="Comentario" />
            <h:inputText styleClass="inputTextarea jqNombre" id="txtNombre" required="true" value="#{Comentario.comentario.comentario}" />
            <h:outputText styleClass="outputText" value="Ingrese su comentario" />


            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Enviar" action="#{Comentario.Registrar}" />
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