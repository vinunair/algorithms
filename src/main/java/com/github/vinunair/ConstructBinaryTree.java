package com.github.vinunair;

import java.util.HashMap;

public class ConstructBinaryTree {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    HashMap<Integer,Integer> inorderIndex  = new HashMap<Integer,Integer>();
    int preorderIndx = -1;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int indx=0;
    
        for(int val : inorder) 
            inorderIndex.put(val, indx++);
        
        return buildTree(preorder, 0 , preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder , int left, int right) {
        if(left == right) {
            TreeNode node = new TreeNode(preorder[preorderIndx]);
            preorderIndx++;
            return node;
        }
        else if(preorderIndx >= preorder.length-1 )
              return null;  
        else {
            TreeNode node = new TreeNode(preorder[++preorderIndx]);
            TreeNode leftNode = buildTree(preorder, left, inorderIndex.get(preorderIndx)-1);
            TreeNode rightNode = buildTree(preorder, inorderIndex.get(preorderIndx)+1, right);
            node.left = leftNode;
            node.right = rightNode;
            return node;
        }

    } 
}