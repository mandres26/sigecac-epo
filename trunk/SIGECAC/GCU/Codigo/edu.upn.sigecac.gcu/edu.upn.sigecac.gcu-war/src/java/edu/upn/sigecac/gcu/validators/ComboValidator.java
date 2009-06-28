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
public class ComboValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uiC, Object o) throws ValidatorException {
        if(StringUtils.isNumeric(o.toString())){
            int sel =Integer.parseInt(o.toString());
            if(sel>0){
            }else{
                 FacesMessage f = new FacesMessage("Seleccionar Combo.");
                 throw new ValidatorException(f);
            }

          
        }
    }

}