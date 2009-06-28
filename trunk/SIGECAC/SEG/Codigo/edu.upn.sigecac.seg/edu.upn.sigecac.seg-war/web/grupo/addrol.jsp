<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <div class="centrar"><h1><h:outputText value="Listado de Roles Disponibles" /></h1></div>
    <br/>
    <center>
        <h:form id="frmAgregarRol" prependId="false">
            <h:messages/>
            <div class="centrar">
            <t:panelGrid columns="1" cellpadding="1" cellspacing="10" align="center" >
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
            </div>
            <br/>
            <h:dataTable value="#{RolController.listarxNombre}" var="item" border="1">
                <h:column>
                    <f:facet name="header">
                        <t:outputLabel value="ID"/>
                    </f:facet>
                    <t:outputText value="#{item.idRol}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <t:outputLabel value="Nombre"/>
                    </f:facet>
                    <t:outputText value="#{item.nombre}"/>
                </h:column>
                <h:column>
                    <h:commandLink value="Seleccionar" action="#{GrupoController.agregarRol}">
                        <f:setPropertyActionListener target="#{GrupoController.rol}" value="#{item}" />
                    </h:commandLink>
                </h:column>
            </h:dataTable>

            <h:panelGroup>
                <br/>
                <t:commandButton id="btnCancelar"
                                 action="retornar"
                                 value="Volver"
                                 accesskey="C">
                </t:commandButton>
            </h:panelGroup>

        </h:form>
    </center>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>