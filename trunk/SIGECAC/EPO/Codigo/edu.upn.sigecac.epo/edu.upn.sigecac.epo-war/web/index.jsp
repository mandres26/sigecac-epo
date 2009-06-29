<%-- 
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <%@include file="WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="WEB-INF/jspf/navbar.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br /><br />
    <div class="centrar" style="font-size:large; color:navy; font-weight:bold"><h:outputText value="Bienvenido a ePortafolio" /></div>
    <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Eportafolio se encarga de registrar, organizar y medir las evidencias acad�micas generadas por los alumnos, estas evidencias demostrar�n los lofros alcanzados a lo largo del desarrollo de su vida acad�mica. Eportafolio Tambi�n sirve como repositorio de trabajos acad�micos que puedan ser usados como referencia a las nuevas promociones." />
    <br />
    <br />
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    <div>
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar periodo acad�mico" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de Peri�do Acad�mico hace referencia al intervalo correspondiente a un ciclo acad�mico. Durante un mismo a�o existen tres peri�dos acad�micos, de enero a febrero; de marzo a julio y de agosto a diciembre." />
        <h:outputText value="********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar esquema de grupos" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de los Esquemas de Grupo lo realizan los docentes de la Escuela de Ingenieria de Sistemas cuando asignan un trabajo grupal, los esquemas de grupo pueden variar dependiendo del curso y la clase a la cual se le ha asignado la petici�n del trabajo."  />
        <h:outputText value="********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar grupos de alumnos" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de Grupo de Alumnos lo realizan los docentes de la Escuela de Ingenier�a de Sistemas, dependiendo el esquema de grupo, el curso y la clase a la cual se le ha asignado la petici�n del trabajo."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar petici�n de trabajo" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de la Petici�n de Trabajo lo realizan los docentes de la Escuela de Ingenier�a de Sistemas, ingresando una descripci�n de lo que estan solicitando, as� mismo registrar�n la fecha y hora l�mite en la cual los alumnos tienen que responder a esta petici�n."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Publicar trabajo solicitado" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Este caso de uso es realizado por los alumnos de la Escuela de Ingenier�a de Sistemas en respuesta a la petici�n de trabajo asignada por los docentes."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Publicar trabajo propio" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Los alumnos de la Escuela de Ingenier�a de Sistemas, podran publicar sus propias investigaciones sin necesidad de responder a una petici�n."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Realizar b�squeda" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Las b�squedas las podr�n realizar cualquiera de los usuarios del Sistema."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Validar comentario" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Los alumnos podr�n publicar o rechazar los comentarios recibidos por los usuarios del sistema SIGECAC."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar alarma" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Los usuarios podr�n registrar Alarmas solicitando alguna informaci�n adicional, para que pueda ser respondida por cualquier otro usuario."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar R�brica" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Calificar Publicaci�n de Trabajo" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="La Calificaci�n de Trabajos la realizan los docentes........"  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <div class="centrar">
            <a href="#"><img src="/epo/img/menu_temp.jpg" border="0"/></a>
        </div>
    </div>

    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
    <%@include file="WEB-INF/jspf/html_fin.jspf" %>
</f:view>