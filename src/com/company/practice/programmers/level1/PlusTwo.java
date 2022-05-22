package com.company.practice.programmers.level1;

import java.util.*;

public class PlusTwo {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};

        Set<Integer> addSet = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(i != j) {
                    addSet.add(numbers[i] + numbers[j]);
                }

            }
        }

        int[] result = new int[addSet.size()];

        int i = 0;
        for(int n : addSet) {
            result[i++] = n;
        }

        Arrays.sort(result);
    }
}
