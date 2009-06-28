
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
    <a4j:outputPanel id="out1" layout="block" >
        <rich:modalPanel id="panel" height="400" autosized="true" >
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText value="Curso"></h:outputText>
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
                <h:form id="frmNuevoCursos">
                    <h:panelGrid columns="2" >
                        <h:outputLabel value="Ubicacion"/>
                        <h:selectOneMenu  value="#{Curso.subArea.idSubArea}">
                            <f:selectItems value="#{Curso.listaSubAreas}" />
                        </h:selectOneMenu>

                        <h:outputLabel value="Codigo Curso"/>
                        <h:inputText id="Codigo" value="#{Curso.curso.codigo}" required="true" >
                            <f:validateLength
                                maximum="6"
                                minimum="2"/>
                            <f:validator
                                validatorId="textoValidator"/>
                        </h:inputText>
                        <h:outputLabel value="Nombre"/>
                        <h:inputText id="Nombre" value="#{Curso.curso.nombre}" required="true"  >
                            <f:validateLength
                                maximum="20"
                                minimum="5"/>
                            <f:validator
                                validatorId="textoValidator"/>
                        </h:inputText>

                        <h:outputLabel value="Abreviatura"/>
                        <h:inputText id="Abreviatura" value="#{Curso.curso.abreviatura}" required="true"  >
                            <f:validateLength
                                maximum="8"
                                minimum="2"/>
                            <f:validator
                                validatorId="textoValidator"/>
                        </h:inputText>

                        <h:outputLabel value="Descripcion"/>
                        <h:inputTextarea id="Descripcion"  rows="10" cols="30" value="#{Curso.curso.descripcion}" required="true"  >
                            <f:validateLength
                                maximum="100"
                                minimum="10"/>
                            <f:validator
                                validatorId="textoValidator"/>
                        </h:inputTextarea>

                        <h:outputLabel value="Creditos"/>
                        <h:inputText id="txtCreditos" value="#{Curso.curso.nrocreditos}" required="true" >
                            <f:validateLongRange minimum="1" maximum="10" />
                        </h:inputText>

                        <h:outputLabel value="HorasTecnicas"/>
                        <h:inputText id="txtHorasTecnica" value="#{Curso.curso.horastecnicas}"  required="true" >
                            <f:validateLength
                                maximum="3"
                                minimum="1"/>

                        </h:inputText>

                        <h:outputLabel value="HorasPractica"/>
                        <h:inputText id="txtHorasPractica" value="#{Curso.curso.horaspracticas}" required="true" >
                            <f:validateLongRange minimum="1" maximum="10" />

                        </h:inputText>

                        <h:outputLabel value="HorasLaboratorio"/>
                        <h:inputText id="txtHorasLaboratorio" value="#{Curso.curso.horaslaboratorio}" required="true" >
                            <f:validateLongRange minimum="1" maximum="10" />

                        </h:inputText>                      
                        <BR>
                        <h:panelGroup />

                        <h:panelGroup />
                        <h:panelGroup>
                            <a4j:commandButton value="Guardar" id="CGuardar"  action="#{Curso.crearCurso}" reRender="out2" rendered="#{!Curso.cursoRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel')}.hide()" />
                            <a4j:commandButton value="Actualizar" id="CEditar" action="#{Curso.editarCurso}" reRender="out2" rendered="#{Curso.cursoRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel')}.hide()" />
                            <h:commandButton value="Cancelar" onclick="#{rich:component('panel')}.hide()" />
                        </h:panelGroup>
                    </h:panelGrid>
            </h:form></div>
            <br/>
        </rich:modalPanel>
    </a4j:outputPanel>

    <a4j:outputPanel id="panelPreReq" layout="block" >
        <rich:modalPanel id="panel2" autosized="true"  height="300">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText value="Pre Requisito"></h:outputText>
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
                <h:form id="frmNuevoPreReq">
                    <table>
                        <tr>
                            <td colspan="2" >
                                <rich:dataTable styleClass="tableGCU"  value="#{Prerequisito.listaCursos}" var="item" rows="20" id="simpletable">
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
                                        <a4j:commandButton value="Seleccionar" action="#{Prerequisito.setDataPrerequisito}" reRender="oPre2,oPre1" >
                                            <f:setPropertyActionListener target="#{Prerequisito.curso}" value="#{item}"></f:setPropertyActionListener>
                                            <a4j:actionparam name="a" value="#{Curso.curso.idCurso}" assignTo="#{Prerequisito.idCursoPadre}"/>
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
                            <td colspan="2" ><b>PreRequisitos</b></td>
                        </tr>
                        <tr>
                            <td width="85px" >Abreviatura:</td>
                            <td><h:outputLabel value="#{Prerequisito.prerequisito.abreviatura}"  id="oPre1" /></td>
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td><h:outputLabel value="#{Prerequisito.prerequisito.nombre}"  id="oPre2" /></td>
                        </tr>
                        <tr>
                            <td> </td>
                            <td>
                                <a4j:commandButton value="Guardar" id="PreReqGuardar"  action="#{Prerequisito.crearPrerequisito}" reRender="pPreReq" rendered="#{!Prerequisito.prerequisitoRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel2')}.hide()" />
                                <a4j:commandButton value="Actualizar" id="PreReqEditar" action="#{Prerequisito.editarPrerequisito}" reRender="pPreReq" rendered="#{Prerequisito.prerequisitoRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel2')}.hide()" />
                                <h:commandButton value="Cancelar" onclick="#{rich:component('panel2')}.hide()" />
                            </td>
                        </tr>
                    </table>
            </h:form></div>
            <br/>
        </rich:modalPanel>
    </a4j:outputPanel>

    <a4j:outputPanel id="panelEqui" layout="block" >
        <rich:modalPanel id="panel3" autosized="true"  height="300">
            <f:facet name="header">
                <h:panelGroup>
                    <h:outputText value="Equivalencia"></h:outputText>
                </h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/img_gcu/close.png" styleClass="hidelink" id="hidelink3"/>
                    <rich:componentControl for="panel3" attachTo="hidelink3" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <div style="height:300px;overflow:auto">
                 <a4j:outputPanel ajaxRendered="true">
                    <h:messages style="color:red" />
                 </a4j:outputPanel>
                <h:form id="frmNuevoEqui">
                    <table>
                        <tr>
                            <td colspan="2" >
                                <rich:dataTable  value="#{Equivalencia.listaCursos}" var="item" rows="20" id="TableEqui">
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
                                        <a4j:commandButton value="Seleccionar" action="#{Equivalencia.setDataEquivalencia}" reRender="oEqui2,oEqui1" >
                                            <f:setPropertyActionListener target="#{Equivalencia.curso}" value="#{item}"></f:setPropertyActionListener>
                                            <a4j:actionparam name="a" value="#{Curso.curso.idCurso}" assignTo="#{Equivalencia.idCursoPadre}"/>
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
                            <td colspan="2" ><b>Equivalencia</b></td>
                        </tr>
                        <tr>
                            <td width="70" >Abreviatura:</td>
                            <td><h:outputLabel value="#{Equivalencia.equivalencia.abreviatura}"  id="oEqui1" /></td>
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td><h:outputLabel value="#{Equivalencia.equivalencia.nombre}"  id="oEqui2" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a4j:commandButton value="Guardar" id="EquiGuardar"  action="#{Equivalencia.crearEquivalencia}" reRender="pEqui" rendered="#{!Equivalencia.equivalenciaRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel3')}.hide()" />
                                <a4j:commandButton value="Actualizar" id="EquiEditar" action="#{Equivalencia.editarEquivalencia}" reRender="pEqui" rendered="#{Equivalencia.equivalenciaRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel3')}.hide()" />
                                <h:commandButton value="Cancelar" onclick="#{rich:component('panel3')}.hide()" /></td>
                        </tr>
                    </table>
            </h:form></div>
            <br/>
        </rich:modalPanel>
    </a4j:outputPanel>

    <a4j:outputPanel id="panelEdicion" layout="block" >
    <rich:modalPanel id="panel4" autosized="true"  height="400">
    <f:facet name="header">
        <h:panelGroup>
            <h:outputText value="Edicion Curso" />
        </h:panelGroup>
    </f:facet>
    <f:facet name="controls">
        <h:panelGroup>
            <h:graphicImage value="/img_gcu/close.png" styleClass="hidelink" id="hidelink4"/>
            <rich:componentControl for="panel4" attachTo="hidelink4" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <div style="height:300px;overflow:auto">
        <a4j:outputPanel ajaxRendered="true">
            <h:messages style="color:red" />
        </a4j:outputPanel>
        <h:form id="frmNuevoEdicion">
        <h:panelGrid columns="2" >
            <h:outputLabel value="Cursos"/>
            <h:selectOneMenu disabled="true" id="cmbCursoxEdicion" value="#{EdicionCurso.idCursoPadre}">
                <f:selectItems value="#{EdicionCurso.listaCursos}" ></f:selectItems>
            </h:selectOneMenu>

            <h:outputLabel value="Edicion"/>

            <h:inputText id="Edicion" value="#{EdicionCurso.edicionCurso.edicion}">
                <f:validateLength
                    maximum="6"
                    minimum="6"/>
                <f:validator
                    validatorId="numeroValidator"/>
            </h:inputText>
            <h:outputLabel value="Descripcion"/>
            <h:inputTextarea
                id="textDescripcion"
                rows="10"
                cols="30"
                value="#{EdicionCurso.edicionCurso.descripcion}">
            <f:validateLength
                maximum="100"
                minimum="10"/>
            <f:validator
                validatorId="textoValidator"/>
            </h:inputTextarea>
            <h:panelGroup />
            <h:panelGroup>
                <a4j:commandButton value="Guardar" id="EdicionGuardar"  action="#{EdicionCurso.crearEdicionCurso}" reRender="pEdiciones" rendered="#{!EdicionCurso.edicionCursoRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel4')}.hide()" />
                <a4j:commandButton value="Actualizar" id="EdicionEditar" action="#{EdicionCurso.editarEdicionCurso}" reRender="pEdiciones" rendered="#{EdicionCurso.edicionCursoRegistrado}" oncomplete="if(#{empty facesContext.maximumSeverity}) #{rich:component('panel4')}.hide()" />
                <h:commandButton value="Cancelar" onclick="#{rich:component('panel4')}.hide()" />
            </h:panelGroup>

        </h:panelGrid>
    </h:form></div>
    <br/>
    </rich:modalPanel>
    </a4j:outputPanel>

    <table cellpadding="0" cellspacing="0" width="100%" >
        <tr>
            <td align="center" ><h3 class="title" >Mantenimiento de Cursos</h3></td>
        </tr>
        <tr>
            <td height="25px" >
            <h:form>
                <a4j:commandLink value="Nuevo Curso" action="#{Curso.nuevaCurso}" style="margin-left:40px;" styleClass="lnk n_curso"  oncomplete="#{rich:component('panel')}.show();return false" reRender="out1" />
            </h:form>
            </td>
        </tr>
        <tr>
            <td colspan="2" height="20px;" ></td></
        </tr>
        <tr><td >
                <h:form>
                    <a4j:outputPanel id="out2" layout="block" >
                        <rich:dataTable styleClass="tableGCU"  value="#{Curso.listaCursos}" var="item" rows="20" reRender="ds" id="simpletable">
                            <f:facet name="header">
                                <rich:columnGroup>
                                    <rich:column>
                                        <h:outputText value=""/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Abreviatura"/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Nombre"/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="Nro Cred."/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="H. Tec."/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="H. Pract."/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value="H Lab."/>
                                    </rich:column>
                                    <rich:column>
                                        <h:outputText value=""/>
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            <rich:column >
                                <a4j:commandButton value="Seleccionar" reRender="txtNombreCurso,tabs,pEdiciones,pEqui,pPreReq,btnEdiciones,btnEqui,btnPreReq" >
                                    <f:setPropertyActionListener target="#{Curso.curso}" value="#{item}"></f:setPropertyActionListener>
                                </a4j:commandButton>
                            </rich:column>
                            <rich:column filterBy="#{item.abreviatura}" filterEvent="onkeyup">
                                <f:facet name="header">
                                    <h:outputText value=" " title=""></h:outputText>
                                </f:facet>
                                <h:outputText value="#{item.abreviatura}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.nombre}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.nrocreditos}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.horastecnicas}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.horaspracticas}"/>
                            </rich:column>
                            <rich:column >
                                <h:outputText value="#{item.horaslaboratorio}"/>
                            </rich:column>
                            <rich:column >
                                <a4j:commandLink styleClass="edit" style="float:left" oncomplete="#{rich:component('panel')}.show();return false" reRender="out1" >
                                    <f:setPropertyActionListener target="#{Curso.curso}" value="#{item}"></f:setPropertyActionListener>
                                </a4j:commandLink>
                                <a4j:commandLink styleClass="delete" style="float:left" action="#{Curso.borrarCurso}" >
                                    <f:setPropertyActionListener target="#{Curso.curso}" value="#{item}"></f:setPropertyActionListener>
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
            <td align="left" >curso:  <b style="color:teal;font-size:15px;" ><h:outputText id="txtNombreCurso" value="#{Curso.curso.nombre}" /></b></td>
        </tr>
        <tr>
            <td align="center" height="25px" >&nbsp;</td>
        </tr>
        <tr>
            <td align="left" >
                <rich:tabPanel id="tabs"  rendered="true" selectedTab="PreReq" width="670px" >
                    <rich:tab id="tabPreReq" label="Pre Requisitos">
                        <h:form>
                            <a4j:commandLink id="btnPreReq" value="Nuevo PreRequisito" action="#{Prerequisito.nuevaPrerequisito}"  oncomplete="#{rich:component('panel2')}.show();return false" rendered="#{Curso.cursoRegistrado}" reRender="panelPreReq" />
                        </h:form>
                        <a4j:outputPanel id="pPreReq" layout="block" >
                            <h:dataTable styleClass="tableGCU" value="#{Curso.listaPrerequisito}" var="item">
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="" /></f:facet>
                                    <h:graphicImage value="/img/note.png" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Abrev." /></f:facet>
                                    <h:outputText value="#{item.abreviatura}" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Nombre" /></f:facet>
                                    <h:outputText value="#{item.nombre}" />
                                </h:column>
                                <h:column>
                                    <a4j:commandLink styleClass="edit" style="float:left"  oncomplete="#{rich:component('panel2')}.show();return false" reRender="panelPreReq" >
                                        <f:setPropertyActionListener target="#{Prerequisito.prerequisito}" value="#{item}"></f:setPropertyActionListener>
                                    </a4j:commandLink>
                                    <h:commandLink styleClass="delete" style="float:left" action="#{Prerequisito.borrarPrerequisito}">
                                        <f:setPropertyActionListener target="#{Prerequisito.prerequisito}" value="#{item}"></f:setPropertyActionListener>
                                    </h:commandLink>
                                </h:column>
                        </h:dataTable></a4j:outputPanel>
                    </rich:tab>
                    <rich:tab id="tabEqui" label="Equivalencias">
                        <h:form>
                            <a4j:commandLink id="btnEqui" value="Nueva Equivalencia" action="#{Equivalencia.nuevaEquivalencia}" rendered="#{Curso.cursoRegistrado}"  oncomplete="#{rich:component('panel3')}.show();return false" reRender="panelEqui" />
                        </h:form>
                        <a4j:outputPanel id="pEqui" layout="block" >
                            <h:dataTable styleClass="tableGCU" value="#{Curso.listaEquivalencia}" var="item">
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="" /></f:facet>
                                    <h:graphicImage value="/img/note.png" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Abrev." /></f:facet>
                                    <h:outputText value="#{item.abreviatura}" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Nombre" /></f:facet>
                                    <h:outputText value="#{item.nombre}" />
                                </h:column>
                                <h:column>
                                    <a4j:commandLink styleClass="edit" style="float:left"  oncomplete="#{rich:component('panel3')}.show();return false" reRender="panelEqui" >
                                        <f:setPropertyActionListener target="#{Equivalencia.equivalencia}" value="#{item}"></f:setPropertyActionListener>
                                    </a4j:commandLink>
                                    <h:commandLink styleClass="delete" style="float:left" action="#{Equivalencia.borrarEquivalencia}">
                                        <f:setPropertyActionListener target="#{Equivalencia.equivalencia}" value="#{item}"></f:setPropertyActionListener>
                                    </h:commandLink>
                                </h:column>
                        </h:dataTable></a4j:outputPanel>
                    </rich:tab>
                    <rich:tab id="tabEdiciones" label="Edicion Curso">
                        <h:form>
                            <a4j:commandLink  id="btnEdiciones" value="Nueva Edicion" action="#{EdicionCurso.nuevaEdicionCurso}" rendered="#{Curso.cursoRegistrado}"  oncomplete="#{rich:component('panel4')}.show();return false" reRender="panelEdicion" >
                                <a4j:actionparam name="aEdicion" value="#{Curso.curso.idCurso}" assignTo="#{EdicionCurso.idCursoPadre}"/>
                            </a4j:commandLink>
                        </h:form>
                        <a4j:outputPanel id="pEdiciones" layout="block" >
                            <h:dataTable styleClass="tableGCU" value="#{Curso.listaEdicionesCurso}" var="item">
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="" /></f:facet>
                                    <h:graphicImage value="/img/note.png" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Edicion" /></f:facet>
                                    <h:outputText value="#{item.edicion}" />
                                </h:column>
                                <h:column >
                                    <f:facet name="header" ><h:outputText value="Curso" /></f:facet>
                                    <h:outputText value="#{item.fxIdcurso.nombre}" />
                                </h:column>
                                <h:column>
                                    <a4j:commandLink styleClass="edit" style="float:left"  oncomplete="#{rich:component('panel4')}.show();return false" reRender="panelEdicion" >
                                        <f:setPropertyActionListener target="#{EdicionCurso.edicionCurso}" value="#{item}"></f:setPropertyActionListener>
                                        <a4j:actionparam name="aEdicion" value="#{Curso.curso.idCurso}" assignTo="#{EdicionCurso.idCursoPadre}"/>
                                    </a4j:commandLink>
                                    <h:commandLink styleClass="delete" style="float:left" action="#{EdicionCurso.borrarEdicionCurso}">
                                        <f:setPropertyActionListener target="#{EdicionCurso.edicionCurso}" value="#{item}"></f:setPropertyActionListener>
                                    </h:commandLink>
                                </h:column>
                        </h:dataTable>
                        </a4j:outputPanel>
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