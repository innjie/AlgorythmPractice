package com.company.practice.programmers.lecture;

public class DFS {
    static int[] valCount;
    static int count = 0;
    public static void main(String[] args) {
        int n = 2;

        valCount = new int[]{n, n};
        dfs(n, n);
        System.out.println(count);
    }
    public static void dfs(int open, int close) {
        if(open == 0 && close == 0) {
            count++;
            return;
        }

        if(open < close) {
            if(open != 0) {
                dfs(open - 1, close);
            }
            if(close != 0) {
                dfs(open, close - 1);
            }
        } else { //open >= close
            dfs(open - 1, close);

        }

    }
}
