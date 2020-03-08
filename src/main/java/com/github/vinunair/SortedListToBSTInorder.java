package com.github.vinunair;

public class SortedListToBSTInorder {
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

        ListNode head ;
        
        // [-10,-3,0,5,9]
        public TreeNode sortedListToBST(ListNode head) {
            int length = nodesLength(head);
            this.head = head;
            return sortedListToBST(0, length-1);
        }

        private TreeNode sortedListToBST(int left, int right) {
            if(left>right)
                return null;
            
            int mid = (left+right)/2;
            TreeNode leftNode = sortedListToBST( left, mid -1 );
            TreeNode node = new TreeNode(head.val);
            node.left = leftNode;
            head = head.next;
            TreeNode rightNode = sortedListToBST(mid+1, right);
            node.right =rightNode;
            
            
            return node;
        }

        private int nodesLength(ListNode node) {
            int count = 0;
            while(node!=null) {
                node = node.next;
                count++;
            }
            return count;
        }
}