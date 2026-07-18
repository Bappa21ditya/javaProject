package com.security.java_project.system_design.strategyPattern;

public class PaymentStrategyDemo {
    public static void main(String  args[]) {
        Strategy paymentStrategy = new UPI();
        PaymentContext context = new PaymentContext(paymentStrategy);
        context.makePayment(10);
    }

}
//        +------------------+
//        |      Client      |
//        +--------+---------+
//                 |
//                 v
//        +----------------------+
//        |  Choose Strategy     |
//        | (UPI / Card / etc.)  |
//        +--------+-------------+
//                 |
//                 v
//        +----------------------+
//        |   PaymentContext     |
//        | (uses strategy)      |
//        +--------+-------------+
//                 |
//                 v
//        +----------------------+
//        |  PaymentStrategy     |
//        |   (Interface)        |
//        +--------+-------------+
//                 |
//        -------------------------
//        |                       |
//        v                       v
//+----------------+     +----------------+
//|      UPI       |     |      Card      |
//| (Concrete)     |     | (Concrete)     |
//+----------------+     +----------------+
//        |                       |
//        -----------+-------------
//                    |
//                    v
//          +------------------+
//          | Execute Payment  |
//          +------------------+
//🔄 Step-by-Step Flow
//Client chooses strategy
//Example: "UPI" or "Card"
//Strategy object is created
//new UPI() or new Card()
//Passed to Context
//PaymentContext(strategy)
//Context calls strategy
//strategy.pay()
//Correct behavior executes
//🧠 Easy Memory Trick
//Select → Inject → Execute