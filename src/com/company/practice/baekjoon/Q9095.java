package com.company.practice.baekjoon;
import java.util.Scanner;

public class Q9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numberDP = new int[n + 1];
        numberDP[0] = 1;

        //T(n) = T(n - 1) + T(n - 2) + T(n - 3) (단, n > 3)
        for(int i = 1; i < numberDP.length; i++){
            if(i > 0) {
                numberDP[i] += numberDP[i - 1];
            }
            if(i > 1) {
                numberDP[i] += numberDP[i - 2];
            }
            if(i > 2) {
                numberDP[i] += numberDP[i - 3];
            }
        }

        System.out.println(numberDP[n]);

    }
}