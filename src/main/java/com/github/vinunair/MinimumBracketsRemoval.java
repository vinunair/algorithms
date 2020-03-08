package com.github.vinunair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumBracketsRemoval {
    
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int index  = 0 ; index < s.length() ; index++) {
            if(s.charAt(index) == '(')
                stack.push(index);
            if(s.charAt(index) == ')') {
                if(stack.size() == 0 || s.charAt(stack.peek())== ')')
                    stack.push(index);
                else 
                    stack.pop();    
            }     
        }

        Set<Integer> indexes = new HashSet<>();
        while(!stack.isEmpty()) {
            indexes.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(Integer index = 0; index < s.length() ; index++) {
            if(!indexes.contains(index)) {
                sb.append(s.charAt(index));
            }
        }

        return sb.toString();

    }
}