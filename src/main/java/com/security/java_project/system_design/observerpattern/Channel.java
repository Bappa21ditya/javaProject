package com.security.java_project.system_design.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    List<Observer> observerList=new ArrayList<>();

    public void subscribe(Observer o)
    {
        observerList.add(o);
    }
    public void unsubscribe(Observer o) {
        observerList.remove(o);
    }

    public void notifyObservers(String title)
    {
        for(Observer observer: observerList)
            observer.update(title);
    }

    public void uploadVideo(String title) {
        System.out.println("New video: " + title);
        notifyObservers(title);
    }

}
//        +----------------------+
//        |       Observer       |
//        | (User1, User2, etc.)|
//        +----------+-----------+
//                   ^
//                   |
//        Subscribe / Unsubscribe
//                   |
//                   |
//        +----------+-----------+
//        |       Subject        |
//        |     (Channel)        |
//        +----------+-----------+
//                   |
//                   v
//        +----------------------+
//        |   State Change       |
//        | (New Video Uploaded) |
//        +----------+-----------+
//                   |
//                   v
//        +----------------------+
//        | Notify All Observers |
//        +----------+-----------+
//                   |
//        -------------------------
//        |           |           |
//        v           v           v
//   +--------+  +--------+  +--------+
//   | User1  |  | User2  |  | User3  |
//   +--------+  +--------+  +--------+
//        |           |           |
//        ----------- Update -------
//                    |
//                    v
//          +------------------+
//          | Receive Message  |
//          +------------------+
//🔄 Step-by-Step Flow
//Observers subscribe
//Users register to the subject
//Subject state changes
//Example: New video uploaded
//Subject triggers notification
//Calls notifyObservers()
//All observers receive update
//Each gets the message
//🧠 Easy Memory Trick
//Subscribe → Change → Notify → Update
