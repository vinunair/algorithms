package com.github.vinunair;

public class FindPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int ans[] =  new int[2];
        int leftIndex = binarySearch(nums, target, 0, nums.length-1, true);
        int rightIndex = binarySearch(nums, target, 0, nums.length-1, false);
        ans[0] = leftIndex;
        ans[1] = rightIndex;
        return ans;
    }

    public int binarySearch(int nums[], int target, int low, int high, boolean left ) {
        int index = -1;
        while(low<=high) {
            int mid  = (low+high)/2;
            if(target == nums[mid]) {
                index = mid;
                if(left) 
                    high = mid -1;
                else
                    low = mid + 1;    

            }
            else if(target < nums[mid])
                high = mid -1;
            else 
                low = mid + 1;    
        }
        return index;
    }
}