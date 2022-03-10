package com.company.practice.programmers.level1;

import java.util.Locale;

public class RecoomendId {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";

        String answer = "";
        //step 1
        answer = new_id.toLowerCase(Locale.ROOT);
        System.out.println(answer);

        //step 2
        /**
         * https://zzang9ha.tistory.com/322
         */
        answer = answer.replaceAll("[^a-z\\d\\-_.]*", "");

        //step3
        int i = 0;
        if (answer.length() >= 2) {
            while (i < answer.length() - 1) {
                char curr = answer.charAt(i);
                if (curr == '.') {
                    if (answer.charAt(i + 1) == '.') {
                        answer = answer.substring(0, i) + answer.substring(i + 1, answer.length());
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
        }
        System.out.println(answer);

        //step4
        if(answer.startsWith(".")) {
            if(answer.length() == 1) {
                answer = "";
            } else if(answer.length() == 2) {
                answer = (String.valueOf(answer.charAt(1))) ;
            } else {
                answer = answer.substring(1, answer.length());
            }
        }
        if(answer.endsWith(".")) {
            if(answer.length() == 1) {
                answer = "";
            } else if(answer.length() == 2) {
                answer = (String.valueOf(answer.charAt(0)));
            } else {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        System.out.println(answer);

        //step5
        if (answer.length() == 0) {
            answer = "a";
        }
        System.out.println(answer);

        //step6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if(answer.endsWith(".")) {
            if(answer.length() == 1) {
                answer = "";
            } else if(answer.length() == 2) {
                answer = (String.valueOf(answer.charAt(0)));
            } else {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        System.out.println(answer);

        //step7
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        System.out.println(answer);
    }
}
