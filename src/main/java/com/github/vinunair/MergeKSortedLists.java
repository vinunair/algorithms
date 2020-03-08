package com.github.vinunair;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>( (o1,o2) -> o1.val-o2.val);
        for(ListNode node : lists) {
            if(node!=null)
                queue.add(node);
        }
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        while(!queue.isEmpty()) {
            ListNode node =queue.poll();
            if(node.next!=null) queue.add(node.next);
            prev.next = node;
            prev = node;
        }
        return sentinel.next;
    }
}