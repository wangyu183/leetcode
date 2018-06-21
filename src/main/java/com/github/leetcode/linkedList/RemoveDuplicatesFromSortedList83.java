package com.github.leetcode.linkedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * Input: 1->1->2 Output: 1->2 Example 2:
 * 
 * Input: 1->1->2->3->3 Output: 1->2->3
 * 
 * @author wangyu
 *
 */
public class RemoveDuplicatesFromSortedList83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
    
    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        return head.val != head.next.val ? head : head.next;
    }
}
