package com.Rayson;

import java.text.SimpleDateFormat;

public class Date {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);

        java.util.Date date = new java.util.Date(l);
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        System.out.println(simpleDateFormat.format(l));
    }
}
