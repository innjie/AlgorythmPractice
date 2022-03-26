package com.company.practice.programmers.lecture.CodeRunning;

import java.util.Arrays;

public class NumberGame {
    public static void main(String args[]) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int BIndex = 0;
        int AIndex = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[AIndex] < B[BIndex]) {
                AIndex++;
                answer++;
            }
            BIndex++;

        }
        System.out.println(answer);

    }
}
