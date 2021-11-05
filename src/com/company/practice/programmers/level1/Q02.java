package com.company.practice.programmers.level1;

public class Q02 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        long total = 0;

        for(int i = 0; i < count; i++) {
            total += (price * (i + 1));
        }

        long result = (long)(total - money);
        if(result < 0) {
            System.out.println(0);
        } else {
            System.out.println((long)(total - money));
        }

    }
}
