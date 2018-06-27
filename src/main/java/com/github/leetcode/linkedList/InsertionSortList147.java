package com.github.leetcode.linkedList;

public class InsertionSortList147 {
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode current = head;
        ListNode prev = helper;
        while(current != null){
            ListNode next = current.next;
            while(prev.next != null && prev.next.val <= current.val) {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            prev = helper;
            current = next;
        }
        return prev.next;
    }
    
    public static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        
        ListNode result = insertionSortList(l1);
        print(result);
    }
}
