package com.pjyotik.dev.ums.api.services;

import com.pjyotik.dev.ums.api.dto.UserRequest;
import com.pjyotik.dev.ums.api.entity.User;
import com.pjyotik.dev.ums.api.exceptions.UserNotFoundException;
import com.pjyotik.dev.ums.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {

        int calculatedAge = calculateAge(userRequest.getDob());

        if (calculatedAge < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }

        User user = mapUserRequestToUser(userRequest);
        user.setAge(calculatedAge);
        return userRepository.save(user);
    }
    public List<User> getALlUsers() {
        return userRepository.findAll();
    }
    public User getUser(int id) throws UserNotFoundException {
        User user= userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }

    private int calculateAge(String dob) {
        LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
    private User mapUserRequestToUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setGender(userRequest.getGender());
        user.setDob(userRequest.getDob());
        user.setNationality(userRequest.getNationality());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());
        user.setUserName(userRequest.getUserName());
        user.setAddressLine1(userRequest.getAddressLine1());
        user.setAddressLine2(userRequest.getAddressLine2());
        user.setPostCode(userRequest.getPostCode());
        user.setCountry(userRequest.getCountry());
        user.setCompanyName(userRequest.getCompanyName());
        user.setPassword(userRequest.getPassword());
        return user;
    }
    @Transactional
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
