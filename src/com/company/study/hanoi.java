package com.company.study;

public class hanoi {
    public static void main(String[] args) {
        hanoi(1, 2, 3, 3);
    }
    public static void hanoi(int from, int m, int to, int num) {
        if(num == 0)  return;

        hanoi(from, to, m, num - 1);
        System.out.println(num + " : " + from + " -> " + to);
        hanoi(m, from, to, num - 1);
    }
}
