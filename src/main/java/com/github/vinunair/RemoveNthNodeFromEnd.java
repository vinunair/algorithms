package com.github.vinunair;

public class RemoveNthNodeFromEnd {
    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
        
         public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fastPtr = head, slowPtr = head , prevNode = head; 
            int count = 1;
            while(count++ < n) 
                fastPtr = fastPtr.next;
            while(fastPtr!=null && fastPtr.next!=null) {
                fastPtr = fastPtr.next;
                prevNode = slowPtr;
                slowPtr = slowPtr.next;
            }
            if(slowPtr == prevNode) {
                head = slowPtr.next;
            } else {
                prevNode.next = slowPtr.next;
            }
            return head;
        }     
}