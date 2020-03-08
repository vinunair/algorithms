package com.github.vinunair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GardenWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int ans [] = new int[N];
        if(paths == null || paths.length == 0) {
            Arrays.fill(ans,1);
            return ans;
        }
            
        
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for(int path[] : paths) {
            Set garden = adjacencyList.getOrDefault(path[0], new HashSet());
            garden.add(path[1]);
            adjacencyList.put(path[0], garden);
            garden = adjacencyList.getOrDefault(path[1], new HashSet());
            garden.add(path[0]);
            adjacencyList.put(path[1], garden);
        }

       
        
        for(int i = 1; i <=N ;i++) {
            Set<Integer> flowerSet = new LinkedHashSet<>();
            for(int j= 1; j<=4 ;j++)
                flowerSet.add(j);
            if(adjacencyList.get(i)!=null) {
                for(int g : adjacencyList.get(i)) {
                    if(ans[g-1]!=0) 
                        flowerSet.remove(ans[g-1]);
                }
            }
            ans[i-1] = flowerSet.iterator().next();
        }

        return ans;
    }
}
