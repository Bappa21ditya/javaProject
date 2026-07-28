package com.security.java_project.system_design.MyList.inventory.service;

import com.security.java_project.system_design.MyList.inventory.entity.User;
import com.security.java_project.system_design.MyList.inventory.repos.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public User getUser(String userId) {
        return userRepository.findById(userId);
    }
}
