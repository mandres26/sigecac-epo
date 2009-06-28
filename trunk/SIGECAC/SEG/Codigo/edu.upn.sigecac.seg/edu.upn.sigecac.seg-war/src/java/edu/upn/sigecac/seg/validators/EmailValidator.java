package edu.upn.sigecac.seg.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent,
            Object value) throws ValidatorException {
        org.apache.commons.validator.EmailValidator emailValidator =
                org.apache.commons.validator.EmailValidator.getInstance();
        //HtmlInputText htmlInputText = (HtmlInputText) uiComponent;

        if (!emailValidator.isValid((String) value)) {
            FacesMessage facesMessage = new FacesMessage("El formato de E-mail no es valido.");
            throw new ValidatorException(facesMessage);
        }
    }
}
