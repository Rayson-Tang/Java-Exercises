package com.Rayson;

public class Demo2 {
    public static void main(String[] args) {
        int count = fun();
        System.out.println("一共" + count + "个");
    }

    public static int fun() {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                count++;
                System.out.println(i + " ");
            }
        }
        return count;
    }
}
