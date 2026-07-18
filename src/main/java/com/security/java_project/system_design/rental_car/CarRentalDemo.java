package com.security.java_project.system_design.rental_car;

public class CarRentalDemo {

    public static void main(String[] args) {
        CarRentalSystem  carRentalSystem=new CarRentalSystem();

        carRentalSystem.addCar(new Car("C1", CarType.SEDAN));
        carRentalSystem.addCar(new Car("C2", CarType.SUV));

        User user = new User("U1", "Bappaditya");

        Reservation reservation = carRentalSystem.bookCar(user, CarType.SUV);

        carRentalSystem.returnCar(reservation);



    }
}
