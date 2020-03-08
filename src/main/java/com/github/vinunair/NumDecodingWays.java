package com.github.vinunair;

import java.util.Arrays;

public class NumDecodingWays {
    
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0,dp);
    }

    public int numDecodings(String s, int pointer,int[] dp) {       
        if(pointer >= s.length()) {         
            return 1;
        }
        
        if(dp[pointer]!=-1)
            return dp[pointer];

        int ans = 0;
        for(int i= 1 ; i <=2 ; i++ ) {
            if(pointer + i <= s.length()) { 
                String num = s.substring(pointer, pointer + i);
                if(Integer.parseInt(num) == 0 || Integer.parseInt(num) > 26)
                    break;
            
                ans  += numDecodings(s, pointer + i,dp);      
            }     
       }    
        dp[pointer] = ans;
        return dp[pointer];
    }

    public static void main(String args[]) {
        NumDecodingWays decodeWays = new NumDecodingWays();
        System.out.println(decodeWays.numDecodings("2663"));
    }
}