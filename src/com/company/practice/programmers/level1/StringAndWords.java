package com.company.practice.programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class StringAndWords {
    public static void main(String[] args) {
        String s = "23four5six7";

        Map<String, Integer> numberMap = new HashMap<>();

        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("zero", 0);
        Iterator<Map.Entry<String, Integer>> iterator = numberMap.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            int value = entry.getValue();
            s = s.replace(entry.getKey(), String.valueOf(entry.getValue()));
        }
        int answer = Integer.parseInt(s);
        System.out.println(answer);
    }



}
