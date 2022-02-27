package com.company.practice.programmers.lecture;

import java.util.Arrays;

public class Greedy {
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        int maxDistance = w * 2 + 1;
        int answer = 0;

        int[] isStructed = new int[n + 1];

        for(int i = 0; i < stations.length; i++) {
            for(int j = stations[i] - w; j < stations[i] + w + 1; j++) {
                if(j <= n) {
                    isStructed[j] = 1;
                }

            }
        }

        int count = 0;
        for(int i = 1; i < isStructed.length; i++) {
            if(isStructed[i] == 0) {
                count++;
            } else if(isStructed[i] != 0 && count > 0){
                answer += count / maxDistance;
                if(count % maxDistance != 0 )  {
                    answer++;
                }
                count = 0;
            }
        }

        if(count > 0) {
            answer += count / maxDistance;
            if(count % maxDistance != 0) {
                answer++;
            }
        }

        System.out.println(answer);

    }
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
