package com.github.leetcode.linkedList;

/**
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 * 
 * @author wangyu
 *
 */
public class ReverseLinkedList206 {

    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode oldNext = head.next;
            head.next = result;
            result = head;
            head = oldNext;
        }
        return result;
    }

    /**
     * 递归法
     * 
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = reverseList2(l1);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }

}
