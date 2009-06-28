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
        <h1>Registrar Nuevo Objetivo Curso</h1>
            <h:form>
                <t:panelGrid columns="2" >

                    <t:outputLabel value="Descripcion" for="Descripcion"/>
                    <t:inputText
                        id="Descripcion"
                        value="#{ObjetivoCursoController.objCurso.descripcion}"
                        size="40"/>
                        
                    <t:outputLabel value="Edicion"/>
                    <t:selectOneMenu  value="#{ObjetivoCursoController.edicionSeleccionada}">
                        <f:selectItems value="#{ObjetivoCursoController.edicionCurso}" />
                    </t:selectOneMenu>
                    
                    <t:panelGroup>
                        <br>
                        <t:commandButton id="btnGuardar"
                        action="#{ObjetivoCursoController.guardar}"
                                         value="Guardar"/>
                        <t:commandButton id="btnCancelar"
                                         action="retornar"
                                         value="Cancelar"/>
                    </t:panelGroup>
                </t:panelGrid>
            </h:form>
    </body>
</html>
</f:view>
