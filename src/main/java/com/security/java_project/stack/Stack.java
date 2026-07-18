package com.security.java_project.stack;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size)
    {
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;

    }

    public void push(int value)
    {
        if(top==maxSize-1)
        {
            System.out.println("STACK OVERFLOW");
            return;
        }
        stackArray[++top]=value;
        System.out.println("Value pushed in stack");

    }
    public int pop()
    {
        if(top==-1)
        {
            System.out.println("underflow");
            return -1;
        }
        int poppedElement= stackArray[top--];
        System.out.println("popped from stack");
        return poppedElement;


    }
    public int top()
    {
        if(top==-1)
        {
            System.out.println("under flow");
            return -1;
        }
        return stackArray[top];
    }
    public boolean isEmpty()
    {
        return  (top==-1);

    }

    public static void main(String[] args)
    {
        Stack stack =new Stack(5);
        stack.push(4);
        stack.push(6);
        int res=stack.top();
        System.out.println(res);
        stack.isEmpty();
        stack.pop();
       // stack.pop();
        System.out.println("is empty? "+stack.isEmpty());

    }
}
