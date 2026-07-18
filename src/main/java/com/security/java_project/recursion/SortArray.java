package com.security.java_project.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public static void insert1(List<Integer> list,int temp)
    {
        // is array empty or temp is greater then last element
        if(list.size()==0 ||list.get(list.size()-1)<temp) {
            list.add(temp);
            return;
        }

        // pass smaller input,
        int val=list.get(list.size()-1);
        list.remove(list.size()-1);
        insert1(list,temp);
        // add remaining element in array
        list.add(val);

    }
    public static void sorting(List<Integer> list )
    {
        // base condition
        if(list.size()==0)
            return;
        // pass smaller input
        int temp=list.get(list.size()-1);
       list.remove( list.size()-1);
        sorting(list);
        // last step add the element
        insert1(list,temp);
    }


    public static void main(String args[])
    {

        //List<Integer> list= Arrays.asList(4,3,7,1,2,9);

        List<Integer> list =
                new ArrayList<>(Arrays.asList(4,3,7,1,2,9,0));
        sorting(list);
        System.out.println(list);
    }
}
