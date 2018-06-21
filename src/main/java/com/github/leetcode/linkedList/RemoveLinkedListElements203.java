package com.github.leetcode.linkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 * 
 * @author wangyu
 *
 */
public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
    
    public ListNode removeElements3(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode current = head;
        ListNode prev = fakeHead;
        while(current != null) {
            if(current.val == val) {
                //prev.next = prev.next.next;
                prev.next = current.next;
            }else {
                prev = prev.next;
            }
            current = current.next;
        }
        return fakeHead.next;
    }
    
    public static ListNode removeElements2(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        
        while(current != null && current.next != null) {
            if(current.next.val == val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode result = removeElements2(l1, 6);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
