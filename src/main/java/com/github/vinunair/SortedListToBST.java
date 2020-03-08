package com.github.vinunair;

public class SortedListToBST {
        public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
        }
       /**
        * Definition for a binary tree node.
       **/ 
         public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }

        //    [-10,-3,0,5,9]
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null)
                return null;

            ListNode midNode = findMiddleElement(head);
            TreeNode node = new TreeNode (midNode.val);
            if(midNode == head)
                return node; 
            node.left  = sortedListToBST(head);
            node.right = sortedListToBST(midNode.next);

            return node;
        }

        private ListNode  findMiddleElement(ListNode head) {
            ListNode prevPtr = null;
            ListNode slowPtr = head ;
            ListNode fastPtr = slowPtr;

            while(fastPtr!=null && fastPtr.next!=null) {
                prevPtr = slowPtr;
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
            
            if(prevPtr!=null)
                prevPtr.next = null;
            
            return slowPtr;
        }
}