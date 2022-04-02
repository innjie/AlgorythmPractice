package com.company.study;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {

        String name = "ABCD";
        char[] charBucket = new char[3];

        stringDfs(charBucket, name, 3);
    }
    public static void dfs(int[] items, int[] bucket, int k) {
        if(k == 0) {
            for(int i = 0; i < bucket.length; i++) {
                System.out.print(bucket[i] + " ");
            }
            System.out.println();
            return;
        }
        int lastIdx = bucket.length - k - 1;
        for(int i = 0; i < items.length; i++) {
            int flag = 0;
            for(int j = 0; j <= lastIdx; j++) {
                if(bucket[j] == items[i]) {
                    flag = 1;
                }

            }
            if(flag == 1) {
                continue;
            }
            bucket[lastIdx + 1] = items[i];
            dfs(items, bucket, k - 1);
        }
    }
    public static void charDfs(char[] items, char[] bucket, int k) {
        if(k == 0) {
            for(int i = 0; i < bucket.length; i++) {
                System.out.print(bucket[i] + " ");
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
            }
            if(flag == 1) continue;
            bucket[lastIdx + 1] = items[i];
            charDfs(items, bucket, k - 1);
        }
    }
    public static void stringDfs(char[] bucket, String name, int k) {
        if(k == 0) {
            String result = new String(bucket);
            System.out.println(result);
            return;
        }
        int lastIdx = bucket.length - k - 1;
        for(int i = 0; i < name.length(); i++) {
            int flag = 0;
            for(int j = 0; j <= lastIdx; j++) {
                if(bucket[j] == name.charAt(i))
                    flag = 1;
            }
            if(flag == 1) continue;
            bucket[lastIdx + 1] = name.charAt(i);
            stringDfs(bucket, name, k - 1);
        }
    }
}
