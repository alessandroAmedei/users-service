package it.amedei.validator;/*
@author Alessandro Amedei
2022    
*/

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrNotBlankValidator.class)
public @interface NullOrNotBlank {
    String message() default "must be null or not blank";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}
