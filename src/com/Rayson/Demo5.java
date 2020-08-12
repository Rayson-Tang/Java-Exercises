package com.Rayson;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if (grade(score) != null) {
            System.out.println("成绩为" + grade(score) + "级");
        }
    }

    public static String grade(int score) {
        if (score > 100 || score < 0) {
            System.out.println("输入错误");
            return null;
        }
        else {
            switch (score / 10) {
                case 10:
                case 9: {
                    return "A";
                }
                case 8:
                case 7:
                case 6: {
                    return "B";
                }
                default:
                    return "C";
            }
        }
    }
}
