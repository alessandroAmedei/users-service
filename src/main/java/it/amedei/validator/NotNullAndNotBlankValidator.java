package it.amedei.validator;/*
@author Alessandro Amedei
Net Studio S.p.A
2022    
*/

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullAndNotBlankValidator implements ConstraintValidator<NotNullAndNotBlank, String> {
    @Override
    public void initialize(NotNullAndNotBlank constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.trim().length() > 0;
    }
}
