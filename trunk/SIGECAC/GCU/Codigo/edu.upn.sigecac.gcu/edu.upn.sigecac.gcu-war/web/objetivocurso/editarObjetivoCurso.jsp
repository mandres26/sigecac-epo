package objetivocurso;

<%-- 
    Document   : editarObjetivoCurso
    Created on : 12/04/2009, 05:27:24 PM
    Author     : supervisor
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Subsistema GESTION CURRICULAR</title>
    </head>
    <body>
        <h1>Editar Objetivo Curso</h1>
            <h:form>
                <h:panelGrid columns="2" >

                    <h:commandButton id="btnBuscar" action="buscar" value="..." />
                    <h:inputText id="txtCurso" value="Curso Seleccionado" />

                    <h:outputLabel value="Descripcion"/>
                    <h:inputTextarea id="textDescripcion"  rows="10" cols="30" value="Inserte aca la descripcion"/>


                    <h:panelGroup />
                    <h:panelGroup>
                        <h:commandButton id="btnActualizar" action="actualizar" value="Actualizar" />
                        <h:commandButton id="btnCancelar" action="cancelar" value="Cancelar" />
                    </h:panelGroup>

                </h:panelGrid>
            </h:form>
    </body>
</html>
</f:view>