package com.company.practice.programmers.lecture;

public class Greedy {
    public static void main(String[] args) {
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

    }
}
