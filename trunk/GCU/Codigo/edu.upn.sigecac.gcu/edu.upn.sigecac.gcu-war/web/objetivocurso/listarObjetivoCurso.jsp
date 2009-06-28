<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Subsistema GESTION CURRICULAR</title>
    </head>
    <body>
        <h1>Listar Objetivo Curso</h1>
            <h:form>
                <h:dataTable value="#{ObjetivoCursoController.listar}" var="item" border="1" width="350px" cellspacing="0" cellpadding="0">
                    <h:column>
                        <f:facet name="" ><h:outputLabel value="Codigo" /></f:facet>
                        <h:outputText value="#{item.idObjetivocurso}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header" ><h:outputLabel value="Descripcion" /></f:facet>
                        <h:outputText value="#{item.descripcion}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header" ><h:outputLabel value="Edicion" /></f:facet>
                        <h:outputText value="#{item.fxIdedicion}" />
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <t:outputText value=""/>
                        </f:facet>
                        <t:commandLink action="#{ObjetivoCursoController.eliminar}">
                            <t:outputText value="Eliminar"/>
                            <f:param name="idObjetivocurso" value="#{item.idObjetivocurso}" />
                        </t:commandLink>
                    </h:column>
                    
                </h:dataTable>


            <h2>Operaciones</h2>
                <h:commandButton id="btnNuevoObjetivoCurso" value="Nuevo Objetivo Curso" action="nuevo"/>
                <h:commandButton id="btnEditarObjetivoCurso" value="Editar Objetivo Curso" action="editar"/>
                <h:commandButton id="btnMostrarObjetivoCurso" value="Mostrar Objetivo Curso" action="mostrar"/>
            </h:form>
    </body>
</html>
</f:view>
