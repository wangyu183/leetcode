package com.github.leetcode.linkedList;



/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Input: 1->2->4, 1->3->4
   Output: 1->1->2->3->4->4
 * @author wangyu
 *
 */
public class MergeTwoSortedLists21 {
    
    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    
    /**
     * 构建一个新的链表，1-》3-》5、2->4->6  
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        
        /**
         * 为何同时有result 和 lastNode
         * result 指向链表头节点，位置不变
         * lastNode 不断指向当前链表的最后一个，用于构造链表
         */
        ListNode result = new ListNode(0);
        ListNode lastNode = result;
       while(l1 != null && l2 != null) {
           if(l1.val <= l2.val) {
               lastNode.next = l1;
               l1 = l1.next;
           }else {
               lastNode.next = l2;
               l2 = l2.next;
           }
           lastNode = lastNode.next;
       }
       
       if(l1 != null) {
           lastNode.next = l1;
       }
       
       if(l2 != null) {
           lastNode.next = l2;
       }
       
       return result.next;
    }
    
    
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l7 = new ListNode(7);
        
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;
        
        l2.next = l4;
        
        ListNode newListNode = mergeTwoLists(l1, l2); 
        while(newListNode != null) {
            System.out.print(newListNode.val);
            newListNode = newListNode.next;
        }
        System.out.println();
        while(l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();
        while(l2 != null) {
            System.out.print(l2.val);
            l2 = l2.next;
        }
        System.out.println();
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

