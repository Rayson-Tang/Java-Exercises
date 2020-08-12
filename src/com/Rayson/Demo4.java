package com.Rayson;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        System.out.println("请输入要分解的数");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        fun(m);
    }
    public static void fun(int m){
        for (int i = 2; i <= m; i++) {
            if (m % i == 0)
            {
                System.out.print(i);
                m = m / i;
                if (m != 1){
                    System.out.print("*");
                    fun(m);
                }
                break;
            }
        }
    }
}
