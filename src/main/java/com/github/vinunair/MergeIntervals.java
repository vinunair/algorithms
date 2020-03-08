package com.github.vinunair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> ans = new ArrayList<>();
        if(intervals.length !=0) {
            int[] mergeInterval = intervals[0];
            ans.add(mergeInterval);
            for(int[] interval : intervals) {
                if(mergeInterval[1]>=interval[0]) {
                    mergeInterval[1] = Math.max(mergeInterval[1],interval[1]);
                }else {
                    mergeInterval = interval;
                    ans.add(mergeInterval);
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}