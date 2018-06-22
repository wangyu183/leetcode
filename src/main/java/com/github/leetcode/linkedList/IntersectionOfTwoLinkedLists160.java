package com.github.leetcode.linkedList;

import java.util.HashSet;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 *       A: a1 → a2 
 *                  ↘ 
 *                    c1 → c2 → c3 
 *                  ↗ 
 *  B: b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * @author wangyu
 *
 */
public class IntersectionOfTwoLinkedLists160 {
    
    /**
     * HashSet
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(headA != null || headB != null) {
            if(headA != null) {
                if(set.contains(headA)) {
                    return headA;
                }else {
                    set.add(headA);
                }
                headA = headA.next;
            }
            
            if(headB != null) {
                if(set.contains(headB)) {
                    return headB;
                }else {
                    set.add(headB);
                }
                headB = headB.next;
            }
        }
        return null;
    }
    
    /**
     * two point 双指针 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        while(headA != null || headB != null) {
            if(headA == null) {
                currentB = currentB.next;
            }else {
                headA = headA.next;
            }
            if(headB == null) {
                currentA = currentA.next;
            }else {
                headB = headB.next;
            }
        }
        while(currentA != null && currentB != null) {
            if(currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }
    
    /**
     * two point 双指针 
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        while(currentA != currentB) {
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        
        l5.next = l6;
        l6.next = l7;
        
        ListNode result = getIntersectionNode3(l1, l5);
        System.out.println(result);
    }
    
    
}
