package com.company.practice.baekjoon.사칙연산;

import java.util.Scanner;

public class Q1978 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int time = scan.nextInt();

        int count = 0;
        for(int i = 0; i < time; i++) {
            count += isPrime(scan.nextInt());
        }
        System.out.println(count);
    }
    public static int isPrime(int n) {
        if(n == 1) return 0;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}