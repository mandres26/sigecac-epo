<%-- 
    Document   : nuevoSubArea
    Created on : 12/04/2009, 05:28:04 PM
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

<div>
         <h:form prependId="false" id="frmNV" >
              <table cellpadding="0" cellspacing="0" width="100%" >
                  <tr>
                    <td colspan="2" align="center" ><h3 class="title" >Registrar SubArea</h3></td>
                </tr>
                <tr><td height="20px" colspan="2" ></td></tr>
                 <tr>
                     <td colspan="2" ><h:messages style="color:red" /></td>
                 </tr>
                 <tr>
                     <td><h:outputLabel value="Area"/></td>
                     <td><h:selectOneMenu id="cmbArea" value="#{SubArea.area.idArea}" required="true" >
                    <f:selectItems value="#{SubArea.listaAreas}" ></f:selectItems>
                    <f:validator validatorId="comboValidator"></f:validator>
                </h:selectOneMenu></td>
                 </tr>
                 <tr>
                     <td width="80px" ><h:outputLabel value="SubArea"/></td>
                     <td> <h:inputText id="txtNombre" value="#{SubArea.subArea.nombre}" required="true" >
                    <f:validateLength
                        maximum="20"
                        minimum="5"/>
                    <f:validator
                        validatorId="textoValidator"/>
                </h:inputText></td>
                 </tr>
                 <tr>
                     <td></td>
                     <td> <h:commandButton id="btnGuardar" action="#{SubArea.crearSubArea}" value="Guardar" />
                     <h:commandButton id="btnLimpiar" action="listar" value="Cancelar" immediate="true" /></td>
                 </tr>
            </table>
            </h:form>
    </div>
    <br /><br />
    
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
