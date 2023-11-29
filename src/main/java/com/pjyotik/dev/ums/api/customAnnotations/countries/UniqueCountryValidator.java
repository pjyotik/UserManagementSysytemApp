package com.pjyotik.dev.ums.api.customAnnotations.countries;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UniqueCountryValidator implements ConstraintValidator<ValidateCountry, String> {

    @Override
    public boolean isValid(String countryName, ConstraintValidatorContext constraintValidatorContext) {
        if (countryName == null || getCountries().contains(countryName)) {
            return true;
        }

        String validCountriesMessage = "Invalid Country Name Passed..!!! Please provide a valid Country Name..."
                                        + "Valid Countries are: " + getCountries();

        constraintValidatorContext.buildConstraintViolationWithTemplate(validCountriesMessage)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }

    private List<String> getCountries(){
        List<String> countryNames = new ArrayList<>();
        // Convert country codes to country names
        for (String countryCode : Locale.getISOCountries()) {
            Locale locale = new Locale("", countryCode);
            String cName = locale.getDisplayCountry();
            countryNames.add(cName);
        }
        return countryNames;
    }
}
