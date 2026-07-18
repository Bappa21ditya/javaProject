package com.security.java_project.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cat {

    public static<T> void printArray( T arr[])
    {
       for(T element: arr)
       {
           System.out.println(element);
       }
    }

    public static <T> void printNumber(List<T> list)
    {
        for(T element: list)
        {
            System.out.println(element);
        }
    }

    public static void main(String args[]) {
        List list = new ArrayList();
        list.add("Hello");
        list.add(10); // allowed but unsafe

        ///  here the list will store object type
//        Since you did not specify a generic type (List<String> or List<Integer>),
//        the compiler treats it as a raw type → basically List<Object>.
//        That means list can hold any type of object — String, Integer, Double, etc.
//                So here, list is neither String-type nor Integer-type, it’s a raw List of Objects.

        String s= (String) list.get(0);

        List<String> list1 = new ArrayList<>();
        list.add("Hello");
// list.add(10); ❌ compile-time error
        //String s1 = list1.get(0); // no cast needed ✅


//        Benefits of Generics
//        Type Safety → prevents runtime ClassCastException.
//                Code Reusability → same code works for different data types.
//                Eliminates Casting → cleaner code.
//        Readability → self-documenting (you know the type you’re working with).


        Print<Integer> print=new Print<>();
       print.setPrint(1);
       Integer i= print.getPrint();
        System.out.println("this is generic "+ i);

        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"A", "B", "C"};

        printArray(intArr);
        printArray(strArr);

        List<Integer> l1= Arrays.asList(1,2,3,4,5);
        printNumber(l1);

        Calculator<Integer> cal= new Calculator<>();
        System.out.println(cal.add(1,3));

    }
}
