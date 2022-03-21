package com.company.practice.programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1835?language=java
 */
public class TakePicture {
    public static int count = 0;

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        String name = "ACFJMNRT";
        char[] bucket = new char[name.length()];
        dfs(bucket, data, n, name, name.length());
        System.out.println(count);

    }

    public static void dfs(char[] bucket, String[] data, int n, String name, int k) {
        if (k == 0) { //end condition
            String result = new String(bucket);

            boolean satisfy = true;
            if(result.equals("ACFNTMJR")) {
                System.out.println();
            }
            for (int i = 0; i < n; i++) {
                String condition = data[i];
                char op = condition.charAt(3);
                char ch1 = condition.charAt(0);
                char ch2 = condition.charAt(2);
                int checkDistance = Integer.parseInt(String.valueOf(condition.charAt(4)));
                int ch1Idx = result.indexOf(ch1);
                int ch2Idx = result.indexOf(ch2);
                int distance = ch1Idx > ch2Idx ? ch1Idx - ch2Idx - 1 : ch2Idx - ch1Idx - 1;
                switch (op) {
                    case '<':
                        if (distance >= checkDistance) {
                            satisfy = false;
                        }
                        break;
                    case '>':
                        if (distance <= checkDistance) {
                            satisfy = false;
                        }
                        break;
                    case '=':
                        if (distance != 0) {
                            satisfy = false;
                        }
                        break;
                }
            }
            if (satisfy == true) {
                count++;
            }
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
            dfs(bucket, data, n, name, k - 1);
        }
    }
}
