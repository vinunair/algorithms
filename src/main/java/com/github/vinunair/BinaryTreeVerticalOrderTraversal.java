package com.github.vinunair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      Queue<Integer> cols = new LinkedList<>();         
      List<List<Integer>> nodeList = new ArrayList<>();
      Map<Integer,List<Integer>> colsToNodeList = new TreeMap<>();
      if(root!=null) {
          queue.add(root);
          cols.add(0);
          while(!queue.isEmpty()) {
            int count = queue.size();
            while(count>0) {
                TreeNode node = queue.poll();
                int col = cols.poll();
                List<Integer> nodes  = colsToNodeList.getOrDefault(col, new ArrayList<Integer>());
                nodes.add(node.val);
                colsToNodeList.put(col,nodes);
                if(node.left!=null){
                    cols.add(col-1);
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    cols.add(col+1);
                    queue.add(node.right);
                }
                count--;
            }
          }
          for(List<Integer> nodes : colsToNodeList.values()) {
            nodeList.add(nodes);
          }
      }
      
      return nodeList;
      

    }
}