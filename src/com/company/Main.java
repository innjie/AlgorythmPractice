package com.company;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 5, b = 24;

        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        Map<String, Object> dayMap = new HashMap<>();


        LocalDate dateTime = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        int dayNum = dayOfWeek.getValue();

        System.out.println(days[dayNum - 1]);
    }
}
