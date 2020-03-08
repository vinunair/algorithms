package com.github.vinunair;

public class SubTreeOfTree {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s!=null && (isEqual(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public boolean isEqual(TreeNode s, TreeNode t) {
        if(s==null && t==null)
            return true;
        if( (s!=null && t==null) || (s==null && t!=null)) 
            return false;
        return s.val == t.val &&
                isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }

   
}