package com.company.practice.programmers.level1;

import java.util.Locale;

public class RecoomendId {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        String answer = "";
        //step 1
        answer = new_id.toLowerCase(Locale.ROOT);

        //step 2
        /**
         * https://zzang9ha.tistory.com/322
         */
        answer = answer.replaceAll("[^a-z\\d\\-_.]*", "");

        //step3
        int i = 0;
        while(i < answer.length()) {
            char curr = answer.charAt(i);
            if(curr == '.') {
                if(answer.charAt(i + 1) == '.') {
                    answer = answer.substring(0, i) + answer.substring(i + 1, answer.length() - 1);
                }
            }
                i++;

        }
        System.out.println(answer);
        //step4

        //step5

        //step6

        //step7

    }
}
