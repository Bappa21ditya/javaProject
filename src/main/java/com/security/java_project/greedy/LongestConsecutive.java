package com.security.java_project.greedy;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums)
     {
        Set<Integer> set = new HashSet<>();
        // Put all numbers into the Set
         for(int num : nums)
         {
             set.add(num);
         } int maxLength = 0;
         // Find the beginning of each sequence
         for(int num : set){
             // num is the beginning if num - 1 doesn't exist
             if (!set.contains(num - 1))
             {
                 int current = num;
                 int count = 1;
                 // Count consecutive numbers
                 while (set.contains(current + 1))
                 {
                     current++;
                     count++;
                 }
                 maxLength = Math.max(maxLength, count);
             }
         } return maxLength;
     }
     public static void main(String[] args)
     {
         int[] nums = {100, 4, 200, 1, 3, 2};
         int result = longestConsecutive(nums);
         System.out.println("Longest consecutive sequence length: " + result);
     }
}

