package com.security.java_project.linkedlist;

import java.util.ArrayList;

//ArrayList<Integer>a1=new ArrayList<>();
    public class linkedList {

        Exception my=new Exception();

        Node head;

        static class Node
        {
            int data;
            Node next;

            Node(int data)
            {
                this.data=data;
                next=null;
            }
        }

     public static linkedList addNode(linkedList list, int data)
     {
         Node newNode=new Node(data);
         if(list.head==null)
         {
             list.head=newNode;
         }
         else {
             Node last = list.head;
             while (last.next != null) {
                 last = last.next;
             }

             last.next = newNode;
         }
         return list;
     }

     public static  void diplay(linkedList list)
     {
         Node currNode=list.head;
         while(currNode!=null)
         {
             System.out.println(currNode.data+" ");
             currNode=currNode.next;
         }
     }
        public static void main(String[] args)
        {

            linkedList list1=new linkedList();
            list1=addNode(list1,1);
            list1=addNode(list1,2);
            list1=addNode(list1,3);

            diplay(list1);
        }

    }
