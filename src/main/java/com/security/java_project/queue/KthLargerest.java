package com.security.java_project.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargerest {

    public static int findKth(int nums[],int k)
    {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    public static int findKthLargest(int[] nums, int k)
    {

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num: nums)
        {
            minHeap.add(num);
            if(minHeap.size()>k)
            {
                minHeap.poll();// remove smallest  O(n log k)
            }
        }
        return minHeap.peek();
    }
    public static void main(String args[])
    {
        int nums[]={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKth(nums,2));
        System.out.println(findKthLargest(nums,2));

    }
}
