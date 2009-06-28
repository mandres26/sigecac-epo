/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author supervisor
 */
public class TextoValidator implements Validator{
 
    @Override
    public void validate(FacesContext fc, UIComponent uiC, Object o) throws ValidatorException {
        if (!StringUtils.isAlphaSpace((String) o)) {
            //HtmlInputText i = (HtmlInputText) uiC;
            FacesMessage f = new FacesMessage("Solo esta permitido ingresar" + " texto.");
            throw new ValidatorException(f);
        }
    }

     

}
