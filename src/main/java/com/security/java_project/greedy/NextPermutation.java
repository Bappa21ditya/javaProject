package com.security.java_project.greedy;

import java.util.Arrays;

public class NextPermutation {


    public static void nextPermutation(int[] nums)
    {
        int size = nums.length;
        // Step 1: Find the first decreasing point from the right

        int i = size - 2;
          while (i >= 0 && nums[i] >= nums[i + 1])
          {
              i--;
          }

          // If i == -1, the entire array is descending.
        // Reverse the whole array.

        if (i == -1)
        {
            reverse(nums, 0, size - 1);
            return;
        }
        // Step 2: Find the smallest number greater than nums[i]

        int j = size - 1;

        while (nums[j] <= nums[i])
        {
            j--;
        }
        // Step 3:
        // Swap nums[i] and nums[j]

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        // Step 4: Reverse everything after i
        reverse(nums, i + 1, size - 1);

        }
      private static void reverse(int[] nums, int left, int right)
      {
          while (left < right)
       {
          int temp = nums[left];
          nums[left] = nums[right];
          nums[right] = temp;
          left++; right--;
        }
      }

        public static void main(String[] args)
        {
            int[] nums = {1, 5, 4, 3, 2};
            System.out.println("Before: " + Arrays.toString(nums));
            nextPermutation(nums);
            System.out.println("After: " + Arrays.toString(nums));
        }

}
