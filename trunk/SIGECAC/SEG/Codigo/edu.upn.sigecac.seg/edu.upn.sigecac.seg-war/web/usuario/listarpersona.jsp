
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
    <div class="centrar"><h1><h:outputText value="Seleccione una Persona para registrar su Usuario" /></h1></div>
    <br/>
    <div class="centrar">
        <h:form id="frmListarPersona" prependId="false">
            <h:messages/>
            <t:panelGrid columns="3" cellpadding="1" cellspacing="10" align="center">
                <t:panelGroup>
                    <t:inputText
                        id="txtBuscar"
                        value="#{UsuarioController.apellidoPaterno}"
                        maxlength="30"
                        size="35" />
                </t:panelGroup>
                <t:commandLink
                    action="#{UsuarioController.filtrar}"
                    value="Buscar Persona" />
            </t:panelGrid>
            <p/>
            <t:dataTable value="#{UsuarioController.listarxPersona}"
                         var="item" border="1" cellpadding="2"
                         cellspacing="2" rows="15" align="center">
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="ID"/>
                    </f:facet>
                    <t:outputText value="#{item.idPersona}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Nombres"/>
                    </f:facet>
                    <t:outputText value="#{item.nombres}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Ap. Paterno"/>
                    </f:facet>
                    <t:outputText value="#{item.apellidoPaterno}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Ap. Materno"/>
                    </f:facet>
                    <t:outputText value="#{item.apellidoMaterno}"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputText value="Seleccionar"/>
                    </f:facet>
                    <t:commandLink action="seleccionar">
                        <t:graphicImage id="imgEditar" value="/img/navbar_flecha.png" border="0" />
                        <f:setPropertyActionListener target="#{UsuarioController.usuario.persona}" value="#{item}"/>
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
