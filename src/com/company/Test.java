package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String s = "burger.letters.com - - [01/Jul/1995:00:00:12 -0400] 'GET /shuttle/countdown/video/livevideo.GIF HTTP/1.0' 200 0";
        String[] logs = s.split(" ");
        if(s.contains("gif") || s.contains("GIF")) {
            String[] url = logs[6].split("/");
            String gifName = url[url.length - 1];
            System.out.println(gifName);
        }

    }

}
