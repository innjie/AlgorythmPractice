package com.company.practice.programmers.lecture;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        String[] numberToString = new String[numbers.length];

        int i = 0;
        for(int n : numbers) {
            numberToString[i] = String.valueOf(n);
            i++;
        }

        Arrays.sort(numberToString);

        String answer = "";
        for(int j = numberToString.length - 1; j >= 0; j--) {
            answer += numberToString[j];
        }
        System.out.println(answer);

    }
}
