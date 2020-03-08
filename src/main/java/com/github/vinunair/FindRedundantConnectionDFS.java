package com.github.vinunair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Use DFS
public class FindRedundantConnectionDFS {
    Set<Integer> seen = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<int[]> graph = new ArrayList<>();
        int total_edges = edges.length;
        int [] ans = null;
        for(int i= 0 ; i <= total_edges ;i++) {
            graph.add(i, new int[total_edges+1]);
        }

        for(int edge[] : edges) {
            seen.clear();
            if(dfs(graph, edge[0], edge [1])) {
                ans = edge;
                break;
            }
            graph.get(edge[0])[edge[1]] = 1;
            graph.get(edge[1])[edge[0]] = 1;
        }
        return ans;
    }

    public boolean dfs(ArrayList<int[]> graph, int src, int dest) {
        if(!seen.contains(src)) {
            seen.add(src);
        int [] edges = graph.get(src);
        if(edges[dest] == 1)
           return true;
        for(int i = 1 ; i <edges.length; i++) {
            if(edges[i]!=0 && dfs(graph, i, dest))
                return true;
        }
    }
        return false;  
    }
    public static void main(String args[]) {
        FindRedundantConnectionDFS connection = new FindRedundantConnectionDFS();
        int edges[][] = new int[][] { {1,2},{1,3},{2,3}};
        int[] result = connection.findRedundantConnection(edges);
        System.out.println(Arrays.asList(result[0],result[1]));
    }
}