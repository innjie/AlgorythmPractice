package com.company.study;

public class InsertionSort {
    public static void main(String[] args) {
        int A[] = {10, 14, 29, 37, 13};

        for(int i = 1; i < A.length; i++) {
            int j;
            int cur = A[i];
            for(j = 0; j < i; j++) {
                if(A[j] > cur) break;
            }

            for(int k = i; k > j; k--) {
                A[k] = A[k - 1];
            }

            A[j] = cur;
        }
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
