package com.security.java_project.system_design.MyList.splitwise.service;
import com.security.java_project.system_design.MyList.splitwise.entity.User;

import java.util.List;

public interface UserService {

    User createUser(int id, String name);

    User getUser(int id);

    List<User> getAllUsers();

}
