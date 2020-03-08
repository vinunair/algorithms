package com.github.vinunair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupBySize {
 
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
     List<List<Integer>> result = new ArrayList<>();
     Map<Integer,List<Integer>> groupToList = new HashMap<>();   

     for(int i =0 ; i < groupSizes.length ; i++) {
         List<Integer> group = groupToList.getOrDefault(groupSizes[i], new ArrayList<Integer>());
         group.add(i);
         if(group.size() == groupSizes[i]) {
             result.add(group);
             group = new ArrayList<>();
         }
         groupToList.put(groupSizes[i], group);
     }
     return result;
    }
}