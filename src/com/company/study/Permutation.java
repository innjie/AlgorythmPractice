package com.company.study;

public class Permutation {
    public static void main(String[] args) {
        int[] items = {1, 2, 3, 4};
        int[] bucket = new int[3];

        dfs(items, bucket, 3);
    }
    public static void dfs(int[] items, int[] bucket, int k) {
        if(k == 0) {
            for(int i = 0; i < bucket.length; i++) {
                System.out.println(bucket[i] + " ");
            }
            System.out.println();
            return;
        }
        int lastIdx = bucket.length - k - 1;
        for(int i = 0; i < items.length; i++) {
            int flag = 0;
            for(int j = 0; j <= lastIdx; j++) {
                if(bucket[j] == items[i])
                    flag = 1;
                if(flag == 1) continue;

            }
            bucket[lastIdx + 1] = items[i];
            dfs(items, bucket, k - 1);
        }
    }
}
