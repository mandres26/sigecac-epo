
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
    <div class="centrar"><h1><h:outputText value="Mostrar Usuario" /></h1></div>
    <br/>
    <center>
        <h:form id="frmMostrarUsuario" prependId="false">
            <h:messages/>
            <t:panelGrid columns="2">
                <t:outputLabel value="Codigo:" for="Id"/>
                <t:outputText
                    id="Id"
                    value="#{UsuarioController.usuario.idUsuario}"/>
                <t:outputLabel value="Persona:" for="Persona"/>
                <t:outputText
                    id="Persona"
                    value="#{UsuarioController.usuario.persona.apellidoPaterno} #{UsuarioController.usuario.persona.apellidoMaterno} #{UsuarioController.usuario.persona.nombres}"/>
                <t:outputLabel value="Usuario:" for="UserName"/>
                <t:outputText
                    id="UserName"
                    value="#{UsuarioController.usuario.userName}"/>
                <t:outputLabel value="Password:" for="Password"/>
                <t:outputText
                    id="Password"
                    value="#{UsuarioController.usuario.password}"/>
                <t:outputLabel value="Fecha Registro:" for="Fecha"/>
                <t:inputDate
                    id="Fecha"
                    value="#{UsuarioController.usuario.fechaRegistro}"
                    disabled="true"/>
                <t:outputLabel value="Email:" for="Email"/>
                <t:outputText
                    id="Email"
                    value="#{UsuarioController.usuario.email}"/>
                <t:outputLabel value="Activo:" for="Activo"/>
                <t:selectBooleanCheckbox
                    value="#{UsuarioController.usuario.estado}"
                    disabled="true"/>
                <t:panelGroup/>
            </t:panelGrid>
            <br/>
            <fieldset style="width:260px">
                <legend><b>Listado de Grupos</b></legend>
                <%--<h:outputText rendered="#{GrupoController.rolEmpty}"
                value="<<No existen roles registrados el grupo actual>>"/>--%>
                <div style="height:150px; overflow:auto">
                    <t:dataTable value="#{UsuarioController.usuario.grupoCollection}"
                                 var="item" align="center" border="0"
                                 width="200px" cellpadding="5" cellspacing="5" >
                        <t:column>
                            <f:facet name="header">
                                <h:outputText value="ID"/>
                            </f:facet>
                            <t:outputText value="#{item.idGrupo}"/>
                        </t:column>
                        <t:column>
                            <f:facet name="header">
                                <h:outputText value="Grupo"/>
                            </f:facet>
                            <t:outputText value="#{item.nombre}"/>
                        </t:column>
                    </t:dataTable>
                </div>
            </fieldset>
            <t:panelGroup>
                <br/>
                <t:commandButton
                    id="btnVolver"
                    action="retornar"
                    value="Volver"/>
            </t:panelGroup>
        </h:form>
    </center>
    
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>