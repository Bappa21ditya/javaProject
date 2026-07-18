package com.security.java_project.system_design.splitwise.sercieImpl;

import com.security.java_project.system_design.splitwise.service.GroupService;
import com.security.java_project.system_design.splitwise.entity.Group;
import com.security.java_project.system_design.splitwise.entity.User;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final List<Group> groups;

    public GroupServiceImpl(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Group createGroup(int id, String name) {

        Group existingGroup = getGroup(id);

        if (existingGroup != null) {
            System.out.println("Group already exists.");
            return existingGroup;
        }

        Group group = new Group(id, name);

        groups.add(group);

        return group;
    }

    @Override
    public void addMember(int groupId, User user) {

        Group group = getGroup(groupId);

        if (group == null) {
            System.out.println("Group not found.");
            return;
        }

        if (group.getMembers().contains(user)) {
            System.out.println(user.getName() + " is already a member.");
            return;
        }

        group.getMembers().add(user);

        System.out.println(user.getName() + " added to " + group.getName());
    }

    @Override
    public Group getGroup(int groupId) {

        for (Group group : groups) {

            if (group.getId() == groupId) {
                return group;
            }

        }

        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }
}
