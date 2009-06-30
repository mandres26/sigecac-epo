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
<style>
    .tituloUC{
        font-size:small;
        color:navy;
        font-style:normal;
        font-weight:bold;
        display: run-in;
        margin-bottom: 10px;
    }
    .descripcionUC{
        display: run-in;
        margin: 0px 50px 20px 50px;
        text-align: justify;
    }
    .justificado{
        text-align: justify;
        margin: 0px 50px 20px 50px;
    }

</style>

    <br /><br />
    <div class="centrar" style="font-size:large; color:navy; font-weight:bold"><h:outputText value="Bienvenido a ePortafolio" /></div>
    <br />
    <div class="justificado">
        <h:outputText style="font-weight: bold;" value="ePortafolio" />
        <h:outputText value=" se encarga de registrar, organizar y medir las evidencias académicas generadas por los alumnos, estas evidencias demostrarán los lofros alcanzados a lo largo del desarrollo de su vida académica. Eportafolio También sirve como repositorio de trabajos académicos que puedan ser usados como referencia a las nuevas promociones." />
    </div>
    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />
    
    <div>
        <h:outputText styleClass="tituloUC" value="Registrar periodo académico" />
        <h:outputText styleClass="descripcionUC" value="El Registro de Periódo Académico hace referencia al intervalo correspondiente a un ciclo académico. Durante un mismo año existen tres periódos académicos, de enero a febrero; de marzo a julio y de agosto a diciembre." />

        <h:outputText styleClass="tituloUC" value="Registrar esquema de grupos" />
        <h:outputText styleClass="descripcionUC" value="El Registro de los Esquemas de Grupo lo realizan los docentes de la Escuela de Ingenieria de Sistemas cuando asignan un trabajo grupal, los esquemas de grupo pueden variar dependiendo del curso y la clase a la cual se le ha asignado la petición del trabajo."  />

        <h:outputText styleClass="tituloUC" value="Registrar grupos de alumnos" />
        <h:outputText styleClass="descripcionUC" value="El Registro de Grupo de Alumnos lo realizan los docentes de la Escuela de Ingeniería de Sistemas, dependiendo el esquema de grupo, el curso y la clase a la cual se le ha asignado la petición del trabajo."  />

        <h:outputText styleClass="tituloUC" value="Registrar petición de trabajo" />
        <h:outputText styleClass="descripcionUC" value="El Registro de la Petición de Trabajo lo realizan los docentes de la Escuela de Ingeniería de Sistemas, ingresando una descripción de lo que estan solicitando, así mismo registrarán la fecha y hora límite en la cual los alumnos tienen que responder a esta petición."  />

        <h:outputText styleClass="tituloUC" value="Publicar trabajo solicitado" />
        <h:outputText styleClass="descripcionUC" value="Este caso de uso es realizado por los alumnos de la Escuela de Ingeniería de Sistemas en respuesta a la petición de trabajo asignada por los docentes."  />

        <h:outputText styleClass="tituloUC" value="Publicar trabajo propio" />
        <h:outputText styleClass="descripcionUC" value="Los alumnos de la Escuela de Ingeniería de Sistemas, podran publicar sus propias investigaciones sin necesidad de responder a una petición."  />

        <h:outputText styleClass="tituloUC" value="Realizar búsqueda" />
        <h:outputText styleClass="descripcionUC" value="Las búsquedas las podrán realizar cualquiera de los usuarios del Sistema."  />

        <h:outputText styleClass="tituloUC" value="Validar comentario" />
        <h:outputText styleClass="descripcionUC" value="Los alumnos podrán publicar o rechazar los comentarios recibidos por los usuarios del sistema SIGECAC."  />

        <h:outputText styleClass="tituloUC" value="Registrar alarma" />
        <h:outputText styleClass="descripcionUC" value="Los usuarios podrán registrar Alarmas solicitando alguna información adicional, para que pueda ser respondida por cualquier otro usuario."  />

        <h:outputText styleClass="tituloUC" value="Registrar Rúbrica" />
        <h:outputText styleClass="descripcionUC" value="xxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxx xxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxx xxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxx xxxxxxxxx " />

        <h:outputText styleClass="tituloUC" value="Calificar Publicación de Trabajo" />
        <h:outputText styleClass="descripcionUC" value="La Calificación de Trabajos la realizan los docentes........ xxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxx xxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxx xxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxx xxxxxxxxx " />
    </div>
    
    <div class="centrar">
        <a href="#"><img src="/epo/img/menu_temp.jpg" border="0"/></a>
    </div>

    <%@include file="WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="WEB-INF/jspf/pie.jspf" %>
    <%@include file="WEB-INF/jspf/html_fin.jspf" %>
</f:view>