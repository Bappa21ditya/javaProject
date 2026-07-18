package com.security.java_project.recursion;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {

    public static void insertStack(Stack<Integer> stack,int temp)
    {
        if(stack.isEmpty()||stack.peek()<temp)
        {
            stack.push(temp);
            return;
        }

        int val=stack.pop();
        insertStack(stack,temp);
        stack.push(val);

    }
    public static void sortStack(Stack<Integer> stack)
    {
        if(stack.isEmpty())
            return;

        int temp=stack.pop();
        sortStack(stack);
        insertStack(stack,temp);
    }



    public static void main(String args[]) {
        Stack<Integer> stack=new Stack<>();
        stack.addAll(Arrays.asList(5,2,7,4,9,0));
        sortStack(stack);
        System.out.println(stack);



    }
}
