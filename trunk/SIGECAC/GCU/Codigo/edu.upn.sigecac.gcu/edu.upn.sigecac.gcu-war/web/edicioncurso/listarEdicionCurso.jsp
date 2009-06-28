<%--
    Document   : listarArea
    Created on : 12/04/2009, 05:24:10 PM
    Author     : supervisor
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br /><br /><br />
    <div class="centrar">

      <h1>Listar Ediciones de Curso</h1>

                                <h:form>
                                    <h:commandLink id="btnNuevaEdicion" value="Nueva Edicion Curso" action="#{EdicionCurso.nuevaEdicionCurso}"/>
                                    <h:dataTable styleClass="sheet" value="#{EdicionCurso.listaEdicionCursos}" var="item">
                                    <h:column >
                                        <f:facet name="header" ><h:outputText value="" /></f:facet>
                                        <h:graphicImage value="/img/note.png" />
                                    </h:column>
                                     <h:column >
                                        <f:facet name="header" ><h:outputText value="Edicion" /></f:facet>
                                        <h:outputText value="#{item.edicion}" />
                                    </h:column>
                                    <h:column >
                                        <f:facet name="header" ><h:outputText value="Curso" /></f:facet>
                                        <h:outputText value="#{item.fxIdcurso.nombre}" />
                                    </h:column>
                                     <h:column>
                                         <h:commandLink id="btnEliminar" value="Eliminar" action="#{EdicionCurso.borrarEdicionCurso}">
                                             <f:setPropertyActionListener target="#{EdicionCurso.edicionCurso}" value="#{item}"></f:setPropertyActionListener>
                                        </h:commandLink>
                                        </h:column>
                                         <h:column>
                                        <h:commandLink id="btnActualizar" value="Actualizar" action="editar">
                                             <f:setPropertyActionListener target="#{EdicionCurso.edicionCurso}" value="#{item}"></f:setPropertyActionListener>
                                        </h:commandLink>
                                    </h:column>

                                </h:dataTable>
                               </h:form>
    </div>
    <br /><br /><br /><br /><br /><br />
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>

