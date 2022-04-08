package com.company.practice.programmers.lecture.CodeRunning;

public class StackLearning {
    static int answer = 0;

    public static void main (String[] args) {
        int n = 2;
        dfs(n, n);
        System.out.println(answer);
    }

    public static void dfs(int open, int close) {
        if (open == 0 && close == 0) {
            answer++;
            return;
        }

        if (open < close) {
            if (open != 0) {
                dfs(open - 1, close);
            }
            if (close != 0) {
                dfs(open, close - 1);
            }
        } else { //open >= close
            dfs(open - 1, close);

        }
    }
}
