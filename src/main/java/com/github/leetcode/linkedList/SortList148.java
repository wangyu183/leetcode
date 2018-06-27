package com.github.leetcode.linkedList;


/**
 * Sort a linked list in O(n log n) time using constant space complexity.

    Example 1:
    
    Input: 4->2->1->3
    Output: 1->2->3->4
    Example 2:
    
    Input: -1->5->3->4->0
    Output: -1->0->3->4->5
    
 * @author wangyu
 *
 */
public class SortList148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                handler.next = left;
                left = left.next;
            }else {
                handler.next = right;
                right = right.next;
            }
            handler = handler.next;
        }
        if(left != null) {
            handler.next = left;
        }
        
        if(right != null) {
            handler.next = right;
        }
        return head.next;
    }
}
