package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int left = 13;
        int right = 17;


        int answer = 0;
        for(int i = left; i <= right; i++) {
            int count = countOfDivides(i);

            if(count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
    }
    public static int countOfDivides(int n ) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
