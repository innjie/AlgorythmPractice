package com.company.practice.programmers.lecture;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        String[] numberToString = new String[numbers.length];

        int i = 0;
        for(int n : numbers) {
            numberToString[i] = String.valueOf(n);
            i++;
        }
        /**
         * sort는 직접구현보다는 제공하는 라이브러리를 사용하는게 좋음 (OK!)
         * reverse는 comperator를 사용해야함 -- 변경코드
         * Arrays.sort(numberToString); -- 기존 코드
         */

        Arrays.sort(numberToString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //내림차순 정렬
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        /**
         * Java 8 d이후의 버전 :: lambda 사용
         * 어렵다 람다식........ 익숙해져야만
         */
        Arrays.sort(numberToString, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        String answer = "";
        for(int j = numberToString.length - 1; j >= 0; j--) {
            answer += numberToString[j];
        }
        if(answer.charAt(0) == '0') {
            answer = "0";
        }
        System.out.println(answer);

    }
}
