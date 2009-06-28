

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br/>
    <div class="centrar"><h1><h:outputText value="Mostrar Grupo" /></h1></div>
    <br/>



    <center>
        <h:form id="frmMostrarGrupo" prependId="false">
            <h:messages />
            <t:panelGrid columns="2" >
                <t:outputLabel value="Nombre:" for="Nombre"/>
                <t:outputText
                    id="Nombre"
                    value="#{GrupoController.grupo.nombre}"/>
                <t:outputLabel value="Descripcion:" for="Descripcion"/>
                <t:outputText
                    id="Descripcion"
                    value="#{GrupoController.grupo.descripcion}"/>
                <t:outputLabel value="Activo" for="Activo"/>
                <t:selectBooleanCheckbox
                    id="Activo"
                    value="#{GrupoController.grupo.estado}"
                    disabled="true"/>
                <t:panelGroup/>
            </t:panelGrid>



            <fieldset style="height:230px; width:390px" >
                <legend><b>Listado de Roles</b></legend>
                <%--<h:outputText rendered="#{GrupoController.rolEmpty}"
                value="<<No existen roles registrados el grupo actual>>"/>--%>
                <div style="height:200px; overflow:auto">
                    <t:dataTable value="#{GrupoController.grupo.rolCollection}"
                                 var="item"
                                 align="center"
                                 border="0"
                                 rows="10"
                                 width="200px"
                                 cellpadding="5"
                                 cellspacing="5">
                        <t:column>
                            <f:facet name="header">
                                <h:outputText value="ID"/>
                            </f:facet>
                            <t:outputText value="#{item.idRol}"/>
                        </t:column>
                        <t:column>
                            <f:facet name="header">
                                <h:outputText value="Rol"/>
                            </f:facet>
                            <t:outputText value="#{item.nombre}"/>
                        </t:column>
                    </t:dataTable>
                </div>
            </fieldset>
            <t:panelGroup>
                <br/>
                <t:commandButton
                    id="btnVolver"
                    action="retornar"
                    value="Volver"/>
            </t:panelGroup>
        </h:form>
    </center>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>