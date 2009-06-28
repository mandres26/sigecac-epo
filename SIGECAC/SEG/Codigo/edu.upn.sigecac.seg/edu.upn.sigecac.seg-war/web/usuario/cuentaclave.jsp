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
    <div class="centrar"><h1><h:outputText value="Actualizar Clave de Usuario" /></h1></div>
    <br/>
    <center>
        <h:form id="frmEditarUsuario" prependId="false">
            <h:messages/>
            <t:panelGrid columns="2">
                <t:outputLabel value="Usuario:" for="UsurName"/>
                <t:outputText
                    id="UsurName"
                    value="#{UsuarioController.usuario.userName}">
                </t:outputText>
                <t:outputLabel value="Password Anterior" for="Password"/>
                <t:inputSecret
                    id="Password"
                    value="#{UsuarioController.password}"
                    size="27">
                <f:validateLength
                    maximum="10"
                    minimum="3"/>
                </t:inputSecret>
                <t:outputLabel value="Nuevo Password" for="nuevoPassword"/>
                <t:inputSecret
                    id="nuevoPassword"
                    value="#{UsuarioController.nuevoPassword}"
                    size="27">
                <f:validateLength
                    maximum="10"
                    minimum="3"/>
                </t:inputSecret>
                <t:outputLabel value="Confirmar Password" for="confirmarPassword"/>
                <t:inputSecret
                    id="confirmarPassword"
                    value="#{UsuarioController.usuario.password}"
                    size="27">
                <f:validateLength
                    maximum="10"
                    minimum="3"/>
                </t:inputSecret>

                <t:panelGroup/>
            </t:panelGrid>

            <br>
            <br/>
           <t:panelGroup>
                <br/>
                <t:commandButton
                    id="btnGuardar"
                    action="#{UsuarioController.edicionclave}"
                    value="Guardar" />
                <t:commandButton
                    id="btnCancelar"
                    action="retornar"
                    value="Cancelar"/>
            </t:panelGroup>

        </h:form>
    </center>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>