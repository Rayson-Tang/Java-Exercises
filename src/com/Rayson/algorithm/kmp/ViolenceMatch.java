package com.Rayson.algorithm.kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "jkl123555";
        String s2 = "123";
        int i = violenceMatch(s1, s2);
        System.out.println(i);
    }
    public static int violenceMatch(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = c1.length;
        int l2 = c2.length;
        int i = 0;
        int j = 0;
        while (i < l1 && j < l2){
            if (c1[i] == c2[j]){
                i++;
                j++;
            }
            else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == l2){
            return i - j;
        }else {
            return -1;
        }
    }
}
