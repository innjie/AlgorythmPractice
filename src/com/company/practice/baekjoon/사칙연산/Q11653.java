package com.company.practice.baekjoon.사칙연산;

import java.util.Scanner;

public class Q11653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int temp = n;

        int i = 2;

        if(n == 1) {

        } else {
            while(true) {
                if(i > temp ) break;
                if(n % i == 0) {
                    System.out.println(i);
                    n /= i;
                } else {
                    i++;
                }
            }
        }

    }
}
