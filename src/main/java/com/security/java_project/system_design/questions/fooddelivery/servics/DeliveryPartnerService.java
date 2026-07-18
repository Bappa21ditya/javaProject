package com.security.java_project.system_design.questions.fooddelivery.servics;

import com.security.java_project.system_design.questions.fooddelivery.entity.DeliveryPartner;
import com.security.java_project.system_design.questions.fooddelivery.entity.Order;

public interface DeliveryPartnerService {

    public DeliveryPartner assignPartner(Order order);

    public void pickUp(Order order);

    public void deliver(Order order);
}
