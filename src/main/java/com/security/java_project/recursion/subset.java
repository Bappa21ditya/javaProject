package com.security.java_project.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset {
   static List<List<Integer>> res=new ArrayList<>();
    public static void all_subset(List<Integer>input,List<Integer>output)
    {
         if(input.size()==0)
         {
             res.add(new ArrayList<>(output));
             return;
         }
         List<Integer> op1=new ArrayList<>(output);;
        List<Integer> op2=new ArrayList<>(output);;
        // Include current element
        op2.add(input.get(0));

        List<Integer> remaining =
                new ArrayList<>(input.subList(1, input.size()));

        // Exclude
        all_subset(remaining, op1);

        // Include
        all_subset(remaining, op2);
    }

    public static void main(String args[])
    {
        List<Integer> l1= Arrays.asList(1,2,5);
        all_subset(l1, new ArrayList<>());

        System.out.println(res);
    }
}
