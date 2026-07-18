package com.security.java_project.twoPointers.nonDuplicate;


import java.util.HashSet;
public class nonDuplicateInstances {

    static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return n;
        int idx=0;

        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                arr[idx++] = arr[i];
            }
        }

        return idx;

    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize = removeDuplicates(arr);

        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

