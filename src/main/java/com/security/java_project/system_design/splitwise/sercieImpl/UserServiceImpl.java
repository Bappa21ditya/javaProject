package com.security.java_project.system_design.splitwise.sercieImpl;
import com.security.java_project.system_design.splitwise.entity.User;

import com.security.java_project.system_design.splitwise.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public User createUser(int id, String name) {

        User existingUser = getUser(id);

        if (existingUser != null) {
            System.out.println("User already exists.");
            return existingUser;
        }

        User user = new User(id, name);

        users.add(user);

        return user;
    }

    @Override
    public User getUser(int id) {

        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }

        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

}
