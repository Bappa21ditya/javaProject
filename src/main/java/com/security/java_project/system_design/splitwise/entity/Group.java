package com.security.java_project.system_design.splitwise.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int id;
    private String name;
    private List<User> members;

    public Group(int id, String name) {

        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }

}
