
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
    <a4j:outputPanel id="modal1" layout="block" >
        <rich:modalPanel id="panel" height="400" autosized="true" >
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText value="Malla Curricular"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/img_gcu/close.png" styleClass="hidelink" id="hidelink"/>
                    <rich:componentControl for="panel" attachTo="hidelink" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <div style="height:500px;overflow:auto">
                <a4j:outputPanel ajaxRendered="true">
                    <h:messages style="color:red" />
                </a4j:outputPanel>
                <h:form id="frmMalla">
                    <h:panelGrid columns="2" >
                        <h:outputLabel value="Carrera"/>
                        <h:selectOneMenu  value="#{MallaCurricular.carrera.idCarrera}">
                            <f:selectItems value="#{MallaCurricular.listaCarreras}" />
                        </h:selectOneMenu>

                        <h:outputLabel value="Nombre"/>
                        <h:inputText id="mNombre" value="#{MallaCurricular.mallaCurricular.nombre}" required="true" >
                            <f:validateLength
                                maximum="6"
                                minimum="2"/>
                        </h:inputText>
                        <h:outputLabel value="Año"/>
                        <h:inputText id="mAno" value="#{MallaCurricular.mallaCurricular.ano}" required="true" >
                            <f:validateLongRange minimum="2009" maximum="2020" />
                        </h:inputText>
                        <h:outputLabel value="Semestre"/>
                        <h:inputText id="mSemestre" value="#{MallaCurricular.mallaCurricular.semestre}"  required="true" >                                 
                        </h:inputText>
                        <h:outputLabel value="Nro Ciclos"/>
                        <h:inputText id="mNroCiclos" value="#{MallaCurricular.mallaCurricular.nrociclos}" required="true" >
                            <f:validateLongRange minimum="1" maximum="12" />
                        </h:inputText>
                        <h:outputLabel value="Nro Creditos"/>
                        <h:inputText id="mNroCreditos" value="#{MallaCurricular.mallaCurricular.nrocreditos}" required="true" >                            
                        </h:inputText>
                         <h:outputLabel value="Descripcion"/>
                        <h:inputTextarea id="Descripcion"  rows="10" cols="30" value="#{MallaCurricular.mallaCurricular.descripcion}" required="true"  >
                            <f:validateLength maximum="200" minimum="10"/>
                            <f:validator validatorId="textoValidator"/>
                        </h:inputTextarea>
                        <BR>
                        <h:panelGroup />
                        <h:panelGroup />
                        <h:panelGroup>
                            <a4j:commandButton value="Guardar" id="MLLGuardar"  action="#{MallaCurricular.crearMallaCurricular}" reRender="tableMalla" rendered="#{!MallaCurricular.mallaCurricularRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel')}.hide()" />
                            <a4j:commandButton value="Actualizar" id="MLLEditar" action="#{MallaCurricular.editarMallaCurricular}" reRender="tableMalla" rendered="#{MallaCurricular.mallaCurricularRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel')}.hide()" />
                            <h:commandButton value="Cancelar" onclick="#{rich:component('panel')}.hide()" />
                        </h:panelGroup>
                    </h:panelGrid>
            </h:form></div>
            <br/>
        </rich:modalPanel>
    </a4j:outputPanel>

    <a4j:outputPanel id="panelCiclo" layout="block" >
        <rich:modalPanel id="panel2" autosized="true"  height="300">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText value="Curso - Ciclo"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/img_gcu/close.png" styleClass="hidelink" id="hidelink2"/>
                    <rich:componentControl for="panel2" attachTo="hidelink2" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <div style="height:300px;overflow:auto">
                <a4j:outputPanel ajaxRendered="true">
                    <h:messages style="color:red" />
                 </a4j:outputPanel>
                <h:form id="frmCursoCiclo">
                    <table>
                        <tr>
                            <td colspan="2" >
                                <rich:dataTable styleClass="tableGCU"  value="#{Curso.listaCursos}" var="item" rows="20" >
                                    <f:facet name="header">
                                        <rich:columnGroup>
                                            <rich:column>
                                                <h:outputText value=""/>
                                            </rich:column>
                                            <rich:column>
                                                <h:outputText value="Abreviatura" />
                                            </rich:column>
                                            <rich:column>
                                                <h:outputText value="Nombre" />
                                            </rich:column>
                                        </rich:columnGroup>
                                    </f:facet>
                                    <rich:column >
                                        <a4j:commandButton value="Seleccionar" action="#{Ciclo.setDataCiclo}" reRender="oCiclo" >
                                            <f:setPropertyActionListener target="#{Ciclo.curso}" value="#{item}"></f:setPropertyActionListener>
                                            <a4j:actionparam name="a" value="#{MallaCurricular.mallaCurricular.idMallacurricular}" assignTo="#{Ciclo.idMallaCurricularPadre}"/>
                                        </a4j:commandButton>
                                    </rich:column>
                                        <rich:column filterBy="#{item.abreviatura}" filterEvent="onkeyup">
                                        <f:facet name="header">
                                            <h:outputText value=" " title=""></h:outputText>
                                        </f:facet>
                                        <h:outputText value="#{item.abreviatura}"  />
                                    </rich:column>
                                    <rich:column >
                                        <h:outputText value="#{item.nombre}" />
                                    </rich:column>
                                </rich:dataTable>
                            </td>
                        </tr>
                        <tr bgcolor="#cccccc" >
                            <td colspan="2" ><b></b></td>
                        </tr>
                        <tr>
                            <td width="85px" >Ciclo:</td>
                            <td><h:outputLabel value="#{Ciclo.ciclo.ciclo}"  id="oCiclo" /></td>
                        </tr>                        
                        <tr>
                            <td> </td>
                            <td>
                                <a4j:commandButton value="Guardar" id="CicloGuardar"  action="#{Ciclo.crearCiclo}" reRender="pCiclo" rendered="#{!Ciclo.cicloRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel2')}.hide()" />
                                <a4j:commandButton value="Actualizar" id="CicloEditar" action="#{Ciclo.editarCiclo}" reRender="pCiclo" rendered="#{Ciclo.cicloRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel2')}.hide()" />
                                <h:commandButton value="Cancelar" onclick="#{rich:component('panel2')}.hide()" />
                            </td>
                        </tr>
                    </table>
            </h:form></div>
            <br/>
        </rich:modalPanel>
    </a4j:outputPanel>

    <table cellpadding="0" cellspacing="0" width="100%" >
        <tr>
            <td align="center" ><h3 class="title" >Mantenimiento de MallaCurricular</h3></td>
        </tr>
        <tr>
            <td height="25px" >
            <h:form>
                <a4j:commandLink value="Nueva Malla Curricular" action="#{MallaCurricular.nuevaMallaCurricular}" style="margin-left:40px;" styleClass="lnk n_curso"  oncomplete="#{rich:component('panel')}.show();return false" reRender="modal1" />
            </h:form>
            </td>
        </tr>
        <tr>
            <td colspan="2" height="20px;" ></td></
        </tr>
        <tr><td >
                <h:form>
                    <a4j:outputPanel id="tableMalla" layout="block" >
                        <rich:dataTable styleClass="tableGCU"  value="#{MallaCurricular.listarMallaCurricular}" var="item" rows="20" reRender="ds" id="simpletable">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <rich:column>
                                        <h:outputText value=""/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Abreviatura"/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Semestre"/>
                                    </rich:column>
                                     <rich:column>
                                        <h:outputText value="Año"/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Total Cred."/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Nro Ciclos"/>
                                    </rich:column>                                                                   
                                    <rich:column>
                                        <h:outputText value=""/>
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            <rich:column >
                                <a4j:commandButton value="Seleccionar" reRender="txtCurricula,btnCiclo,cmbCiclo,tabs,pCiclo" >
                                    <f:setPropertyActionListener target="#{MallaCurricular.mallaCurricular}" value="#{item}"></f:setPropertyActionListener>
                                </a4j:commandButton>
                            </rich:column>
                            <rich:column filterBy="#{item.nombre}" filterEvent="onkeyup">
                                <f:facet name="header">
                                    <h:outputText value=" " title=""></h:outputText>
                                </f:facet>
                                <h:outputText value="#{item.nombre}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.semestre}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.ano}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.nrocreditos}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.nrociclos}"/>
                            </rich:column>                            
                            <rich:column >
                                <a4j:commandLink styleClass="edit" style="float:left" oncomplete="#{rich:component('panel')}.show();return false" reRender="modal1" >
                                    <f:setPropertyActionListener target="#{MallaCurricular.mallaCurricular}" value="#{item}"></f:setPropertyActionListener>
                                </a4j:commandLink>
                                <a4j:commandLink styleClass="delete" style="float:left" action="#{MallaCurricular.borrarMallaCurricular}" >
                                    <f:setPropertyActionListener target="#{MallaCurricular.mallaCurricular}" value="#{item}"></f:setPropertyActionListener>
                                 </a4j:commandLink>
                            </rich:column>
                            <f:facet name="footer">
                                <rich:datascroller id="ds" renderIfSinglePage="false"></rich:datascroller>
                            </f:facet>
                    </rich:dataTable>   </a4j:outputPanel>
                </h:form>
            </td>
        </tr>
    </table>
    <br>
</div>
<%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
<%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>
<h:form>
    <table cellpadding="0" cellspacing="0" >
        <tr>
            <td align="left" >MallaCurricular:  <b style="color:teal;font-size:15px;" ><h:outputText id="txtCurricula" value="#{MallaCurricular.mallaCurricular.nombre}" /></b></td>
        </tr>
        <tr>
            <td align="center" height="25px" >&nbsp;</td>
        </tr>
        <tr>
            <td align="left" >                  
                <rich:tabPanel id="tabs"  rendered="true" selectedTab="tabCiclo" width="670px" >
                    <rich:tab id="tabCiclo" label="Por Ciclo">
                        <h:form>                            <table>
                                <tr>
                                    <td>
                                    <h:selectOneMenu  value="#{Ciclo.selectCiclo}" id="cmbCiclo" >
                                            <f:selectItems value="#{MallaCurricular.listaCiclo}" />
                                            <a4j:actionparam name="aaa" value="#{MallaCurricular.mallaCurricular.idMallacurricular}" assignTo="#{Ciclo.idMallaCurricularPadre}"/>
                                        </h:selectOneMenu>
                                    </td>
                                </tr>
                                <tr><td height="10px" ></td></tr>
                                <tr>
                                    <td><a4j:commandLink id="btnCiclo" value="Agregar Curso" action="#{Ciclo.nuevaCiclo}"  oncomplete="#{rich:component('panel2')}.show();return false" rendered="#{MallaCurricular.mallaCurricularRegistrado}" reRender="panelCiclo" /></td>
                                </tr>
                            </table>
                        </h:form>
                        <a4j:outputPanel id="pCiclo" layout="block" >
                            <h:dataTable styleClass="tableGCU" value="#{Ciclo.listarCiclo}" var="item">
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="" /></f:facet>
                                    <h:graphicImage value="/img/note.png" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Ciclo" /></f:facet>
                                    <h:outputText value="#{item.ciclo}" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="MallaCurricular" /></f:facet>
                                    <h:outputText value="#{item.fkMallaCurricular.nombre}" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Nombre" /></f:facet>
                                    <h:outputText value="#{item.fkCurso.nombre}" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Abrev." /></f:facet>
                                    <h:outputText value="#{item.fkCurso.abreviatura}" />
                                </h:column>
                                <h:column>
                                    <a4j:commandLink styleClass="edit" style="float:left"  oncomplete="#{rich:component('panel2')}.show();return false" reRender="panelCiclo" >
                                        <f:setPropertyActionListener target="#{Ciclo.ciclo}" value="#{item}"></f:setPropertyActionListener>
                                    </a4j:commandLink>
                                    <h:commandLink styleClass="delete" style="float:left" action="#{Ciclo.borrarCiclo}">
                                        <f:setPropertyActionListener target="#{Ciclo.ciclo}" value="#{item}"></f:setPropertyActionListener>
                                    </h:commandLink>
                                </h:column>
                        </h:dataTable></a4j:outputPanel>
                    </rich:tab>
                </rich:tabPanel>
            </td>
        </tr>
    </table>
</h:form>
<%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
<%@include file="../WEB-INF/jspf/bloque_inicio.jspf" %>
    <div>ssss</div>
<%@include file="../WEB-INF/jspf/bloque_fin.jspf" %>
<%@include file="../WEB-INF/jspf/cuadro_fin.jspf" %>
<%@include file="../WEB-INF/jspf/pie.jspf" %>
<%@include file="../WEB-INF/jspf/html_fin.jspf" %>
</f:view>