package com.company.study;

public class HPermutation {
    public static void main(String[] args) {

    }
    public void solution(int[] items, int[] bucket, int k) {
        if(k == 0) {
            //
        }
        int lastIdx = bucket.length - k - 1;
        for(int i = 0; i < items.length; i++) {
                bucket[lastIdx + 1] = items[i];
                solution(items, bucket, k - 1);
        }
    }
}
