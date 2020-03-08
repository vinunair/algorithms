package com.github.vinunair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        int moves = 0;
        List<int[]> trees = new ArrayList<>();
        int rows = forest.size();
        int cols = forest.get(0).size();
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols; j++) {
                int val  = forest.get(i).get(j);
                if(val > 1) 
                    trees.add(new int[]{val, i, j});
            }
        }

        Collections.sort(trees, (a,b) -> (Integer.compare(a[0],b[0])));
        int sr = 0;
        int sc = 0;

        for(int[] tree : trees) {
            int moveCount = dest(forest, sr,  sc , tree[1] , tree[2]);
            if(moveCount == -1)
                return -1;
            moves += moveCount;
            sr = tree[1];
            sc = tree[2];    
        }
        return moves;
    }

    private int dest(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        if(sr == tr && sc == tc) 
            return 0;
            
        int R = forest.size();
        int C = forest.get(0).size();
        
        int dr [] = {1,-1,0,0};
        int dc [] = {0,0,1,-1};
        int directions = dr.length;
 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        boolean seen[][] = new boolean [R][C];
        seen[sr][sc] = true;
        while(!queue.isEmpty()) {
            int [] pos = queue.poll();
            sr = pos[0];
            sc = pos[1];

            for(int i= 0 ; i < directions ; i++) {
                int row = sr + dr[i];
                int col = sc + dc[i];
                
                if(row < 0 || row == R || col < 0 || col == C || seen[row][col]|| forest.get(row).get(col) ==0 )
                  continue;
                seen[row][col]=true;  
                if(row == tr && col == tc) 
                    return 1;
                if(forest.get(row).get(col) == 1)    
                  queue.add(new int[]{row,col});
            }
        }
        return -1;
    }
    public static void main (String args[]) {
        CutOffTreesForGolfEvent cutOffTreesForGolfEvent = new CutOffTreesForGolfEvent();
        List<List<Integer>> treePathWay = new ArrayList<List<Integer>>();
        treePathWay.add(Arrays.asList(2,3,4));
        treePathWay.add(Arrays.asList(0,0,5));
        treePathWay.add(Arrays.asList(8,7,6));
        System.out.println(cutOffTreesForGolfEvent.cutOffTree(treePathWay));

    }

}