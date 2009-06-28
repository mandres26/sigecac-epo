<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <span class="titulo"><h:outputText style= "margin-left:20px" value="Registrar Matriz de Resultado del Programa" /></span>

    <t:div>
        <h:form>
            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
                <h:panelGrid columns="2" width="91%">

                    <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" accesskey="G" id="btnGuardar" value="Guardar" action = "#{ResultadoProgramaController.guardar_Resultados}" />
                    <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" accesskey="C" id="btnCancelar" value="Cancelar" action = "#{ResultadoProgramaController.cancelar}" />
                </h:panelGrid>
            </fieldset>
            <br/>
            <br/>

            <h:panelGrid columns="2" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

                <t:tree id="tree" value="#{ResultadoProgramaController.tree}"
                        styleClass="tree"
                        nodeClass="treenode"
                        selectedNodeClass="treenodeSelected"
                        expandRoot="true">
                </t:tree>




            </h:panelGrid>
            <br/>
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>