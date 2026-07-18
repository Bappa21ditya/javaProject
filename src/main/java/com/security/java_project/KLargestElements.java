package com.security.java_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {
    public static List<Integer> findKthelements(int nums[], int k)
    {
        PriorityQueue<Integer> maxHeap=new  PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums)
        {
            maxHeap.add(num);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            res.add(maxHeap.poll());
        }
     return  res;
    }

    public static void main(String args[])
    {
        int nums[]={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthelements(nums,2));

    }

}
