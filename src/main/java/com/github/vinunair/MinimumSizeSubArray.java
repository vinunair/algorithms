package com.github.vinunair;


//[2,3,1,2,4,3]
//[0,2,5,6,8,12]
public class MinimumSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum [] = new int[nums.length+1];
        for(int i= 1; i <= nums.length ; i++) {
            sum [i] = sum[i-1]+ nums[i-1];
        }
        for(int i = 1 ; i <= nums.length ; i++) {
            int findNum = s + sum[i];
        }
        

        return minLength == Integer.MAX_VALUE ? 0 :minLength ;
    }

}