package com.security.java_project.system_design.questions.fooddelivery.serviceImpl;

import com.security.java_project.system_design.questions.fooddelivery.entity.DeliveryPartner;
import com.security.java_project.system_design.questions.fooddelivery.entity.Order;
import com.security.java_project.system_design.questions.fooddelivery.enums.OrderStatus;
import com.security.java_project.system_design.questions.fooddelivery.servics.DeliveryPartnerService;

import java.util.List;

public class FoodDeliveryPartnerServiceImpl implements DeliveryPartnerService {

    private final List<DeliveryPartner> deliveryPartners;

    public FoodDeliveryPartnerServiceImpl(List<DeliveryPartner> deliveryPartners) {
        this.deliveryPartners = deliveryPartners;
    }

    @Override
    public DeliveryPartner assignPartner(Order order) {

        for (DeliveryPartner partner : deliveryPartners) {

            if (partner.isAvailable()) {

                partner.setAvailable(false);

                partner.getAssignedOrders().add(order);

                order.setDeliveryPartner(partner);

                return partner;
            }
        }

        return null; // or throw RuntimeException("No delivery partner available");
    }

    @Override
    public void pickUp(Order order) {
        order.setStatus(OrderStatus.PICKED_UP);
    }

    @Override
    public void deliver(Order order) {
        order.setStatus(OrderStatus.DELIVERED);

    }
}
