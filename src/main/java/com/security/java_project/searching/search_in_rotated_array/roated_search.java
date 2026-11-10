package com.security.java_project.searching.search_in_rotated_array;

public class roated_search {

        public static int standardBinarySearch(int i, int j, int nums[], int number) {
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] == number) {
                    return mid;
                } else if (nums[mid] < number) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return -1;
        }

        public static int searchInRotated(int nums[], int target) {
            int pos = 0;

            // Find the pivot (rotation point)
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    pos = i;
                    break;
                }
            }

            // Try searching in the left sorted half
            int result = standardBinarySearch(0, pos, nums, target);
            if (result != -1) {
                return result;
            }

            // Otherwise, search in the right sorted half
            return standardBinarySearch(pos + 1, nums.length - 1, nums, target);
        }

    public static void main(String args[])
    {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchInRotated(nums, 2)); // Outputs: 6
        System.out.println(searchInRotated(nums, 4)); // Outputs: 0
        System.out.println(searchInRotated(nums, 3)); // Outputs: -1
    }

}
