<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>


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
         <td align="center" ><h3 class="title" >Listar Nivel Profesional</h3></td>
      </tr>
      <tr><td valign="middle" height="25px" > <h:commandLink id="btnNuevoNivelProfesional" value="Nuevo NivelProfesional" action="#{NivelProfesional.nuevoNivelProfesional}"/></td></tr>
      <tr><td height="25px" >&nbsp;</td></tr>
      <tr><td>
          <rich:dataTable styleClass="tableGCU" value="#{NivelProfesional.listaNivelProfesionales}" var="item" rows="20" reRender="ds" id="simpletable">
            <f:facet name="header">
                <rich:columnGroup>
                    <rich:column >
                        <h:outputText value=""/>
                    </rich:column>
                    <rich:column >
                        <h:outputText value="Codigo"/>
                    </rich:column>
                    <rich:column>
                        <h:outputText value="Nivel Profesional"/>
                    </rich:column>
                    <rich:column>
                        <h:outputText value=""/>
                    </rich:column>
                </rich:columnGroup>
            </f:facet>
             <rich:column >
               <h:graphicImage value="/img/note.png" />
            </rich:column>
            <rich:column filterBy="#{item.idNivelProfesional}" filterEvent="onkeyup">
                <f:facet name="header">
                    <h:outputText value=" " title="Hack due to bug. Shuold be remoevd till release"></h:outputText>
                </f:facet>
                <h:outputText value="#{item.idNivelProfesional}"/>
            </rich:column>
            <rich:column filterBy="#{item.nivelProfesional}" filterEvent="onkeyup">
                <h:outputText value="#{item.nivelProfesional}"/>
            </rich:column>
            <rich:column >
                 <h:commandLink id="btnActualizar" value="Editar" action="editar">
                     <f:setPropertyActionListener target="#{NivelProfesional.nivelProfesional}" value="#{item}"></f:setPropertyActionListener>
                 </h:commandLink> |
                 <h:commandLink id="btnEliminar" value="Eliminar" action="#{NivelProfesional.borrarNivelProfesional}">
                     <f:setPropertyActionListener target="#{NivelProfesional.nivelProfesional}" value="#{item}"></f:setPropertyActionListener>
                  </h:commandLink>
            </rich:column>
            <f:facet name="footer">
                <rich:datascroller id="ds" renderIfSinglePage="false"></rich:datascroller>
            </f:facet>
        </rich:dataTable>                              

      </td>
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