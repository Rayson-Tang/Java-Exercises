package com.Rayson.leetcode;

//罗马数字转换

public class Solution8 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String Roman = solution8.intToRoman(3);
        System.out.println(Roman);
    }

    public String intToRoman(int num) {
        int tmp = num;
        int a = tmp / 1000;
        StringBuilder res = new StringBuilder();
        if (a > 0) {
            for (; a > 0; a--) {
                res.append("M");
            }
        }
        tmp = tmp % 1000;
        int b = tmp / 100;
        if (b > 0 && b < 4) {
            for (; b > 0; b--) {
                res.append("C");
            }
        }
        else if (b == 4) {
            res.append("CD");
        }
        else if (b >= 5 && b < 9) {
            res.append("D");
            for (; b - 5 > 0; b--) {
                res.append("C");
            }
        }
        else if (b == 9) {
            res.append("CM");
        }
        tmp = tmp % 100;
        int c = tmp / 10;
        if (c > 0 && c < 4) {
            for (; c > 0; c--) {
                res.append("X");
            }
        }
        else if (c == 4) {
            res.append("XL");
        }
        else if (c >= 5 && c < 9) {
            res.append("L");
            for (; c - 5 > 0; c--) {
                res.append("X");
            }
        }
        else if (c == 9) {
            res.append("XC");
        }
        tmp = tmp % 10;
        int d = tmp;
        if (d > 0 && d < 4) {
            for (; d > 0; d--) {
                res.append("I");
            }
        }
        else if (d == 4) {
            res.append("IV");
        }
        else if (d >= 5 && d < 9) {
            res.append("V");
            for (; d - 5 > 0; d--) {
                res.append("I");
            }
        }
        else if (d == 9) {
            res.append("IX");
        }
        String r = res.toString();
        return r;
    }
}
