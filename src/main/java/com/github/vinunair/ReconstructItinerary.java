package com.github.vinunair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
    
    public List<String> findItinerary(List<List<String>> tickets) {
     Map<String, Queue<String>> mapSrcDest = new HashMap();   
     for(List<String> ticket : tickets ) {
        String departure = ticket.get(0);
        String arrival = ticket.get(1);
        Queue arrivals = mapSrcDest.getOrDefault(departure, new PriorityQueue<>((o1,o2) -> o1.compareTo(o2)));
        arrivals.add(arrival);
        mapSrcDest.put(departure,arrivals);
    }

    List<String> itineraryList = new ArrayList<>();
    itineraryList.add("JFK");
    dfs("JFK", mapSrcDest, itineraryList, tickets.size()+1);
    return itineraryList;
    }

    private void dfs(String dest, Map<String, Queue<String>> mapSrcDest, List<String> itineraryList,int height) {
        if(itineraryList.size() == height) {
            return;
        }
        if(!mapSrcDest.containsKey(dest) && itineraryList.size() < height) {
            itineraryList.remove(itineraryList.size()-1);
            return;
        }
        Queue<String> queue = mapSrcDest.get(dest);
        List<String> tempList = new ArrayList<>();
            while(!queue.isEmpty() && itineraryList.size() < height) {
                String d = queue.poll();
                while(!mapSrcDest.containsKey(d) && !queue.isEmpty() ) {
                    tempList.add(d);
                    d = queue.poll();
                }
                if(!tempList.isEmpty()) {
                    mapSrcDest.get(dest).addAll(tempList);
                    tempList.clear();
                }
                itineraryList.add(d);
                dfs(d, mapSrcDest, itineraryList,height);
            }
        
    }

    public static void main(String args[]) {
        ReconstructItinerary itinerary = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
       
        tickets.add(Arrays.asList("JFK","KUL"));
        tickets.add(Arrays.asList("JFK","NRT"));
        tickets.add(Arrays.asList("NRT","JFK"));
       
        
        System.out.println(itinerary.findItinerary(tickets));
    }
}