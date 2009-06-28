/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.pac.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang.StringUtils;


public class TextoValidator implements Validator{
 
    @Override
    public void validate(FacesContext fc, UIComponent uiC, Object o) throws ValidatorException {
        if (!StringUtils.isAlphaSpace((String) o)) {
           
            FacesMessage f = new FacesMessage("Error: ","Sólo esta permitido ingresar texto.");
            throw new ValidatorException(f);
        }
    }

     

}
