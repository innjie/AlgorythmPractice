package com.company.practice.programmers.lecture;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Binary {
    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        int min = 0;
        int answer = 0;

        /**
         * Stream 사용
         * int right = budgets[budgets.length - 1];
         */
        int max = IntStream.of(budgets).max().orElse(0);

        while(min <= max) {
            final int mid = (min + max) / 2;

            /**
             * calcTotal function -> Stream
             * int sum = calcTotal(budgets, mid);
             */
            int sum = IntStream.of(budgets)
                    .map(b -> Math.min(b, mid))
                    .sum();
            if(sum <= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;

            }
        }
        System.out.println(answer);
    }
    public static int calcTotal (int[] budgets, int position){
        int total = 0;

        for(int budget : budgets) {
            if(budget > position) {
                total += position;
            } else {
                total += budget;
            }
        }
        return total;
    }
}
