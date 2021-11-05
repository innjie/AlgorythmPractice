package com.company.practice.programmers.level1;

public class Q01 {
    public static void main(String[] args) {
        String s = "1234";

        char ch = s.charAt(0);

        if(ch == '-') {
            int temp = Integer.parseInt(s.substring(1, s.length()));
//            return (0 - temp);
        } else {
            if(ch == '+') {
//                return Integer.parseInt(s.substring(1, s.length()));
            } else {
//                return Integer.parseInt(s);
            }
        }
    }
}
