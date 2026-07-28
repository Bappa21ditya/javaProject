package com.security.java_project.system_design.MyList.fooddelivery.servics;

import com.security.java_project.system_design.MyList.fooddelivery.entity.DeliveryPartner;
import com.security.java_project.system_design.MyList.fooddelivery.entity.Order;

public interface DeliveryPartnerService {

    public DeliveryPartner assignPartner(Order order);

    public void pickUp(Order order);

    public void deliver(Order order);
}
