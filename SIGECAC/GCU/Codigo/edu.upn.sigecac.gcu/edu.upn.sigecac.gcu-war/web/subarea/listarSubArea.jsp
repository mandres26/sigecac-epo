<%-- 
    Document   : listarSubArea
    Created on : 12/04/2009, 05:27:54 PM
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

     <div style="padding-left:20px;" >
            <h:form>
        <table cellpadding="0" cellspacing="0" width="100%" >
     <tr>
         <td align="center" ><h3 class="title" >Listar SubAreas</h3></td>
      </tr>
      <tr><td valign="middle" height="25px" > <h:commandLink id="btnNuevoSubArea" value="Nueva SubArea" action="#{SubArea.nuevaSubArea}"/></td></tr>
      <tr><td height="25px" >&nbsp;</td></tr>
      <tr><td><h:dataTable styleClass="tableGCU" value="#{SubArea.listaSubAreas}" var="item">
                                    <h:column >
                                        <f:facet name="header" ><h:outputText value="" /></f:facet>
                                        <h:graphicImage value="/img/note.png" />
                                    </h:column>
                                     <h:column >
                                        <f:facet name="header" ><h:outputText value="Codigo" /></f:facet>
                                        <h:outputText value="#{item.idSubArea}" />
                                    </h:column>
                                    <h:column >
                                        <f:facet name="header" ><h:outputText value="Area" /></f:facet>
                                        <h:outputText value="#{item.fxIdarea.area}" />
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header" ><h:outputText value="SubArea" style="width:180px" /></f:facet>
                                        <h:outputText value="#{item.nombre}" />
                                    </h:column>
                                     <h:column>
                                        <h:commandLink id="btnActualizar" value="Editar" action="editar">
                                             <f:setPropertyActionListener target="#{SubArea.subArea}" value="#{item}"></f:setPropertyActionListener>
                                        </h:commandLink> |
                                         <h:commandLink id="btnEliminar" value="Eliminar" action="#{SubArea.borrarSubArea}">
                                             <f:setPropertyActionListener target="#{SubArea.subArea}" value="#{item}"></f:setPropertyActionListener>
                                        </h:commandLink>
                                    </h:column>

                                </h:dataTable>
            </td>
      </tr>
      </table>
           </h:form>
    </div>
    <br /><br /><br />  
    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>

    <br />

    <%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
    <%@include file="../WEB-INF/jspf/pie.jspf" %>
    <%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>
