package com.pjyotik.dev.ums.api.customAnnotations.gender;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GenderValidator.class)
public @interface ValidateGender {

    String message() default "Invalid Gender Passed: It should be either Male Or Female";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
