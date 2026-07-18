package com.security.java_project.system_design.splitwise.Strategy;
import com.security.java_project.system_design.splitwise.entity.Group;
import com.security.java_project.system_design.splitwise.entity.Split;
import com.security.java_project.system_design.splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calculateSplit(double amount,
                                      List<User> participants) {

        List<Split> splits = new ArrayList<>();

        if (participants == null || participants.isEmpty()) {
            return splits;
        }

        double share = amount / participants.size();

        for (User user : participants) {

            splits.add(new Split(user, share));

        }

        return splits;
    }
}
