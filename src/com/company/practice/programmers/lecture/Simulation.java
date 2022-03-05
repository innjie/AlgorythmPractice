package com.company.practice.programmers.lecture;

import java.util.Arrays;

public class Simulation {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        /**
         * 근소한 차이로 이기는 형태 -> B를 먼저 오름차순 정렬
         * --> 뒤집어서 비교한다면? 안된다면 바로 넘기면된다
         */

        Arrays.sort(A);
        Arrays.sort(B);
        int BIndex = B.length - 1;
        int answer = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[BIndex]) {
                answer++;
                BIndex--;

            }

        }
        System.out.println(answer);

    }
}
