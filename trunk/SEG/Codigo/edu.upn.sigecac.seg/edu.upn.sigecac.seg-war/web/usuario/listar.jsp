
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br/>
    <div class="centrar"><h1><h:outputText value="Listado de Usuarios" /></h1></div>
    <br/>
    <div class="centrar">
        <h:form id="frmListarUsuario" prependId="false">
            <h:messages/>
            <t:panelGrid columns="3" cellpadding="1" cellspacing="10" align="center">
                <t:commandLink
                    action="#{UsuarioController.nuevo}"
                    value="Nuevo Usuario"/>
                    <t:panelGroup>
                        <t:inputText
                        id="txtBuscar"
                        value="#{UsuarioController.nombreUsuario}"
                        maxlength="30"
                        size="35" />
                    </t:panelGroup>
                    <t:commandLink
                    action="#{UsuarioController.filtrar}"
                    value="Buscar Usuario" />
            </t:panelGrid>
            <p/>
            <t:dataTable value="#{UsuarioController.listarxNombre}"
            var="item" border="1" cellpadding="2"
            cellspacing="2" rows="15" align="center">
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="ID"/>
                    </f:facet>
                    <t:outputText value="#{item.idUsuario}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Usuario"/>
                    </f:facet>
                    <t:outputText value="#{item.userName}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Password"/>
                    </f:facet>
                    <t:outputText value="#{item.password}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Email"/>
                    </f:facet>
                    <t:outputText value="#{item.email}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Activo"/>
                    </f:facet>
                    <t:selectBooleanCheckbox
                        value="#{item.estado}" disabled="true"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputText value="Ver"/>
                    </f:facet>
                    <t:commandLink action="#{UsuarioController.mostrar}">
                        <t:graphicImage id="imgMostrar" value="/img/ver.png" border="0" />
                        <f:setPropertyActionListener target="#{UsuarioController.usuario}" value="#{item}" />
                    </t:commandLink>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputText value="Editar"/>
                    </f:facet>
                    <t:commandLink action="#{UsuarioController.editar}">
                        <t:graphicImage id="imgEditar" value="/img/editar.png" border="0" />
                        <f:param name="idUsuario" value="#{item.idUsuario}"/>
                    </t:commandLink>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputText value="Borrar"/>
                    </f:facet>
                    <t:commandLink action="#{UsuarioController.eliminar}">
                        <t:graphicImage id="imgBorrar" value="/img/eliminar.png" border="0" />
                        <f:param name="idUsuario" value="#{item.idUsuario}"/>
                    </t:commandLink>
                </t:column>
            </t:dataTable>
        </h:form>
    </div>
    
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
