package com.security.java_project.system_design.MyList.splitwise.service;
import com.security.java_project.system_design.MyList.splitwise.entity.Group;
import com.security.java_project.system_design.MyList.splitwise.entity.User;

import java.util.List;

public interface GroupService {

    Group createGroup(int id, String name);

    void addMember(int groupId, User user);

    Group getGroup(int groupId);

    List<Group> getAllGroups();
}
