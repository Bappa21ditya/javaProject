package com.security.java_project.sliding_window;

import java.util.HashMap;

public class maximumSubarraySum {


    public static  long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        int i=0,j=0;
        long res=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j<nums.length)
        {

            sum=sum+nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if(j-i+1==k)
            {


                if(map.size()==k)
                {
                    res=Math.max(res,sum);

                }

                sum -=nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }


                i++;
            }
            j++;
        }
        return res;


    }

    public static void main(String[] args) {

        int nums[] = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(nums,3));


    }


}

