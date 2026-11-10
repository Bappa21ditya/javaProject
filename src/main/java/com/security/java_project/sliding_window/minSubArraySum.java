package com.security.java_project.sliding_window;

import java.util.Arrays;

public class minSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;

        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (j < nums.length) {

            // Expand window
            sum += nums[j];

            // Shrink window while condition is satisfied
            while (sum >= target) {

                res = Math.min(res, j - i + 1);

                sum -= nums[i];
                i++;
            }

            j++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = minSubArrayLen(target, nums);

        System.out.println("Target: " + target);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Minimum Subarray Length: " + result);
    }
}
