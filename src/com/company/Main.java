package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testcase = scan.nextInt();
        int[][] result = new int[testcase][3];
        for(int i = 0; i < testcase; i++) {
            result[i][0] = scan.nextInt();
            result[i][1] = scan.nextInt();
            result[i][2] = scan.nextInt();
        }

        for(int i = 0; i < testcase; i++) {
            System.out.println(room(result[i][0], result[i][1], result[i][2]));
        }
    }
    public static int room(int H, int W, int n) {
        int w = (n / H) + 1;
        int h = (n % H);


        if(n % H == 0) {
            w--;
            h = H;
        }
        return h * 100 + w;
    }
}
