package com.Rayson;

public class Demo3 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            fun(i);
        }
    }

    public static void fun(int i) {
        int x = i / 100;
        int y = i / 10 % 10;
        int z = i % 10;
        if (i == (x * x * x + y * y * y + z * z * z)) {
            System.out.print(i + " ");
        }
    }
}
