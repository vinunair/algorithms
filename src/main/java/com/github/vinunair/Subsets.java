package com.github.vinunair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums, int start, List<List<Integer>> ans) {
        if (start > nums.length)
            return ans;

       // ans.add(Arrays.asList(Arrays.copyOfRange(nums, start, nums.length)));

        for(int i = start; i <nums.length ; i++) {

        }
        return null;
    }

    public static void main(String args[]) {
        Set<int[]> subset = new HashSet<int[]>();
        int [] arr = new int[] {1,2,4};
        System.out.println(subset.add(arr));
        System.out.println(subset.add(arr));

        System.out.println(subset.size());
    }
}