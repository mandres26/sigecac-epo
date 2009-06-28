<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:view>
    <%@include file="../WEB-INF/jspf/html_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <%@include file="../WEB-INF/jspf/navbar.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_inicio.jspf" %>
    <%@include file="../WEB-INF/jspf/menu_principal.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_medio.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>
    
    <span class="titulo"><h:outputText style= "margin-left:20px" value="Registrar Matriz de Alineamiento de Objetivos Educacionales" /></span>
    
    <t:div>
        <h:messages id="messages" showDetail="true" />
        
        <h:form>
            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">
                <h:panelGrid columns="2" width="91%">
                    <h:commandButton style="font-weight: bold; margin-left:120px; margin-right: auto; background:navy; color:white" accesskey="G" id="btnGuardar" value="Guardar" action = "#{ObjetivoEducacionalController.registrarMatriz}" />
                    <h:commandButton style="font-weight: bold; margin-left:60px; margin-right: auto; background:navy; color:white" accesskey="C" id="btnCancelar" value="Cancelar" action = "#{ObjetivoEducacionalController.cancelarMatriz}" />
                </h:panelGrid>
            </fieldset>
            <br/>
            <br/>
            <h:panelGrid columns="2" styleClass="formulario" style="margin-left:20px" cellpadding="10" cellspacing="0" border="0">
                 <h:outputLabel styleClass="outputLabel" value="Nombre: " />
                 <h:inputText value="#{ObjetivoEducacionalController.matriz.nombre}" >
                     <f:validateLength maximum="100" />
                     <f:validator validatorId="alphaNumValidator"/>
                 </h:inputText>

                 <h:outputLabel styleClass="outputLabel" value="Descripción: " />
                 <h:inputTextarea value="#{ObjetivoEducacionalController.matriz.descripcion}" cols = "50">
                     <f:validateLength maximum="255" />
                     <f:validator validatorId="alphaNumValidator"/>
                 </h:inputTextarea>
            </h:panelGrid>
            <br/>

       <h:panelGrid columns="2" styleClass="formulario" style ="margin-left:17px" cellpadding="10" cellspacing="0" border="0">
                <h:outputLabel styleClass="outputLabel" value="Resultado del Programa: " />
                <h:selectOneMenu id="cboResultadoPrograma" value="#{ObjetivoEducacionalController.resultadoSeleccionado}" >
                    <f:selectItem itemLabel="Seleccione un Resultado del Programa..." />
                    <f:selectItems value="#{ResultadoProgramaController.comboResultados}" />
                    
                </h:selectOneMenu>
            </h:panelGrid>
            <br/>
            
            <h:panelGrid columns="2" styleClass="formulario" style="margin-left:17px" cellpadding="10" cellspacing="0" border="0">
                <rich:listShuttle sourceValue="#{ObjetivoEducacionalController.listaObjetivos}" id="lista"
                                  targetValue="#{ObjetivoEducacionalController.listaObjetivosTemporal}" var="items"
                                  sourceCaptionLabel="Lista de Objetivos: "
                                  targetCaptionLabel="Objetivos Seleccionados: " >
                    <rich:column>
                        <h:outputText value="#{items.nombre}"></h:outputText>
                    </rich:column>
                </rich:listShuttle>
            </h:panelGrid>
            <br/>
            
            <fieldset style="width: 93%; margin-left:auto; margin-right:auto">

                <a4j:commandButton reRender="listaMatriz" action="#{ObjetivoEducacionalController.agregarLista}" value="Agregar" style="font-weight: bold; margin-left:260px; margin-right: auto; background:navy; color:white" />
                
            </fieldset>
            <br/>
            <br/>
            <h:panelGrid columns="2" styleClass="formulario" style="margin-left:17px" cellpadding="10" cellspacing="0" border="0">
            <rich:dataTable id="listaMatriz" value="#{ObjetivoEducacionalController.listaMatriz}" var="mat" width="100%" columnClasses="center" rows="10" reRender="ds">

                <f:facet name="header">
                    <h:outputLabel styleClass="outputLabel" value="Matriz de Objetivos Educacionales"/>
                </f:facet>

                <rich:column sortBy="#{mat.resultadoPrograma.nombre}">
                    <f:facet name="header">
                        <h:outputText value="Resultado del Programa"/>
                    </f:facet>
                    <h:outputText value="#{mat.resultadoPrograma.nombre}"/>
                </rich:column>

                <rich:column sortBy="#{mat.objetivoEducacional.nombre}">
                    <f:facet name="header">
                        <h:outputText value="Objetivo Educacional"/>
                    </f:facet>
                    <h:outputText value="#{mat.objetivoEducacional.nombre}"/>
                </rich:column>

                <rich:column>
                    <f:facet name="header">
                    </f:facet>
                    <h:commandButton value="Eliminar" action="#{ObjetivoEducacionalController.eliminardeLista}" image="/img/eliminar.png" title="Eliminar">
                        <f:setPropertyActionListener target="#{ObjetivoEducacionalController.matrizSeleccionada}" value="#{mat}" />
                    </h:commandButton>
                </rich:column>
                <f:facet name="footer">
                    <rich:datascroller id="ds"></rich:datascroller>
                </f:facet>
            </rich:dataTable>
            <br/>
            </h:panelGrid>
     
        </h:form>
    </t:div>
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>