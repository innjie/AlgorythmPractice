package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int total = 0;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] bucket = new int[3];
        pick(nums, bucket, bucket.length);
        System.out.println(total);
    }
    public static void pick(int[] nums, int[] bucket, int k) {
        if(k == 0) {
            if(isPrime(Arrays.stream(bucket).sum())) {
                total++;
            }
            return;
        }

        int lastIdx = bucket.length - k - 1;

        for(int i = 0; i < nums.length; i++) {
            if(bucket.length == k) {
                bucket[0] = nums[i];
                pick(nums, bucket, k - 1);
            } else if(bucket[lastIdx] < nums[i]) {
                bucket[lastIdx + 1] = nums[i];
                pick(nums, bucket, k - 1);
            }
        }

    }
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
