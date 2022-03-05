package com.company.practice.programmers.lecture;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hash {
    public static void main(String[] args){
        String[][] clothes = {{"crowmask", "face"},{"bluesunglasses", "face"},{"smoky_makeup", "face"}};

        HashMap<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes) {
            String val = cloth[1];

            if(map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        int answer = 0;
        int count = 1;

        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();

        /**
         * 아무것도 안입는 경우는 없다
         * -> 종류 + 1 을 모두 곱한 후 아무것도 안입는 경우 (1)을 빼주기
         */
        while(entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            count *= (entry.getValue() + 1);
        }

        answer = count - 1;

        System.out.println(answer);
    }
}
