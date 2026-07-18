package com.security.java_project.algorithms.patterns.twopinters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static int[] twoSum(int[] nums, int target){
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i< nums.length;i++) {
                int t = target - nums[i];
                if (map.containsKey(t)) {
                    return new int[]{map.get(t), i};
                }
                map.put(nums[i], i);
            }
                return new int[]{};

        }

    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}
