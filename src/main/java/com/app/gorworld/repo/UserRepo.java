package com.app.gorworld.repo;

import com.app.gorworld.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, Long> {
    User findByMobileNumber(String mobileNumber);
}
