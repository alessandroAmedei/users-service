package it.amedei.validator;/*
@author Alessandro Amedei
2022    
*/

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {
    @Override
    public void initialize(NullOrNotBlank constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s == null || s.trim().length() > 0;
    }
}
