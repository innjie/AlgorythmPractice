package com.company.practice.programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {2, 2, 2, 2, 2, 2};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int unknownCount = 0;
        int equalCount = 0;
        for(int number : lottos) {
            if(Arrays.stream(win_nums).anyMatch(n -> n == number)) {
                equalCount++;

            }
            if(number == 0) {
                unknownCount++;
            }
        }
        int max = 7 - (equalCount + unknownCount);
        int min = 7 - equalCount;
        if(min >= 6) min = 6;
        if(max >= 6) max = 6;


        int[] answer = {max, min};
        System.out.println(max);
        System.out.println(min);
    }
}
