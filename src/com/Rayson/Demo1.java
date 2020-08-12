package com.Rayson;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("请输入第几个月");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum =  fun(n);
        System.out.println("第" + n + "个月兔子有" + sum + "对");
    }
    public static int fun(int n){
        if (n == 1 || n == 2){
           return 1;
        }
        else {
            return fun(n - 1) + fun(n - 2);
        }
    }
}
