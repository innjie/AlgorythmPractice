package com.company.practice.programmers.lecture.CodeRunning;

import java.util.Stack;

public class BigNumber {
    static StringBuilder answer = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;

        int[] bucket = new int[number.length() - k];
        pick(number, bucket, number.length() - k);

        System.out.println(answer);
        System.out.println("92".compareTo("94"));

        //-------------------
        StringBuilder stringAnswer = new StringBuilder();
        int len = number.length() - k;
        int temp = 0;
        int index = 0;
        for(int i = 0; i < len; i++) {
            int max = 0;
            for(int j = index; j <= i + k; j++) {
                int num = number.charAt(j) - '0';
                if(max < num) {
                    temp = j;
                    max = num;
                }
            }
            stringAnswer.append(max);
            index = temp + 1;
        }
        String answerResult = stringAnswer.toString();
        System.out.println(answerResult);

    }
    public static void pick(String number, int[] bucket, int k) {
        if(k == 0) {
            String result = "";
            int bucketIdx = 0;
            for(int i = 0; i < number.length(); i++) {
                if(bucketIdx >= bucket.length) {
                    bucketIdx = bucket.length - 1;
                }
                if(i == bucket[bucketIdx]) {
                    result += number.charAt(i);
                    if(result.length() == answer.length() && result.compareTo(answer.toString()) < 0) {
                        System.out.println("result : " + result + ", answer: " + answer);
                        return;
                    }
                    bucketIdx++;
                }
            }
            if (result.compareTo(answer.toString()) > 0) {
                answer.append(result);
            }
            return;
        }

        int lastIdx = bucket.length - k - 1;
        for(int i = 0; i < number.length(); i++) {
            if(bucket.length == k) {
                bucket[0] = i;
                pick(number, bucket, k - 1);
            } else if(bucket[lastIdx] < i) {
                bucket[lastIdx + 1] = i;
                pick(number, bucket, k - 1);
            }
        }
    }
}
