package mallacurricular;

<%-- 
    Document   : listarMallaCurricular
    Created on : 12/04/2009, 05:26:32 PM
    Author     : supervisor
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
      <h1>Listar Malla Curricular</h1>
            <h:form>
                <h:commandButton id="btnNuevoMallaCurricular" value="Nuevo MallaCurricular" action="nuevo"/>
                <h:commandButton id="btnEditarMallaCurricular" value="Editar MallaCurricular" action="editar"/>
                <h:commandButton id="btnMostrarMallaCurricular" value="Mostrar MallaCurricular" action="mostrar"/>
            </h:form>
    </body>
</html>
</f:view>