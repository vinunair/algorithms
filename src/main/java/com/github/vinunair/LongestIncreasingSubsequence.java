package com.github.vinunair;

public class LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
     int [][] memo = new int[nums.length+1][nums.length];
     return lengthOfLIS(nums, -1 , 0, memo);   
    }

    public int lengthOfLIS(int nums[], int prevpos, int currpos, int[][] memo) {
        if(nums.length == currpos)
            return 0;

        if(memo[prevpos+1][currpos] > 0 )
            return memo[prevpos+1][currpos];

        int taken =0;
        
        if( prevpos == -1 || nums[currpos] > nums[prevpos]) {
            taken =  1+lengthOfLIS(nums,currpos,currpos + 1,memo);
        }

        int not_taken = lengthOfLIS(nums, prevpos, currpos+1,memo);
        
        memo[prevpos+1][currpos] = Math.max(taken,not_taken);

       return  memo[prevpos+1][currpos];
    }

    public static void main(String args[]) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}


