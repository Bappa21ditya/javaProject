package com.security.java_project.system_design.MyList.fooddelivery.servics;
import com.security.java_project.system_design.MyList.fooddelivery.entity.User;
import com.security.java_project.system_design.MyList.fooddelivery.entity.Address;

public interface UserService {

    public void viewOrders(User user);

    public void updateAddress(User user, Address address);
}
