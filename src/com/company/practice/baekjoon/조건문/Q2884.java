package com.company.practice.baekjoon.조건문;
//https://www.acmicpc.net/problem/2884
import java.util.Scanner;

public class Q2884 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();

        boolean changeHour = false;

        // 받아내림
        if (min < 45) {
            changeHour = true;
            min = 60 + min - 45;
        } else {
            min -= 45;
        }

        //받아내림 한 경우
        if(changeHour == true) {
            hour -= 1;

            if(hour < 0) {
                hour = 24 + hour;
            }
        }

        System.out.println(hour + " " + min);
    }
}
