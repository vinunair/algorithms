package com.github.vinunair;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] arr = new int [26];
        for(int i = 0; i < S.length() ; i++) {
            arr[S.charAt(i)-'a'] = i;
        }

        int j = 0;
        int count = 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < S.length() ; i++) {
            j = Math.max(j, arr[S.charAt(i)]);
            if(i == j) {
                ans.add(count);
                count = 0;
            }

            count++;
        }
        return ans;
    }
}