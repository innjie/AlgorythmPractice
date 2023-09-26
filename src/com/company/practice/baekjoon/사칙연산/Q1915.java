package com.company.practice.baekjoon.사칙연산;

import java.util.Scanner;
import java.util.stream.Stream;

public class Q1915 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = scanner.next();
            for(int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int maxNum = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = map[i][j] - '0';
                if(dp[i][j] == 1 && maxNum == 0) maxNum =1;
                if (j > 0 && i > 0) {
                    if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        maxNum = Math.max(dp[i][j], maxNum);
                    }
                }
            }
        }
        System.out.println(maxNum* maxNum);

    }
}
