package com.Rayson.leetcode;

public class test {
    public static void main(String[] args) {
        String str = "asd";
        StringBuffer sb = new StringBuffer(str);
        fun(sb);
        System.out.println(sb);
    }
    public static void fun(StringBuffer sb){
        sb.append("s");
    }
}
