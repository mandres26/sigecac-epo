<%--
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>
<style>
    .debug, .debug td, .debug th{border: 1px solid red; margin: 10px; padding: 10px;}

    #rubricaDetalle{
        width: 640px;
        border: 2px solid #31638A;
        font-size: 12px;
        margin: auto;
    }

    #rubricaDetalle tr.h1{
        background: #31638A;
        color: white;
    }

    #rubricaDetalle tr.h2{
        background: #3E7FB1;
        color: white;
    }

    #rubricaDetalle th, #rubricaDetalle td{padding: 7px; text-align: center;}
    
    #rubricaDetalle tr.fila{
        background: #E1ECF4;
        color: #31638A;
    }

    .no-bg{
        border: none !important;
        background: none !important;
    }

</style>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>



<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_secundario.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>
    <br /><br /><br />

        <table id="rubricaDetalle" border="0">
            <tr class="h1">
                <th colspan="2">CODIGO: <h:outputText value="#{Rubrica.rubricaSeleccionada.codigo}" /></th>
                <th colspan="4"><h:outputText value="#{Rubrica.rubricaSeleccionada.nombre}" /></th>
            </tr>
            <tr class="h2">
                <th>Criterio</th>
                <th>Peso</th>
                <th>Nivel 1</th>
                <th>Nivel 2</th>
                <th>Nivel 3</th>
                <th>Nivel 4</th>
            </tr>
            <a4j:repeat id="detail" value="#{Rubrica.rubricaSeleccionada.criterioEvaluacionCollection}" var="criterio">
                <tr class="fila">
                    <td>
                        <strong><h:outputText value="#{criterio.nombre}" /></strong><br />
                        <h:outputText value="#{criterio.comentario}" />
                    </td>
                    <td><h:outputText value="#{criterio.peso}" /></td>
                    <a4j:repeat id="detail2" value="#{criterio.nivelEpoCollection}" var="nivel">
                        <td><h:outputText value="#{nivel.nombre}" /></td>
                    </a4j:repeat>
                </tr>
            </a4j:repeat>

        </table><br /><br />


    <h:form styleClass="formulario no-bg">
        <h:commandButton styleClass="commandButton" id="btnVolver" value="Volver" action="volver" />
    </h:form>
    
    <br /><br />
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>