package com.security.java_project.system_design.inventory.repos;

import com.security.java_project.system_design.inventory.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> users =
            new HashMap<>();

    public void save(User user) {

        users.put(
                user.getUserId(),
                user);
    }

    public User findById(
            String userId) {

        return users.get(userId);
    }

    public List<User> findAll() {

        return new ArrayList<>(
                users.values());
    }

    public boolean exists(
            String userId) {

        return users.containsKey(
                userId);
    }

    public void delete(
            String userId) {

        users.remove(userId);
    }
}
