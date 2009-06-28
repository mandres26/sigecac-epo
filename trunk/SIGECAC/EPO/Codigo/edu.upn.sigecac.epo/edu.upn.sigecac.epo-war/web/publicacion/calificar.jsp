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

    .detalle>tr{
        border: 1px solid red;
    }

    .detalleNivel td{
        width: 200px;
        border: 1px solid green;
    }
    .detalleNivel td label{
        font-size: 9px;
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
    <span class="titulo"><h:outputText value="#{Evaluacion.publicacionSeleccionada.titulo}" /></span>
    <br /><br />


        <table id="rubricaDetalle" border="0">
            <tr class="h1">
                <th colspan="2">CODIGO: <h:outputText value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.codigo}" /></th>
                <th colspan="4"><h:outputText value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.nombre}" /></th>
            </tr>
            <tr class="h2">
                <th>Criterio</th>
                <th>Peso</th>
                <th>Nivel 1</th>
                <th>Nivel 2</th>
                <th>Nivel 3</th>
                <th>Nivel 4</th>
            </tr>
            <a4j:repeat id="detail3" value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.criterioEvaluacionCollection}" var="criterio">
                <tr class="fila">
                    <td>
                        <strong><h:outputText value="#{criterio.fidPACCriterio.nombre}" /></strong><br />
                        <h:outputText value="#{criterio.comentario}" />
                    </td>
                    <td><h:outputText value="#{criterio.peso}" /></td>
                    <a4j:repeat id="detail2" value="#{criterio.fidPACCriterio.nivelCollection}" var="nivel">
                        <td><h:outputText value="#{nivel.nombre}" /></td>
                    </a4j:repeat>
                </tr>
            </a4j:repeat>

        </table><br /><br />



        <br /><br />
        <table id="rubricaDetalle" border="1">
            <tr class="h1">
                <th colspan="2">CODIGO: <h:outputText value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.codigo}" /></th>
                <th colspan="5"><h:outputText value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.nombre}" /></th>
            </tr>
            <tr class="h2">
                <th>Criterio/[Peso]</th>
                <th>Nivel 1</th>
                <th>Nivel 2</th>
                <th>Nivel 3</th>
                <th>Nivel 4</th>
            </tr>
            <tr><td colspan="5">

            <h:dataTable id="detail4" styleClass="detalle" border="0" value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.criterioEvaluacionCollection}" var="criterio1">
                <h:column>
                    <strong><h:outputText value="#{criterio1.fidPACCriterio.nombre}" /></strong>
                    <br /><h:outputText value="#{criterio1.comentario}" />
                    <h:outputText value="#{criterio1.comentario}" />
                    <br />
                    [<h:outputText value="#{criterio1.peso}" />]
                </h:column>
                <h:column>
                    <%--<a4j:repeat id="detail2" value="#{Evaluacion.publicacionSeleccionada.fidPeticion.fidRubrica.criterioEvaluacionCollection}" var="criterio2">
                        <h:column>--%>
                            <h:selectOneRadio layout="lineDirection" styleClass="detalleNivel" converter="NivelConverter">
                                <f:selectItems value="#{criterio1.fidPACCriterio.nivelCollectionAsItems}" />
                            </h:selectOneRadio>
                        <%--</h:column>
                    </a4j:repeat>--%>
                </h:column>
            </h:dataTable>

            </td></tr>
        </table>



    <h:form styleClass="formulario no-bg">
        <h:commandButton styleClass="commandButton" id="btnVolver" value="Volver" action="volver" />
    </h:form>

    <br /><br />
    <!--

        agregar esto en pac.be.criterio

        public SelectItem[] getNivelCollectionAsItems() {
        List<Nivel> lista = getNivelCollection();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Nivel x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    -->

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>