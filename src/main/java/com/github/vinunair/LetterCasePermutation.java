package com.github.vinunair;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    int N = 0;
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        N = S.length();
        letterCasePermutation("", S, result);
        return result; 

    }
    
    
    public void letterCasePermutation(String prefix, String suffix, List<String> result) {
        if(prefix.length() == N) {
            result.add(prefix);
            return;
        }
        else {
                for(int i = 0; i< suffix.length();i++) {
                    Character ch = suffix.charAt(i);
                    suffix = suffix.substring(i+1);
                    
                    if(!Character.isDigit(ch)) {
                        letterCasePermutation(prefix+Character.toLowerCase(ch), suffix, result);
                        letterCasePermutation(prefix+Character.toUpperCase(ch), suffix, result);
                    }
                    else {
                        letterCasePermutation(prefix+ch, suffix, result);
                    }
                }
        }
    }
    
    public static void main(String args[]) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        List<String> results = lcp.letterCasePermutation("12345678");
        for(String r : results)
        System.out.println(r);
      
    }
        
}