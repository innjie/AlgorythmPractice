package com.company.practice.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
 */
public class BestAlbum {
    static class Music {
        int idx;
        String genre;
        int play;

        public Music(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        //check genre
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genreOrder = new ArrayList<>();
        while(map.size() != 0) {
            int max = -1;
            String maxKey = "";

            for(String key : map.keySet()) {
                int count = map.get(key);
                if(count > max) {
                    max = count;
                    maxKey = key;
                }
            }
            genreOrder.add(maxKey);
            map.remove(maxKey);
        }

        ArrayList<Music> result = new ArrayList<>();
        for(String genre : genreOrder) {
            ArrayList<Music> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    list.add(new Music(i, genre, plays[i]));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size() != 1) {
                result.add(list.get(1));
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).idx;
        }
    }
}
