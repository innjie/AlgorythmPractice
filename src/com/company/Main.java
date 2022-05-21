package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "abebeaedeac";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Iterator<Map.Entry<Character, Integer>> entries = map.entrySet().iterator();
        int answer = 0;
        while (entries.hasNext()) {
            Map.Entry<Character, Integer> entry = entries.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            if (entry.getValue() % 2 == 1) {
                answer++;

            }
        }


    }
}
