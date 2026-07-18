package com.security.java_project.recursion;

import java.util.Arrays;
import java.util.Stack;

public class deleteMiddle {
    public static void insert_stack(Stack<Integer> st,int val)
    {
        if(st.isEmpty())
        {
            st.push(val);
            return;
        }
        int temp=st.pop();
        insert_stack(st,val);
        st.push(temp);
    }


    public static void reverse_stack(Stack<Integer> st)
    {
        if(st.isEmpty())
            return ;

        int val=st.pop();
        reverse_stack(st);
        insert_stack(st,val);
    }

    public static int delete_middle(Stack<Integer> st,int n)
    {
        if(st.isEmpty())
            return -1;
        else if(n==0)
        {
            int val=st.pop();
            return val;
        }
        int temp=st.pop();
        // store the result came from recursion
        int result =delete_middle(st,n-1);
        st.push(temp);
        return result;
    }

    public static void main(String args[]) {

        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(0, 2, 4, 5, 7, 9,11,13));
        int n= stack.size()/2;
       //int result= delete_middle(stack,n);
      //  System.out.println(result);
        //System.out.println(stack);

        reverse_stack(stack);
        System.out.println(stack);

    }
}