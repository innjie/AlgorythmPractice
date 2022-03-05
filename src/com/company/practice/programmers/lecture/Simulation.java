package com.company.practice.programmers.lecture;

import java.util.Arrays;

public class Simulation {
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        /**
         * 근소한 차이로 이기는 형태 -> B를 먼저 오름차순 정렬
         */
        Arrays.sort(B);

        int answer = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] < B[i]) {
                answer++;
            } else if(i != A.length - 1){
                //다음 요소로는 이길수 있는지 확인
                /*if(A[i] < B[i + 1]) {
                    answer++;
                    int temp = B[i + 1];
                    B[i + 1] = B[i];
                    B[i] = temp;
                }*/
                for(int j = i; j < B.length; j++) {
                    if(A[i] < B[i + 1]) {
                        int temp = B[i + 1];
                        B[i + 1] = B[i];
                        B[i] = temp;

                    }
                }
            }
        }
        System.out.println(answer);

    }
}
