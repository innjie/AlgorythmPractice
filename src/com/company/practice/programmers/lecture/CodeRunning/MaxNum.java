package com.company.practice.programmers.lecture.CodeRunning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxNum {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};


        String[] stringNum = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            stringNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for(String str : stringNum) {
            System.out.print(str + " ");
        }

        StringBuilder sb = new StringBuilder();
        for(String str : stringNum) {
            sb.append(str);
        }
        if(sb.toString().startsWith("0")) {
            System.out.println("0");
        } else {
            System.out.println(sb.toString());
        }


    }
}
