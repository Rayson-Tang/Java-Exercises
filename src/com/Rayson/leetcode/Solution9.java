package com.Rayson.leetcode;

//罗马数字转换整数

public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int r = solution9.romanToInt("MCMXCIV");
        System.out.println(r);
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0, j = 1; j < s.length(); i++,j++) {
            if (getValue(s.charAt(i)) < getValue(s.charAt(j))) {
                res -= getValue(s.charAt(i));
            }
            else res += getValue(s.charAt(i));
        }
        res += getValue(s.charAt(s.length() - 1));
        return res;
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;

        }
        return 0;
    }
}
