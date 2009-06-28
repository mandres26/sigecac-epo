<%--
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
    <%@include file="WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="WEB-INF/jspf/navbar.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>
    <br /><br />
    <div class="centrar" style="font-size:large; color:navy; font-weight:bold"><h:outputText value="Bienvenido a SEG" /></div>
    <br /><br />
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    <div>
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Usuarios" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Usuario." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Grupos" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Grupo." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Roles" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Rol." />
        <br />
        <br />
        <div class="centrar">
            <a href="#"><img src="/seg/img/menu_temp.jpg" border="0"/></a>
        </div>
    </div>

    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
    <%@include file="WEB-INF/jspf/html_fin.jspf" %>
</f:view>