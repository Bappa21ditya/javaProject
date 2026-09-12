package com.security.java_project.linkedlist.questions;

public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half
        ListNode second = reverse(middle.next);

        // Step 3: Break the list into two halves
        middle.next = null;

        // Step 4: Merge the two halves alternately
        ListNode first = head;

        while (second != null) {

            // Save next nodes
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // Connect first -> second
            first.next = second;

            // Connect second -> firstNext
            second.next = firstNext;

            // Move forward
            first = firstNext;
            second = secondNext;
        }
    }

    // Find the middle node
    private ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Reverse a linked list
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    // Print linked list
    private void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    // Main method for IntelliJ testing
    public static void main(String[] args) {

        // Create:
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList reorderList = new ReorderList();

        System.out.println("Before:");
        reorderList.printList(head);

        reorderList.reorderList(head);

        System.out.println("After:");
        reorderList.printList(head);
    }
}


// Linked List Node
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

