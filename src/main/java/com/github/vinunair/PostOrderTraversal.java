package com.github.vinunair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();  
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        //stack.po
        if(root!=null) {
            stack.push(root);
            while(!stack.isEmpty()) {
                while(root!=null) {
                    root = root.right;
                    if(root!=null) 
                        stack.push(root);
                    else {
                        root = stack.peek() ;
                       if(root!=null && root.left!=null){
                            root = root.left;
                            stack.push(root);
                       }
                    }    
                }
                root = stack.pop();
                list.add(root.val);
            }
        }
        return list;
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}