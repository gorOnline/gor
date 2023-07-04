package com.app.gorworld.controller;

import com.app.gorworld.dto.*;
import com.app.gorworld.exception.UserNotFoundException;
import com.app.gorworld.model.User;
import com.app.gorworld.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping(value = "/get",produces = "application/json")
    public ResponseEntity<?> getUsers(@RequestBody OtpRequestDto userDto){
        try {
            User result = userService.getUserData(userDto.getMobileNumber());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create",consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            User existingUser = userService.getUser(user.getMobileNumber());
            Long userId = null;
            CreateUserDto result = new CreateUserDto();
            if(null == existingUser) {
                userId = userService.createUser(user).getId();
            }else{
                result.setMessage("User already exists with number "+user.getMobileNumber());
                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            result.setUserId(userId);
            if(userId!=null)
                result.setMessage("User created successfully");
            else
                result.setMessage("User creation failed");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/update-plan",consumes = "application/json")
    public ResponseEntity<?> updatePlan(@RequestBody UpdatePlanDto updatePlanDto){
        try {
            User existingUser = userService.getUser(updatePlanDto.getMobileNumber());
            User result = null;
            if(null == existingUser) {
                return new ResponseEntity<>("User not found with number "+ updatePlanDto.getMobileNumber(), HttpStatus.INTERNAL_SERVER_ERROR);
            }else{
                result = userService.updateUserPlan(updatePlanDto.getPlan(), existingUser);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/verify-plan",consumes = "application/json")
    public ResponseEntity<?> updatePlan(@RequestBody OtpRequestDto requestDto){
        try {
            User existingUser = userService.getUserData(requestDto.getMobileNumber());
            VerifyPlanDto result = null;
            if(null == existingUser) {
                return new ResponseEntity<>("User not found with number "+ requestDto.getMobileNumber(), HttpStatus.INTERNAL_SERVER_ERROR);
            }else{
                result = userService.verifyPlan(existingUser);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
