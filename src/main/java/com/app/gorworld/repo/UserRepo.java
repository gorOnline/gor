package com.app.gorworld.repo;

import com.app.gorworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByMobileNumber(String mobileNumber);
}
