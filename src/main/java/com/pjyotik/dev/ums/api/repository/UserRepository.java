package com.pjyotik.dev.ums.api.repository;

import com.pjyotik.dev.ums.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserId(long id);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
}
