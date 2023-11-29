package com.pjyotik.dev.ums.api.dto;

import com.pjyotik.dev.ums.api.customAnnotations.countries.ValidateCountry;
import com.pjyotik.dev.ums.api.customAnnotations.email.ValidateEmail;
import com.pjyotik.dev.ums.api.customAnnotations.gender.ValidateGender;
import com.pjyotik.dev.ums.api.customAnnotations.username.ValidateUsername;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    /*
        @NotBlank: Ensures that the annotated string is not null and has at least one non-whitespace character.
     */
    @NotBlank(message = "First Name is Required")
    private String firstName;

    @NotBlank(message = "Last Name is Required")
    private String lastName;

    /*
        Custom Annotation created to validate the gender passed
     */
    @ValidateGender
    private String gender;

    @NotBlank(message = "Date of Birth is Required")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dob;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "Phone number is Required")
    @Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    /*
        @Email: Ensures that the annotated string is a valid email address.
     */
    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid email address")
    @ValidateEmail
    private String email;

    /*
        The @Transient annotation is used for fields that should not be persisted in the database, such as confirmEmail and confirmPassword.
        They are used for validation purposes but are not part of the database schema.
     */
    @Transient
    @NotBlank(message = "Confirm email is Required")
    private String confirmEmail;

    @ValidateUsername
    private String userName;

    @Size(max = 50, message = "Address Line 1 must not exceed 50 characters")
    private String addressLine1;
    @Size(max = 50, message = "Address Line 2 must not exceed 50 characters")
    private String addressLine2;
    @Size(max = 7, message = "Post Code must not exceed 7 characters")
    private String postCode;

    @ValidateCountry
    private String country;

    private String companyName;

    /*
        @Size: Specifies the size constraints on a string (e.g., minimum and maximum length).
     */
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Transient
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

}
