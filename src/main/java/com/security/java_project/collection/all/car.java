package com.security.java_project.collection.all;

import java.util.*;

public class car {

    public static void main(String args[])
    {
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(1);
        a1.add(2);

        List<Integer> a2= Arrays.asList(4,1,3,5);
     Iterator<Integer> a2itretor=a2.iterator();
    // while(a2itretor.hasNext())
    // {
       //  System.out.println(a2itretor.next());
    // }
     //for(int i:a2)
    // {
        // System.out.println(i);
     //}
    // a2.forEach(n-> System.out.println(n));

        Collections.sort(a2);
        System.out.println(a2);

        PriorityQueue<Integer> minqueue=new PriorityQueue<>();
        PriorityQueue<Integer> maxqueue=new PriorityQueue<>((a,b)->b-a);
        maxqueue.add(5);
        maxqueue.add(8);
        maxqueue.add(16);
        maxqueue.add(2);

        maxqueue.forEach(n-> System.out.println(n));

        while(!maxqueue.isEmpty())
        {
            int top=maxqueue.poll();
            System.out.println(top);
        }











    }
}
