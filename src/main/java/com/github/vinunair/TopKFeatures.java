package com.github.vinunair;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;


public class TopKFeatures {

    public ArrayList<String> popularNFeatures(int numFeatures, 
	                                         int topFeatures, 
                                             List<String> possibleFeatures, 
											 int numFeatureRequests, 
											 List<String> featureRequests)
    {
        
        Map<String,Integer> featureCount = new HashMap<>();
        PriorityQueue<Map.Entry<String,Integer>> topFeatureQueue = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
        });
        
        for(String feature:possibleFeatures) {
            for(String request : featureRequests) {
                if(request.toLowerCase().contains(feature.toLowerCase())) {
                    Integer count = featureCount.getOrDefault(feature, 0);
                    featureCount.put(feature.toLowerCase(),count+1);
                }
            }
        }

        for(Map.Entry<String, Integer> mapEntry : featureCount.entrySet()){
            topFeatureQueue.offer(mapEntry);
            if(topFeatureQueue.size() > topFeatures)
                topFeatureQueue.poll();
        }

        ArrayList<String> result = new ArrayList<String>();
            while(!topFeatureQueue.isEmpty()) {
            result.add(topFeatureQueue.poll().getKey());
            }

        return result; 
        
    }
}