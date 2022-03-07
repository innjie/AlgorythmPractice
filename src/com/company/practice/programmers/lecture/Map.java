package com.company.practice.programmers.lecture;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Map {
    static int[][] dp;
    static int[][] visited;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};

        dp = new int[maps.length][maps[0].length];
        visited = new int[maps.length][maps[0].length];
        int m = maps.length;
        int n = maps[0].length;
        int i = 0;
        int j = 0;


        System.out.println(dp[maps.length - 1][maps[0].length - 1]);

    }
    /*
    public static void checkMap(int[][] maps, int i, int j) {
        if(maps[i][j] == 0) {
            visited[i][j] = 1;
            return;
        }
        if(i == 0 && j == 0) {
            visited[i][j] = 1;
            dp[i][j] = maps[i][j];
            checkMap(maps, i + 1, j);
            checkMap(maps, i, j + 1);
        }
        if(i == maps.length - 1 && j == maps[0].length - 1) { //end
            visited[i][j] = 1;
            dp[i][j] = checkNum(dp[i][j], 1 + checkNum(dp[i - 1][j], dp[i][j - 1]));
            return;
        }
        if(visited[i][j] == 1) {
            if(i == 0 && j == 0){
                return;
            }
            if(i == maps.length - 1 && j == maps[0].length - 1) {
                dp[i][j] = checkNum(dp[i][j], 1 + checkNum(maps[i - 1][j], maps[i][j - 1]));
            }
            if(i == 0) {
                dp[i][j] = checkNum(dp[i][j], 1 + checkNum(dp[i + 1][j], dp[i][j - 1]));
            } else if (j == 0) {
                dp[i][j] = checkNum(dp[i][j], 1 + checkNum(dp[i][j + 1], dp[i - 1][j]));
            } else if (i == maps.length - 1) {
                dp[i][j] = checkNum(dp[i][j], 1 + checkNum(dp[i - 1][j], dp[i][j + 1]));
            } else if(j == maps[0].length - 1) {
                dp[i][j] = checkNum(dp[i][j], 1 + checkNum(dp[i - 1][j], dp[i][j - 1]));
            } else {
                dp[i][j] = checkNum(dp[i][j], 1 + checkNum(checkNum(dp[i][j - 1], dp[i][j + 1]), checkNum(dp[i + 1][j], dp[i - 1][j])));
            }

            return;
        }
        visited[i][j] = 1;
        if(i == 0) {
            dp[i][j] = checkNum(dp[i + 1][j], dp[i][j - 1]) + 1;
            if(j == maps[0].length - 1) {
                checkMap(maps, i + 1, j);
            } else {
                checkMap(maps, i + 1, j);
                checkMap(maps, i, j + 1);
            }
        } else if(j == 0) {
            dp[i][j] = checkNum(dp[i - 1][j], dp[i][j + 1]) + 1;
            if(i == maps.length - 1) {
                checkMap(maps, i, j + 1);
            } else {
                checkMap(maps, i, j + 1);
                checkMap(maps, i + 1, j);
            }
        } else if (i == maps.length - 1) {
            dp[i][j] = checkNum(dp[i][j + 1], dp[i - 1][j]) + 1;
            checkMap(maps, i - 1, j);
            checkMap(maps, i, j + 1);
        } else if(j == maps[0].length - 1) {
            dp[i][j] = checkNum(dp[i][j - 1], dp[i - 1][j]) + 1;
            checkMap(maps, i + 1, j);
            checkMap(maps, i, j - 1);
        } else {
            dp[i][j] = checkNum(checkNum(dp[i][j - 1], dp[i][j + 1]), checkNum(dp[i + 1][j], dp[i - 1][j])) + 1;
            checkMap(maps, i + 1, j);
            checkMap(maps, i - 1, j);
            checkMap(maps, i, j + 1);
            checkMap(maps, i, j - 1);
        }
    }
    public static int checkNum(int a, int b) {
        if(a == 0) {
            return b;
        } else if(b == 0){
            return a;
        }
        return a < b ? a : b;
    }*/
}
