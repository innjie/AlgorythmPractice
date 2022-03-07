package com.company.practice.programmers.lecture;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Map {
    static int[][] dp;
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

        //bfs : queue
        // current position
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));
        count[0][0] = 1;
        visited[0][0] = 1;
        // 상하좌우 칸을 표현하는데 사용할 배열
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            // 큐에서 노드를 poll
            Position location = queue.poll();
            int row = location.x;
            int col = location.y;

            // 상하좌우 4방향 노드에 대한 작업
            for(int i = 0 ; i < 4; i++){
                int x = row + xArr[i];
                int y = col + yArr[i];

                if(checkLocation(maps, x, y, n, m)){
                    // 큐에 인접 노드 추가
                    queue.add(new Position(x, y));
                    // 추가한 노드까지의 거리 = 현재 노드까지의 거리 + 1
                    visited[x][y] = visited[row][col] + 1;
                }
            }
        }
        System.out.println(visited[n - 1][m - 1]);

    }
    public static boolean checkLocation(int[][] maps, int row, int col, int n, int m){
        // 노드가 범위 밖인 경우
        if(row < 0 || row > n - 1 || col < 0 || col > m - 1) return false;
        // 이미 방문한 노드인 경우
        if(visited[row][col] != 0 || maps[row][col] == 0) return false;
        return true;
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
