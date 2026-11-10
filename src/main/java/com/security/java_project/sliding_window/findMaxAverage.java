package com.security.java_project.sliding_window;

public class findMaxAverage {

    public static double findMaxAverageSUBarray(int[] nums, int k)
    {

        int sum=0;
        int i=0;
        int j=0;
        double avg= -Double.MAX_VALUE;
        while(j< nums.length)
        {
            sum=sum+nums[j];
            if(j-i<k)
            {
                j++;
            }
            else if(j-i==k) {
                avg = Math.max(avg,(double) sum / k);
                sum -= nums[i];
                i++;
                j++;

            }

        }

        return  avg;

    }

    public static void main(String[] args) {

        int nums[] = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverageSUBarray(nums,4));


    }
}
