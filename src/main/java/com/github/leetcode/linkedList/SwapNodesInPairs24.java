package com.github.leetcode.linkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

    Example:
    
    Given 1->2->3->4, you should return the list as 2->1->4->3.
    Note:
    
    Your algorithm should use only constant extra space.
    You may not modify the values in the list's nodes, only nodes itself may be changed.
 * @author wangyu
 *
 */
public class SwapNodesInPairs24 {
    
    /**
     * AC iteration
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next =  swapPairs(head.next.next);
        n.next = head;
        return n;
    }
    
public ListNode swapPairsWithWhile(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode current = fakeHead;
        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return fakeHead.next;
    }
}
