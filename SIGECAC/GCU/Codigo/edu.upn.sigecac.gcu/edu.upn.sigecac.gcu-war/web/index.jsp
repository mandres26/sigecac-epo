<%--
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>

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
    <div class="centrar" style="font-size:large; color:navy; font-weight:bold"><h:outputText value="Bienvenido a GCU" /></div>
    <br /><br />
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    <div>
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Nivel Profesional" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Nivel Profesional." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Areas" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Area." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Sub Areas" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar una Sub Area." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Niveles" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Nivel." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Cursos" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Curso." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Mallas Curriculares" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar una Malla Curricular." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Mantenimiento de Estandares y Cuantificadores" />
        <br />
        <h:outputText value="Permite listar, registrar, eliminar, actualizar y mostrar un Estandar y Cuantificador." />
        <br />
        <br />
        <div class="centrar">
            <a href="#"><img src="/gcu/img/menu_temp.jpg" border="0"/></a>
        </div>
    </div>

    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
    <%@include file="WEB-INF/jspf/html_fin.jspf" %>
</f:view>