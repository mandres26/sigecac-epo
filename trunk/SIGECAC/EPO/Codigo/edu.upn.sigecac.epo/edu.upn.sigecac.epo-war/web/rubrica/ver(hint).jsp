<%--
    Document   : index
    Created on : 26/03/2009, 11:30:08 PM
    Author     : texai
--%>
<style>
    .debug, .debug td, .debug th{border: 1px solid red; margin: 10px; padding: 10px;}

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
    <br /><br /><br /><br /><br />
    <br /><br /><br /><br />
    <h:form styleClass="formulario">

        <table id="rubricaDetalle" border="1">
            <tr class="h1">
                <th colspan="2">CODIGO: <h:outputText value="#{Rubrica.rubricaSeleccionada.codigo}" /></th>
                <th colspan="5"><h:outputText value="#{Rubrica.rubricaSeleccionada.nombre}" /></th>
            </tr>
            <tr class="h2">
                <th>Criterio</th>
                <th>Peso</th>
                <th>Sin Calificacion</th>
                <th>Nivel 1</th>
                <th>Nivel 2</th>
                <th>Nivel 3</th>
                <th>Nivel 4</th>
            </tr>
            <h:dataTable id="detail" value="#{Rubrica.rubricaSeleccionada.criterioEvaluacionCollection}" var="item">
                <%--<h:column>

                    //primera cabecera

                </h:column>
                <h:column>

                    //primera cabecera

                </h:column>--%>
                <h:column>

                    <a4j:repeat id="detail" value="#{Rubrica.rubricaSeleccionada.criterioEvaluacionCollection}" var="item">
                        <h:column>
                            <h:selectOneRadio layout="lineDirection">
                                <%--<f:selectItems value="#{item.fidPACCriterio.nivelCollection}" />--%>
                            </h:selectOneRadio>
                        </h:column>
                    </a4j:repeat>

                </h:column>
            </h:dataTable>

        </table>


        <h:commandButton styleClass="commandButton" id="btnVolver" value="Volver" action="volver"/>

    </h:form>
    <br /><br />
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>