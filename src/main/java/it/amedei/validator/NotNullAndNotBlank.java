package it.amedei.validator;/*
@author Alessandro Amedei
2022    
*/

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullAndNotBlankValidator.class)
public @interface NotNullAndNotBlank {
    String message() default "must be not null and not blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
