package com.security.java_project.recursion;

import com.sun.source.tree.BreakTree;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sum {
    static int search1(List<Integer> l1, int index, int element) {

        // Base case
        if(index < 0)
            return -1;

        // Element found
        if(l1.get(index) == element)
            return l1.get(index);

        // Recursive call
        return search1(l1, index - 1, element);
    }


    static void sum(int n)
    {
        // base case
        if(n==0)
            return ;
        System.out.println(n);//5,4....0
        sum(n-1);   //sum(4),sum(3)....sum(0)...

    }
    static void sum1(int n)
    {
        // base case
        if(n==0)
            return ;
        sum1(n-1);
      //  System.out.println(n); sum(5)...sum(4),sum(3),sum(2.),sum(0)....1,2,3,4,5;;;


    }
   static void search(List<Integer>l1, int index, int element)
    {
        // Base case
        if(index < 0) {
            System.out.println("Not Present");
            return;
        }
// Check current element
        if(l1.get(index)==element) {
            System.out.println("present");
            return;
        }


            search(l1,index-1,element);
    }

    public static void fun(int n)
    {
        if(n==0)
            return;
        fun(n-1);
       // System.out.println(n);
        fun(n-1);
        System.out.println(n);

    }

    public static void main(String args[])
    {
       // sum(5);
     //   sum1(5);
       // List<Integer> l1= Arrays.asList(1,2,3,4,5);
      //  search(l1,4,5);
      //  int result = search1(l1, l1.size() - 1, 5);
       // System.out.println(result);
        fun(4);

    }
}


//arr[5]={1,2,3,4,5;}
//for(ini =0;i<n;i++)
//        {
//            if(arr[i]==5)
//                return true;
//        }
//
//void search(int arr[], int element, int size)
//{
//    arr.size==0;
//    aar[n-1]==element;
//    search(arr,n-1,size-1);
//
//}


//sum(5)->sum(4)->sum(3)->sum(2)->sum(1)-sum(0);



