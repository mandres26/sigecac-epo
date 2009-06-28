<%-- 
    Document   : nuevo
    Created on : 13/04/2009, 02:49:21 AM
    Author     : texai
--%>

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

    <span class="titulo"><h:outputText value="Registrar Petición de Trabajo" /></span>
    <BR>
    <BR>
    <BR>

    <h:form enctype="multipart/form-data">
        <h:panelGrid columns="3" styleClass="formulario" cellpadding="10" cellspacing="0" border="0">

            <h:outputLabel styleClass="outputLabel" for="txtNombre" value="Nombre" />
            <h:inputText styleClass="inputText" id="txtNombre" required="false" value="#{Peticion.peticion.nombre}" />
            <h:outputText styleClass="outputText" value="Nombre descriptivo de la Petición de Trabajo" />

            <h:outputLabel styleClass="outputLabel" for="txtDescripcion" value="Descripción"/>
            <h:inputTextarea styleClass="inputTextarea"  id="txtDescripcion" required="false" value="#{Peticion.peticion.descripcion}" />
            <h:outputText styleClass="outputText" value="Descripción más completa de que es exactamente lo que se solicita al alumno o grupo." />

            <h:outputLabel styleClass="outputLabel" value="Referencia"/>
            <t:inputFileUpload id="file" styleClass="inputFileUpload" value="#{Peticion.archivo}" />
            <%-- <h:inputText styleClass="inputText" id="txtReferencia" required="false" value="#{Peticion.peticion.referencia}" /> --%>
            <h:outputText styleClass="outputText" value="Si es necesario, se le puede proveer al alumno o grupo un arhivo donde se puede extender la explicación de lo que se requere para este trabajo, o dar un ejemplo o plantilla." />

            <h:outputLabel styleClass="outputLabel" value="Fecha y Hora de Inicio"/>
            <h:panelGroup>
                <div class="inputCalendar">
                <t:inputCalendar renderAsPopup="true" id="txtFechaI" required="false" value="#{Peticion.peticion.inicio}" /></div>
                <h:selectOneMenu value="#{Peticion.peticion_horaInicio}">
                    <f:selectItem itemValue="23:00:00" itemLabel="11:00pm" />
                    <f:selectItem itemValue="22:00:00" itemLabel="10:00pm" />
                    <f:selectItem itemValue="21:00:00" itemLabel="9:00pm" />
                    <f:selectItem itemValue="20:00:00" itemLabel="8:00pm" />
                    <f:selectItem itemValue="19:00:00" itemLabel="7:00pm" />
                    <f:selectItem itemValue="18:00:00" itemLabel="6:00pm" />
                    <f:selectItem itemValue="17:00:00" itemLabel="5:00pm" />
                    <f:selectItem itemValue="16:00:00" itemLabel="4:00pm" />
                    <f:selectItem itemValue="15:00:00" itemLabel="3:00pm" />
                    <f:selectItem itemValue="14:00:00" itemLabel="2:00pm" />
                    <f:selectItem itemValue="13:00:00" itemLabel="1:00pm" />
                    <f:selectItem itemValue="12:00:00" itemLabel="12:00m" />
                    <f:selectItem itemValue="11:00:00" itemLabel="11:00am" />
                    <f:selectItem itemValue="10:00:00" itemLabel="10:00am" />
                    <f:selectItem itemValue="09:00:00" itemLabel="9:00am" />
                    <f:selectItem itemValue="08:00:00" itemLabel="8:00am" />
                    <f:selectItem itemValue="07:00:00" itemLabel="7:00am" />
                    <f:selectItem itemValue="06:00:00" itemLabel="6:00am" />
                    <f:selectItem itemValue="05:00:00" itemLabel="5:00am" />
                    <f:selectItem itemValue="04:00:00" itemLabel="4:00am" />
                    <f:selectItem itemValue="03:00:00" itemLabel="3:00am" />
                    <f:selectItem itemValue="02:00:00" itemLabel="2:00am" />
                    <f:selectItem itemValue="01:00:00" itemLabel="1:00am" />
                    <f:selectItem itemValue="00:00:00" itemLabel="0:00am" />
                </h:selectOneMenu>
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="A partir de esta hora y fecha será visible esta Petición de Trabajo" />

            <h:outputLabel styleClass="outputLabel" value="Fecha y Hora de Fin"/>
            <h:panelGroup>
                <div class="inputCalendar"><t:inputCalendar renderAsPopup="true" id="txtFechaF" required="false" value="#{Peticion.peticion.fin}" /></div>
                <h:selectOneMenu value="#{Peticion.peticion_horaFin}">
                    <f:selectItem itemValue="23:00:00" itemLabel="11:00pm" />
                    <f:selectItem itemValue="22:00:00" itemLabel="10:00pm" />
                    <f:selectItem itemValue="21:00:00" itemLabel="9:00pm" />
                    <f:selectItem itemValue="20:00:00" itemLabel="8:00pm" />
                    <f:selectItem itemValue="19:00:00" itemLabel="7:00pm" />
                    <f:selectItem itemValue="18:00:00" itemLabel="6:00pm" />
                    <f:selectItem itemValue="17:00:00" itemLabel="5:00pm" />
                    <f:selectItem itemValue="16:00:00" itemLabel="4:00pm" />
                    <f:selectItem itemValue="15:00:00" itemLabel="3:00pm" />
                    <f:selectItem itemValue="14:00:00" itemLabel="2:00pm" />
                    <f:selectItem itemValue="13:00:00" itemLabel="1:00pm" />
                    <f:selectItem itemValue="12:00:00" itemLabel="12:00m" />
                    <f:selectItem itemValue="11:00:00" itemLabel="11:00am" />
                    <f:selectItem itemValue="10:00:00" itemLabel="10:00am" />
                    <f:selectItem itemValue="09:00:00" itemLabel="9:00am" />
                    <f:selectItem itemValue="08:00:00" itemLabel="8:00am" />
                    <f:selectItem itemValue="07:00:00" itemLabel="7:00am" />
                    <f:selectItem itemValue="06:00:00" itemLabel="6:00am" />
                    <f:selectItem itemValue="05:00:00" itemLabel="5:00am" />
                    <f:selectItem itemValue="04:00:00" itemLabel="4:00am" />
                    <f:selectItem itemValue="03:00:00" itemLabel="3:00am" />
                    <f:selectItem itemValue="02:00:00" itemLabel="2:00am" />
                    <f:selectItem itemValue="01:00:00" itemLabel="1:00am" />
                    <f:selectItem itemValue="00:00:00" itemLabel="0:00am" />
                </h:selectOneMenu>
            </h:panelGroup>
            <h:outputText styleClass="outputText" value="Solo se podrá publicar el trabajo hasta esta hora y fecha" />

            <h:outputLabel styleClass="outputLabel" value="Tipo de Arhivo"/>
            <h:selectOneMenu id="cboTipoArchivo" styleClass="selectOneMenu" value="#{Peticion.peticion.fidTipoArchivo}" converter="TipoArchivoConverter">
                <f:selectItems value="#{TipoArchivo.itemsTipoArchivos}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Si se quiere se puede especificar el tipo de archivo que se va a subir, de lo contrario escojer \"Tipo Libre\"" />

            <h:outputLabel styleClass="outputLabel" value="Rubrica" />
            <h:selectOneMenu id="cboRubrica" styleClass="selectOneMenu" value="#{Peticion.peticion.fidRubrica}" converter="RubricaConverter">
                <f:selectItems value="#{Rubrica.listaRubricaAsItems}" />
            </h:selectOneMenu>
            <h:outputText styleClass="outputText" value="Se debe especificar con que rúbrica se evaluará el trabajo presentado por el alumno o grupo." />


            <h:panelGroup />
            <h:panelGroup>
                <h:commandButton styleClass="commandButton_Main" value="Siguiente >>" action="peticion_nuevoAsignacion" />
                <h:commandButton styleClass="commandButton_Main" value="Volver" action="volver" />
            </h:panelGroup>
            <h:panelGroup />

        </h:panelGrid>

    </h:form>

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
    
</f:view>