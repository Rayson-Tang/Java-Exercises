package com.Rayson;

import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args) {
        System.out.println("请输入一段字符");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        count(str);
    }

    public static void count(String str) {
        int countCharacter = 0;
        int countSpace = 0;
        int countNumber = 0;
        int countOther = 0;
        String character = "[a-zA-Z]";
        String space = "[\\s]";
        String number = "[0-9]";
        char[] chars = str.toCharArray();
        String[] strings = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strings[i] = String.valueOf(chars[i]);
        }
        for (String s : strings) {
            if (s.matches(character)){
                countCharacter++;
            }
            else if(s.matches(space)){
                countSpace++;
            }
            else if (s.matches(number)){
                countNumber++;
            }
            else {
                countOther++;
            }
        }
        System.out.println("字母有" + countCharacter + "个");
        System.out.println("空格有" + countSpace + "个");
        System.out.println("数字有" + countNumber + "个");
        System.out.println("其他符号有" + countOther + "个");
    }
}
