package com.company.practice.programmers.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Openchat {
    public static class User {
        String id;
        String message;

        public User(String id, String message) {
            this.id = id;
            this.message = message;
        }
    }
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"};

        Queue<User> stringQueue = new LinkedList<>();
        Map<String, String> idNameMap = new HashMap<String, String>();


        for(String s : record) {
            String[] strip = s.split(" ");


            String result = "";

            if(strip[0].equals("Enter")) {
                idNameMap.put(strip[1], strip[2]);
                result += "####님이 들어왔습니다.";
                stringQueue.offer(new User(strip[1], result));
            } else if(strip[0].equals("Leave")) {
                result += "####님이 나갔습니다.";
                stringQueue.offer(new User(strip[1], result));
            } else {
                idNameMap.put(strip[1], strip[2]);
            }

        }
        String[] answer = new String[stringQueue.size()];
        int answerIdx = 0;
        while(!stringQueue.isEmpty()) {
            User user = stringQueue.poll();
            String name = idNameMap.get(user.id);
            String message = user.message;

            message = message.replaceAll("####", name);
            answer[answerIdx] = message;
            answerIdx++;
        }

        for(String a : answer) {
            System.out.println(a);
        }
    }
}
