package com.company.practice.baekjoon.사칙연산;

import java.util.Scanner;

public class Q1011 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int times = scan.nextInt();

        for(int i = 0; i < times; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            counting(start, end);
        }
    }
    public static void counting(int start, int end) {
        int distance = end - start;
        int count = (int)Math.sqrt(distance);

        if(count == Math.sqrt(distance)) {
            System.out.println(count * 2 - 1);
        } else if(distance <= count * count + count) {
            System.out.println(count * 2);
        } else {
            System.out.println(count * 2 + 1);
        }
    }
}