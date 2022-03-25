package com.company.practice.programmers.lecture.CodeRunning;


import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12982?language=java
 */
public class Budget {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;

        int answer = 0;
        Arrays.sort(d);
        for(int n : d) {
            System.out.print(n + " ");
        }

        for(int i = 0; i < d.length; i++) {
            if(budget < d[i]) {
                break;
            } else {
                budget -= d[i];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
