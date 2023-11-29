package com.pjyotik.dev.ums.api.customAnnotations.email;

import com.pjyotik.dev.ums.api.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {

    private final UserService userService;

    public EmailValidator(UserService userService) {
        this.userService = userService;
    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && !userService.emailExists(email);
    }
}
