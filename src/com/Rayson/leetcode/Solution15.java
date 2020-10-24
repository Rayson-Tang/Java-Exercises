package com.Rayson.leetcode;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        String s = solution15.countAndSay(5);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String str = "1";

        for (int i = 2; i <= n; i++) {
            str = fun(str);
        }
        return str;
    }

    public String fun(String s) {
        StringBuffer sb = new StringBuffer();
        int n = 1;
        for (int i = 0; i < s.length() ; i++) {
            if ((i != s.length() - 1 && s.charAt(i) != s.charAt(i + 1) ) || i == s.length() - 1) {
                sb.append(n);
                sb.append(s.charAt(i));
                n = 0;
            }
            n++;
        }
        return sb.toString();
    }

}
