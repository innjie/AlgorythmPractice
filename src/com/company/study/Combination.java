package com.company.study;

public class Combination {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] bucket = new int[3];
        solution(nums, bucket, 4);

    }
    public static void solution(int[] items, int[] bucket, int k) {
        if(k == 0) {
            //
            return;
        }
        int lastIdx = bucket.length - k - 1;
        for(int i = 0; i < items.length; i++) {
            if(bucket.length == k) {
                bucket[0] = items[i];
                solution(items, bucket, k - 1);
            } else if(bucket[lastIdx] < items[i]) {
                bucket[lastIdx + 1] = items[i];
                solution(items, bucket, k - 1);
            }
        }
    }
}
