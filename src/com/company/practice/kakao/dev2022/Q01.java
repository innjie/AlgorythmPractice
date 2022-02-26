package com.company.practice.kakao.dev2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
public class Q01 {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        Map<String, HashSet> map = new HashMap<>();
        Map<String, Integer> mailMap = new HashMap<>();
        for(String name : id_list) {
            mailMap.put(name, 0);
            map.put(name, new HashSet());
        }

        for(String s : report) {
            String[] names = s.split(" ");
            map.get(names[1]).add(names[0]);
        }

        for(String key : map.keySet()) {
            HashSet<String> set = map.get(key);

            if(set.size() >= k) {
                for(String s : set) {
                    mailMap.put(s, mailMap.get(s) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = mailMap.get(id_list[i]);
        }
    }
}
