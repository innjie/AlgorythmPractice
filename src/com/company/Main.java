package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];
        int answerIdx = 0;
        for(int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int position = command[2];

            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);
            answer[answerIdx++] = subArray[position - 1];
        }

    }
}
