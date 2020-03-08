package com.github.vinunair;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeParanthesesValid {
    public int minAddToMakeValid(String S) {
        Deque<Character> stack  = new ArrayDeque<>();
        int minAdd = 0;
        for(int i=0; i < S.length();i++) {
            if(S.charAt(i) == '(')
                stack.push(S.charAt(i)); 
            else {
                if(stack.isEmpty()) {
                    minAdd++;
                }else {
                    stack.pollLast();
                }
            }
        }
        return minAdd+stack.size();
    } 
}