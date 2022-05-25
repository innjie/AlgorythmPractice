package com.company;

import java.util.*;

public class Main {
    static int total = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            int[] scores = new int[num];
            for(int j = 0; j < num; j++) {
                scores[j] = scanner.nextInt();
            }
            int total = Arrays.stream(scores).sum();
            int average = total / num;
            int check = (int) Arrays.stream(scores).filter(s -> s > average).count();

            System.out.println(String.format("%.3f", check / (double)num * 100) + "%");
        }
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
