package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int N = 5; //스테이지 수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; //도전중인 스테이지 번호

        int[] clear = new int[N + 1];

        for(int i = 0; i < stages.length; i++) {
            clear[stages[i] - 1]++;
        }

        List<double[]> stageList = new ArrayList<>();
        int total = stages.length;
        for(int i = 0; i < clear.length - 1; i++) {
            if(clear[i] == 0) {
                stageList.add(new double[] {i, 0});
            } else {
                stageList.add(new double[] {i, clear[i] / (double)total});
            }
            total -= clear[i];
        }

        stageList.sort((a, b) -> Double.compare(b[1], a[1]));

        int[] answer = new int[N];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int)stageList.get(i)[0] + 1;
        }
        for(int n : answer){
            System.out.println(n);
        }

    }
}
