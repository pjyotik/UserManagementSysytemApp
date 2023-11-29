package com.pjyotik.dev.ums.api.customAnnotations.gender;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class GenderValidator implements ConstraintValidator<ValidateGender, String> {

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext constraintValidatorContext) {
        List<String> genders = Arrays.asList("Male", "Female");
        return genders.contains(gender);
    }
}
