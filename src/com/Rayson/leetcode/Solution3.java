package com.Rayson.leetcode;

class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String max = solution3.longestPalindrome("cbbd");
        System.out.println(max);
    }

    public static String longestPalindrome(String s) {

        String max = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           max = find(s, i - 1, i + 1,max);
            if (i != 0 && c == s.charAt(i - 1)) { // 第一个字符不作为双轴右部
               max = find(s, i - 2, i + 1,max);
            }
        }

        return max;
    }

    private static String find(String s, int i, int j,String max) {
        for (; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++)
            ;
        if (j - i - 1 > max.length()) {
            max = s.substring(i + 1, j);
        }
        return max;
    }
}