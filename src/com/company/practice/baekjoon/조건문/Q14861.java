package com.company.practice.baekjoon.조건문;

//https://www.acmicpc.net/problem/14861
import java.util.Scanner;

public class Q14861 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        //사분면 위치 확인
        if(x > 0 && y > 0) {
            System.out.println(1);
        } else if (x > 0 && y < 0) {
            System.out.println(4);
        } else if (x < 0 && y < 0) {
            System.out.println(3);
        } else {
            System.out.println(2);
        }
    }
}
