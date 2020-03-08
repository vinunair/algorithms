package com.github.vinunair;

public class LongestCommonPrefix {
    
    public static void main(String args[]) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        //String [] strs = new String[] {"flower","flow","flight"};
        String [] strs = new String[] {"dog","racecar","car"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int left, int right) {
        if(left == right) 
           return strs[left];
        else {
             int mid = (left + right)/2;
             String leftStr = longestCommonPrefix(strs, left, mid);
             String rightStr = longestCommonPrefix(strs, mid+1,right);
             return commonPrefix(leftStr, rightStr);
         }  
    }

    private String commonPrefix(String first, String second) {
        String prefix = "";
        if(first.isEmpty() || second.isEmpty()) 
        return prefix;

        for(int i = 0; i < first.length() ; i++) {
            if(i < second.length() && first.charAt(i) == second.charAt(i)) 
                prefix+=first.charAt(i);
            else 
                break;
        }

        return prefix;
    }
}