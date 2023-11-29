package com.pjyotik.dev.ums.api.customAnnotations.countries;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueCountryValidator.class)
public @interface ValidateCountry {

    String message() default "Invalid Country Name Passed: Please use a valid Country Name. Check the List of Valid Countries from the User Manual Document";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
