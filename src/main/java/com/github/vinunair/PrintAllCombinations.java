package com.github.vinunair;

import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class PrintAllCombinations
{
    public static void main( String[] args )
    {
        PrintAllCombinations pac = new PrintAllCombinations();
        List<String> ans = pac.printAllCombinations("abcd");
        for(String str : ans) {
            System.out.println(str);
        }
    }

    public List<String> printAllCombinations(String input) {
        List<String> ans = new ArrayList<String>();
        printAllCombinations("",input, ans);
        return ans;
    }

    private void printAllCombinations(String prefix, String suffix, List<String> ans) {
        if(suffix.length() == 0) {
            ans.add(prefix);
        }
        else {
            for(int i= 0; i < suffix.length(); i++) {
                printAllCombinations(prefix+suffix.charAt(i), suffix.substring(0, i)+ suffix.substring(i+1, suffix.length()), ans);
            }
        }
    }

}
