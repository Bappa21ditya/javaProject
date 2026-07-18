package com.security.java_project.system_design.splitwise.Strategy;
import com.security.java_project.system_design.splitwise.entity.Split;
import com.security.java_project.system_design.splitwise.entity.User;

import java.util.List;


public interface SplitStrategy {

    List<Split> calculateSplit(double amount,
                               List<User> participants);
}
