package com.security.java_project.system_design.cabBooking.entity;

import java.util.Objects;

public class Route {

    private Location pickup;

    private Location destination;

    public Route() {
    }

    public Route(Location pickup, Location destination) {
        this.pickup = pickup;
        this.destination = destination;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        return Objects.equals(pickup.getName(), route.pickup.getName())
                && Objects.equals(destination.getName(), route.destination.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                pickup.getName(),
                destination.getName());
    }
}
