package com.pjyotik.dev.ums.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users_tbl")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    // Custom Annotation created to validate the passed gender by the user, should be either male or female
    private String gender;
    private String dob;
    // Calculated based on the DOB passed, cannot be less than 18 yrs
    private int age;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String userName;
    private String addressLine1;
    private String addressLine2;
    private String postCode;
    private String country;
    private String companyName;
    private String password;
    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

}
