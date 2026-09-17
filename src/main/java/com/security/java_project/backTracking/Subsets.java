package com.security.java_project.backTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> solution(int[] nums) {

        List<Integer> op = new ArrayList<>();

        solve(nums, op, 0);

        return result;
    }

    void solve(int[] nums, List<Integer> op, int i) {

        // BASE CASE
        if (i == nums.length) {

            result.add(new ArrayList<>(op));

            return;
        }

        // DON'T TAKE nums[i]
        solve(nums, op, i + 1);

        // TAKE nums[i]
        op.add(nums[i]);

        solve(nums, op, i + 1);

        // UNDO
        op.remove(op.size() - 1);
    }

    public static void main(String[] args) {

        Subsets subsets= new Subsets();

        int[] nums = {1, 2, 3};

        List<List<Integer>> answer = subsets.solution(nums);

        System.out.println("All subsets:");

        for (List<Integer> subset : answer) {
            System.out.println(subset);
        }
    }
}
