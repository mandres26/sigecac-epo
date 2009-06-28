
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

      <h1>Listar Cursos</h1>
                                <h:form>
                                    <h:commandLink id="btnNuevoCurso" value="Nuevo Curso" action="#{Curso.nuevaCurso}"/>
                                    <h:dataTable styleClass="sheet" value="#{Curso.listaCursos}" var="item">
                                    <h:column >
                                        <f:facet name="header" ><h:outputText value="" /></f:facet>
                                        <h:graphicImage value="/img/note.png" />
                                    </h:column>
                                     <h:column >
                                        <f:facet name="header" ><h:outputText value="Codigo" /></f:facet>
                                        <h:outputText value="#{item.codigo}" />
                                    </h:column>
                                    <h:column >
                                        <f:facet name="header" ><h:outputText value="Nombre" /></f:facet>
                                        <h:outputText value="#{item.nombre}" />
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header" ><h:outputText value="Abreviatura" style="width:180px" /></f:facet>
                                        <h:outputText value="#{item.abreviatura}" />
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header" ><h:outputText value="Nro Cred." style="width:180px" /></f:facet>
                                        <h:outputText value="#{item.nrocreditos}" />
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header" ><h:outputText value="H. Tec." style="width:180px" /></f:facet>
                                        <h:outputText value="#{item.horastecnicas}" />
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header" ><h:outputText value="H. Pract." style="width:180px" /></f:facet>
                                        <h:outputText value="#{item.horaspracticas}" />
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header" ><h:outputText value="H Lab." style="width:180px" /></f:facet>
                                        <h:outputText value="#{item.horaslaboratorio}" />
                                    </h:column>
                                     <h:column>
                                         <h:commandLink id="btnEliminar" value="Eliminar" action="#{Curso.borrarCurso}">
                                             <f:setPropertyActionListener target="#{Curso.curso}" value="#{item}"></f:setPropertyActionListener>
                                        </h:commandLink>
                                        </h:column>
                                         <h:column>
                                        <h:commandLink id="btnActualizar" value="Actualizar" action="editar">
                                             <f:setPropertyActionListener target="#{Curso.curso}" value="#{item}"></f:setPropertyActionListener>
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
