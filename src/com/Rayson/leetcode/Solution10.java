package com.Rayson.leetcode;

public class Solution10 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        String c = "abc";
        String d = "abc";
        System.out.println(c.charAt(0) == d.charAt(0));
        String[] strings = {""};
        Solution10 solution10 = new Solution10();
        String s = solution10.longestCommonPrefix(strings);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < Math.min(str.length(), strs[i].length()); j++) {
                if (str.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                tmp.append(str.charAt(j));
            }
            str = tmp.toString();
        }
        return str;
    }

}
