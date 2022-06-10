package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {


    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int[][] result = new int[n][2];

        //reserve와 lost의 경우 배열에 반영
        for (int i = 0; i < reserve.length; i++) {
            result[reserve[i] - 1][1]++;
        }
        for (int i = 0; i < lost.length; i++) {
            result[lost[i] - 1][1]--;
        }

        for (int i = 0; i < lost.length; i++) {
            // 맨앞, 뒤
            if (lost[i] - 1 == 0) {
                if (checkNext(lost, result, i)) {
                    result[lost[i]][1]--;
                    result[lost[i] - 1][1]++;
                }
            } else if (lost[i] - 1 == n - 1) {
                if (checkFront(lost, result, i)) {
                    result[lost[i] - 2][1]--;
                    result[lost[i] - 1][1]++;
                }

            } else { //그 외
                if (checkFront(lost, result, i) && result[lost[i] - 1][1] < 0) {
                    result[lost[i] - 2][1]--;
                    result[lost[i] - 1][1]++;
                }
                if (checkNext(lost, result, i) && result[lost[i] - 1][1] < 0) {
                    result[lost[i]][1]--;
                    result[lost[i] - 1][1]++;
                }

            }

        }
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i][1] >= 0) {
                count++;
            }
        }

        return count;
    }

    //내 위치 앞의 사람에게 여분이 있는지 검사
    public static boolean checkFront(int[] lost, int[][] result, int i) {
        if (result[lost[i] - 2][1] > 0) {
            return true;
        }
        return false;

    }

    //내 위치 뒤의 사람에게 여분이 있는지 검사
    public static boolean checkNext(int[] lost, int[][] result, int i) {
        if (result[lost[i]][1] > 0) {
            return true;
        }
        return false;
    }
}
