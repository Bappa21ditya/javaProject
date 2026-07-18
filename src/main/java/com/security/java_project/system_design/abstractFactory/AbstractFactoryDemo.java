package com.security.java_project.system_design.abstractFactory;

public class AbstractFactoryDemo {
    public static void main(String args[] )
    {
        VehicleFcatory factory1= FactoryProducer.getVehicleFactory("tata");

        Car car = factory1.createCar();
        Bike bike = factory1.createBike();

        car.drive();
        bike.ride();


        VehicleFcatory factory2= FactoryProducer.getVehicleFactory("mahindra");
        Bike bike1 = factory2.createBike();
        Car car1 = factory2.createCar();

        bike1.ride();
        car1.drive();


    }

}
//🏗️ Abstract Factory Flowchart
//            +----------------------+
//            |     Client Code      |
//            +----------+-----------+
//                       |
//                       v
//            +----------------------+
//            |   FactoryProducer    |
//            | (Factory of Factory) |
//            +----------+-----------+
//                       |
//        ---------------------------------
//        |                               |
//        v                               v
//+-------------------+         +----------------------+
//|   TataFactory     |         |   MahindraFactory    |
//| (Concrete Factory)|         | (Concrete Factory)   |
//+--------+----------+         +----------+-----------+
//         |                               |
//   -------------                   -------------
//   |           |                   |           |
//   v           v                   v           v
//+--------+  +--------+       +--------+   +--------+
//|TataCar |  |TataBike|       |MahCar  |   |MahBike |
//+--------+  +--------+       +--------+   +--------+
//🔄 Step-by-Step Flow
//Client asks FactoryProducer
//"Give me Tata factory"
//FactoryProducer decides
//Returns → TataFactory
//Client uses that factory
//Calls:
//createCar()
//createBike()
//Factory creates related objects
//TataFactory → TataCar + TataBike
//MahindraFactory → MahindraCar + MahindraBike
