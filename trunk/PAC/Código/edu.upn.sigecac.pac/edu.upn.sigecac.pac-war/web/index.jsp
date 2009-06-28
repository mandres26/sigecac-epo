<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <%@include file="WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="WEB-INF/jspf/navbar.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br /><br />
    <div class="centrar" style="font-size:large; color:navy; font-weight:bold"><h:outputText value="Bienvenido a PAC" /></div>
    <br /><br />
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    <div>
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Resultados del Programa" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Resultado del Programa." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Objetivos Educacionales" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Objetivo Educacional." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Capacidades Medibles" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar una Capacidad Medible." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Criterios" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Criterio." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Matrices de Resultados del Programa" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar una Matriz de Resultados del Programa." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Matrices de Objetivos Educacionales" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar una Matriz de Objetivos Educacionales." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Gestión de Reportes" />
        <br />
        <h:outputText value="Permite generar nuevos reportes de acuerdo a los criterios seleccionados." />
        <br />
        <br />
        <div class="centrar">
            <a href="#"><img src="/pac/img/menu_temp.png" border="0"/></a>
        </div>
    </div>

    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
    <%@include file="WEB-INF/jspf/html_fin.jspf" %>
</f:view>

