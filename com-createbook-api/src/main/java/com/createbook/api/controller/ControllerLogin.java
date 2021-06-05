package com.createbook.api.controller;

import com.createbook.api.domain.Status;
import com.createbook.api.domain.User;
import com.createbook.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

@RestController
class UserController {
        @Autowired
        UserRepository userRepository;


        @PostMapping("/users/register")
        public Status registerUser(@Valid @RequestBody User newUser) {
            List<User> users = userRepository.findAll();
            System.out.println("New user: " + newUser.toString());
            for (User user : users) {
                System.out.println("Registered user: " + newUser.toString());
                if (user.equals(newUser)) {
                    System.out.println("User Already exists!");
                    return Status.USER_ALREADY_EXISTS;
                }
            }
            userRepository.save(newUser);
            return Status.SUCCESS;
        }
        @PostMapping("/users/login")
        public Status loginUser(@Valid @RequestBody User user)  {
            List<User> users = userRepository.findAll();
            for (User other : users) {
                if (other.equals(user)) {
                    userRepository.save(user);
                    return Status.SUCCESS;
                }
            }
            return Status.FAILURE;
        }

    }





