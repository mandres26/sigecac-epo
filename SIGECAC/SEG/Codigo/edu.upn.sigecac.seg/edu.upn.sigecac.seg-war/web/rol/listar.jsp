<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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

    <BR>
    <div class="centrar"><h1><h:outputText value="Listado de Roles" /></h1></div>
    <BR>
    <div class="centrar">
        <h:messages id="messages" showDetail="true" />

        <h:form id="frmListar" >

            <t:panelGrid columns="3" cellpadding="1" cellspacing="10" align="center" >
                <t:commandLink
                    action="#{RolController.nuevo}"
                    value="Nuevo Rol"/>
                <t:panelGroup>
                    <t:inputText id="txtBuscar"
                                 value="#{RolController.nombreRol}"
                                 maxlength="20"
                                 size="20" />
                </t:panelGroup>
                <t:commandLink
                    action="#{RolController.filtrar}"
                    value="Buscar Rol" />
            </t:panelGrid>

            <t:dataTable value="#{RolController.listarxNombre}"
                         var="item" border="1"
                         cellpadding="2" cellspacing="2"
                         rows="10" align="center">
                <t:column>
                    <f:facet name="header" >
                        <t:outputLabel  value="ID" />
                    </f:facet>
                    <t:outputText value="#{item.idRol}"  />
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Nombre" />
                    </f:facet>
                    <t:outputText value="#{item.nombre}" />
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Activo"/>
                    </f:facet>
                    <t:selectBooleanCheckbox value="#{item.estado}" disabled="true"/>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Ver"/>
                    </f:facet>
                    <t:commandLink action="#{RolController.mostrar}" >
                        <t:graphicImage id="imgMostrar" value="/img/ver.png" border="0" />
                        <f:setPropertyActionListener target="#{RolController.rol}" value="#{item}"/>
                    </t:commandLink>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Editar"/>
                    </f:facet>
                    <t:commandLink action="#{RolController.editar}">
                        <t:graphicImage id="imgEditar" value="/img/editar.png" border="0" />
                        <f:param name="idRol" value="#{item.idRol}" />
                    </t:commandLink>
                </t:column>
                <t:column>
                    <f:facet name="header">
                        <t:outputLabel value="Borrar"/>
                    </f:facet>
                    <t:commandLink action="#{RolController.eliminar}">
                        <t:graphicImage id="imgBorrar" value="/img/eliminar.png" border="0" />
                        <f:param name="idRol" value="#{item.idRol}" />
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