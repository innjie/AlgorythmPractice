package com.company.practice.programmers.lecture;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DP {
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int answer = 0;
        calc(triangle, 0, 0, answer) ;

        answer = Collections.max(hashSet);
        System.out.println(answer);

        answer = 0;
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    int calcNum = dp[i - 1][j] + triangle[i][j];
                    if(dp[i][j] < calcNum) {
                        dp[i][j] = calcNum;
                    }
                } else if (j == triangle[i].length - 1) {
                    int calcNum = dp[i - 1][j - 1] + triangle[i][j];
                    if(dp[i][j] < calcNum) {
                        dp[i][j] = calcNum;
                    }
                } else {
                    int calcNum1 = dp[i - 1][j] + triangle[i][j];
                    int calcNum2 = dp[i - 1][j - 1] + triangle[i][j];

                    int temp = calcNum1 < calcNum2 ? calcNum2 : calcNum1;

                    if(dp[i][j] < temp ) {
                        dp[i][j] = temp;
                    }
                }


            }
        }
        int max = IntStream.of(dp[triangle.length - 1]).max().orElse(0);
        System.out.println(max);

    }
    public static void calc(int[][] triangle, int i, int j, int answer) {
        answer += triangle[i][j];
        if(i == triangle.length - 1) { // end
            hashSet.add(answer);
            return;
        } else {
            calc(triangle, i + 1, j, answer);
            calc(triangle, i + 1, j + 1, answer);
        }
    }
}
