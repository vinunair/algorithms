package com.github.vinunair;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  
    public static void main(String args[]) {
        int nums[] = new int[] {2,3,5};
        
        int target = 8;
        CombinationSum csum = new CombinationSum();
        List<List<Integer>> ans = csum.combinationSum(nums, target);

        for(List<Integer> vals : ans) {
            System.out.println(vals);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currCombination = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        computeSumCombinations(candidates,currCombination, ans, target, 0);
        return ans;
    }

    private void computeSumCombinations (int nums[], List<Integer> currCombination, List<List<Integer>> ans, int target, int start ) {
        if( target == 0) {
            ans.add(new ArrayList(currCombination));
            return;
        }
        if (target < 0)  
            return;
        else {
            for(int i =start ; i < nums.length; i++) {
                currCombination.add(nums[i]);
                computeSumCombinations(nums, currCombination, ans, target - nums[i], i);
                currCombination.remove(currCombination.size() - 1);
                }
            }
        }
    }

