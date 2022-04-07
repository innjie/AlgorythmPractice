package com.company.practice.programmers.lecture.CodeRunning.ignore;

import java.util.*;

public class CodeReview {
    static int dp[][];
    static int visited[][];
    static class Position {
        int x, y;

        public Position(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};
        int n = maps.length;
        int m = maps[0].length;
        int[][] count = new int[n][m];
        visited = new int[n][m];
        dp = new int[n][m];

        checkMap(maps, 0, 0);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();6
        }
        System.out.println(dp[n - 1][m - 1]);

    }
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
    }
}
