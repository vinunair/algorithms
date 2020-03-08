package com.github.vinunair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HighFive {
    public int[][] highFive(  int[][] items) {
          Map<Integer, List<Integer>> studentToMarks = new TreeMap<>();
        for ( int[] item : items) {
            List<Integer> marks = studentToMarks.getOrDefault(item[0], new ArrayList<Integer>());
            marks.add(item[1]);
            studentToMarks.put(Integer.valueOf(item[0]), marks);
        }

         int[][] topFive = new int[studentToMarks.size()][2];
         Iterator<Integer> studentMarksIterator = studentToMarks.keySet().iterator();
        int index = 0;
        while(studentMarksIterator.hasNext()) {
            int key = studentMarksIterator.next();
            List<Integer> marks = studentToMarks.get(key);
            IntSummaryStatistics stats = marks.stream().sorted(Collections.reverseOrder()).limit(5).mapToInt(Integer::intValue).summaryStatistics();
            int average = (int)stats.getAverage();
            topFive[index][0] = key;
            topFive[index][1] = average;
            index++;
        }

        return topFive;
    }
}