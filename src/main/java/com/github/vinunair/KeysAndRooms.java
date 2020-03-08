package com.github.vinunair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean seen[] = new boolean[rooms.size()];
    Deque<Integer> stack =  new ArrayDeque<>();
    stack.push(0);

    while(!stack.isEmpty()) {
        int room = stack.pop();
        seen[room] = true;
        for(int r : rooms.get(room)) {
            if(!seen[r]) {
            stack.push(r);
            seen[r] = true;
            }
        }
    }

    for(boolean visited : seen) {
        if(!visited) 
            return false;
    }
        
    return true;
    }
}