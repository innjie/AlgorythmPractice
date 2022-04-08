package com.company.practice.programmers.lecture;

import java.util.Stack;

public class DFS {
    static class P {
        int open, close;
        P(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
    public static void main(String[] args) {
        /**
         * dfs는 stack으로 해결
         */

        int answer = 0;
        int n = 2;
        Stack<P> stack = new Stack<>();
        stack.push(new P(0, 0));

        while(!stack.empty()) {
            P p = stack.pop();

            if(p.close > n) {
                continue;
            }
            if(p.open < p.close) {
                continue;
            }
            // 종료조건
            if(p.open + p.close == n * 2) {
                answer++;
                continue;
            }

            stack.push(new P(p.open + 1, p.close));
            stack.push(new P(p.open, p.close + 1));
        }
        System.out.println(answer);
    }


    /**
     * 내 풀이
     */
    /*static int answer = 0;
    public static void main(String[] args) {
        int n = 2;

        dfs(n, n);
        System.out.println(answer);
    }
    public static void dfs(int open, int close) {
        if(open == 0 && close == 0) {
            answer++;
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

    }*/
}
