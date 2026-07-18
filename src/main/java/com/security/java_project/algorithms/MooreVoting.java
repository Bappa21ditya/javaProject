package com.security.java_project.algorithms;

public class MooreVoting {

    public  static  int moorevotingalgo(int arr[])
    {
        // find the candidate
        int count=0;
        int candidate=-1;
        for(int i=0;i<arr.length;i++) {
            if (count == 0) {
                candidate =arr[i] ;
                count = 1;
            } else {
                if (arr[i] == candidate) {
                    count++;
                }
                else
                    count--;
            }
        }

      // check number of times it is present in array
       for(int i=0;i< arr.length;i++)
       {
           if(arr[i]==candidate)
               count++;
       }

       if(count> arr.length/2)
           return candidate;
       else
        return -1;

    }
    public static void main(String[] args)
    {
        int a[]={1,1,2,3,1,1,1,2,3,5,1};
       int res= moorevotingalgo(a);
        System.out.println(res);


    }
}
