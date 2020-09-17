package com.Rayson.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        Boolean flag = solution5.isPalindrome(123);
        System.out.println(flag);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int tmp = x;
        for (int i = x; ; ) {
            i = tmp % 10;
            tmp = tmp / 10;

            sb1.append(i);
            if (tmp == 0) {
                break;
            }
        }
        String str1 = sb1.toString();
        sb2 = sb1.reverse();
        String str2 = sb2.toString();
        System.out.println(sb1);
        System.out.println(str1 + "," + str2);
        boolean flag = true;
        for (int i = 0; i < str1.length() && flag; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                flag = false;
            }
        }
        return flag;
    }
}
