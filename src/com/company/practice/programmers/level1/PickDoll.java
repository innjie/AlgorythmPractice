package com.company.practice.programmers.level1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 *
 * 문제 풀이 후 다른 사람의 풀이도 봤는데 나처럼 stack으로 쓴 경우도 있고 list로 푼 경우도 있었다.
 * Stack을 쓴 경우에는 나처럼 따로 Queue는 구현하지 않았는데 취향차이일지도...
 * 나는 Queue를 구현하는게 인덱스를 어지럽게 생각하지 않아도 될 것 같아서 선택했다.
 * 물론 Queue 구현 연습이라는 목적도 있다.익숙해져야 실전에 써먹으니까..
 */
public class PickDoll {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        //make queue
        Queue[] boardQueue = new Queue[board[0].length];
        for(int i = 0; i < board[0].length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for(int j = 0; j < board.length; j++) {
                if(board[j][i] != 0) {
                    queue.offer(board[j][i]);
                }
            }
            boardQueue[i] = queue;
        }

        //stack -> result
        Stack<Integer> dollStack = new Stack<>();
        int answer = 0;
        for(int move : moves) {
            int doll;
            if(boardQueue[move - 1].isEmpty()) {
                continue;
            } else {
                doll = (int)boardQueue[move - 1].poll();
            }


            if(dollStack.empty()) {
                dollStack.push(doll);
            } else {
                int pre = dollStack.peek();
                if(pre == doll) {
                    dollStack.pop();
                    answer += 2;
                } else {
                    dollStack.push(doll);
                }
            }
        }
        System.out.println(answer);
    }
}
