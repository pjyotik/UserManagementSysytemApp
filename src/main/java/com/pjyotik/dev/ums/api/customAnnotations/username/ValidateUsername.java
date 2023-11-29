package com.pjyotik.dev.ums.api.customAnnotations.username;

import com.pjyotik.dev.ums.api.customAnnotations.username.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface ValidateUsername {

    String message() default "Invalid Username Passed: Please use another username, it is being taken by someone else";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
