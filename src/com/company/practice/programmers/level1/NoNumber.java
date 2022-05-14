package com.company.practice.programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 */
public class NoNumber {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};

        int answer = 0;
        for(int i = 1; i < 10; i++) {
            int var = i;
            if(!IntStream.of(numbers).anyMatch(x -> x == var)) {
                answer += i;
            }

        }
        System.out.println(answer);
    }
}
