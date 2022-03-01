package com.company.practice.programmers.lecture;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Greedy {
    public static void main(String[] args) {
        int n = 13;
        int[] stations = {2, 3};
        int w = 5;

        int answer = 0;


        /*
            두번째 효율성은 primitive를 object 타입보다 더 빠르게 동작시킬 수 있다.
            --> station index 사용
            Queue<Integer> sq = new LinkedList<>();
            for(int station : stations) {
                sq.offer(station);
            }
         */


        int stationIndex = 0;
        int location = 1;
        /*시간초과는 루프를 의심하기!!!
        하지만 이 루프는 중간에 뛰기까지 하기때문에 더 줄이기가 어렵다..*/

        while(location <= n) {
            if(stationIndex < stations.length && stations[stationIndex] - w <= location) {
                location = stations[stationIndex] + w + 1;
                stationIndex++;
            } else {
                answer += 1;
                location += (w * 2 + 1);
            }
        }
        System.out.println(answer);

    }

    /**
     * 새삼 내 처음풀이
     * 정확도도 떨어지고 많이 느려터졌구나..ㅠㅠ
     */
    /*public static void main(String[] args) {
        int n = 20;
        int[] stations = {4, 11};
        int w = 2;

        int answer = 0;

        int position = 1;

        int maxW = w * 2 + 1;
        for(int pos : stations) {
            int distance = (pos - w - position);
            answer += distance / maxW;
            if(distance % maxW != 0) {
                answer++;
            }
            position = pos + w + 1;
        }

        if(position < n) {
            int distance = (n - position);
            if(distance > 0) {
                answer += distance / maxW;
                if( distance % maxW != 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }*/
}
