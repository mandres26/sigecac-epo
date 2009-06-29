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
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Eportafolio se encarga de registrar, organizar y medir las evidencias académicas generadas por los alumnos, estas evidencias demostrarán los lofros alcanzados a lo largo del desarrollo de su vida académica. Eportafolio También sirve como repositorio de trabajos académicos que puedan ser usados como referencia a las nuevas promociones." />
    <br />
    <br />
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    <div>
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar periodo académico" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de Periódo Académico hace referencia al intervalo correspondiente a un ciclo académico. Durante un mismo año existen tres periódos académicos, de enero a febrero; de marzo a julio y de agosto a diciembre." />
        <h:outputText value="********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar esquema de grupos" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de los Esquemas de Grupo lo realizan los docentes de la Escuela de Ingenieria de Sistemas cuando asignan un trabajo grupal, los esquemas de grupo pueden variar dependiendo del curso y la clase a la cual se le ha asignado la petición del trabajo."  />
        <h:outputText value="********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar grupos de alumnos" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de Grupo de Alumnos lo realizan los docentes de la Escuela de Ingeniería de Sistemas, dependiendo el esquema de grupo, el curso y la clase a la cual se le ha asignado la petición del trabajo."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar petición de trabajo" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="El Registro de la Petición de Trabajo lo realizan los docentes de la Escuela de Ingeniería de Sistemas, ingresando una descripción de lo que estan solicitando, así mismo registrarán la fecha y hora límite en la cual los alumnos tienen que responder a esta petición."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Publicar trabajo solicitado" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Este caso de uso es realizado por los alumnos de la Escuela de Ingeniería de Sistemas en respuesta a la petición de trabajo asignada por los docentes."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Publicar trabajo propio" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Los alumnos de la Escuela de Ingeniería de Sistemas, podran publicar sus propias investigaciones sin necesidad de responder a una petición."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Realizar búsqueda" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Las búsquedas las podrán realizar cualquiera de los usuarios del Sistema."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Validar comentario" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Los alumnos podrán publicar o rechazar los comentarios recibidos por los usuarios del sistema SIGECAC."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar alarma" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="Los usuarios podrán registrar Alarmas solicitando alguna información adicional, para que pueda ser respondida por cualquier otro usuario."  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Registrar Rúbrica" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"  />
        <h:outputText value="*********************." />
        <br />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:italic; font-weight:bold" value="Calificar Publicación de Trabajo" />
        <br />
        <h:outputText style="font-size:small; color:navy; font-style:normal; font-weight:bold" value="La Calificación de Trabajos la realizan los docentes........"  />
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