package com.company.practice.programmers.lecture.CodeRunning;

public class BigNumber {
    static int answer = 0;
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        int[] bucket = new int[ k];
        pick(number, bucket, k);

        System.out.println(answer);
    }
    public static void pick(String number, int[] bucket, int k) {
        if(k == 0) {
            String result = "";
            int bucketIdx = 0;
            for(int i = 0; i < number.length(); i++) {
                if(i != bucket[bucketIdx]) {
                    result += number.charAt(i);
                } else {
                    if(bucketIdx != bucket.length - 1) {
                        bucketIdx++;
                    }

                }
            }
            if ((answer < Integer.parseInt(result))) {
                answer = Integer.parseInt(result);
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
