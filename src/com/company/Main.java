배열 내의 숫자를 임의로 3개를 뽑아 소수가 되는지 확인하는 작업이다. (중복 허용하지 않음)
        따라서 이 문제를 배열 내 숫자 중 3개를 조합으로 뽑고, 소수를 판별하는 부분으로 나누어 풀었다.
         
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
    //임의의 k개를 조합으로 뽑는 함수
    //bucket의 길이만큼 뽑는다.
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
    //소수 판별
    //Math.sqrt를 활용하여 더 빠른 판별이 가능하다.
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}