package com.github.vinunair;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintArrayCombinations {
    public static void main(String args[]) {
        PrintArrayCombinations prc = new PrintArrayCombinations();
        int arr[] = new int[] {2,3,5};
        List<int[]> ans = new ArrayList<int[]>();
        prc.printArrayCombinations(arr, 0, ans);

        for(int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
    }

    public void printArrayCombinations (int arr[], int start, List<int[]> ans) { 

        if(start >= arr.length){
            ans.add(Arrays.copyOf(arr, arr.length));
        }
        else {
            for(int i = start ; i < arr.length ; i++) {
                swap(arr, i, start);
                printArrayCombinations(arr, start+1,ans);
                swap(arr, i, start);
                
            }
        }

    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}