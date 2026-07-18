package com.security.java_project.system_design.observerpattern;

public class ObserverDemo {
    public static void main(String  args[])
    {
        User user1=new User("AMIT");
        User user2=new User("SUMIT");

        Channel channel=new Channel();
        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Still Alive by Samai Raina");

    }
}
