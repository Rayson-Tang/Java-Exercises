package com.Rayson.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = lengthOfLongestSubstring(str);
        System.out.println(count);
    }

    public static Integer lengthOfLongestSubstring(String s){
        char[] a = s.toCharArray();
        List<Character> list = new ArrayList<>();
        if(a.length==0){
            return 0;
        }else{
            int num=1;
            for (int j=0;j<a.length;j++) {
                for(int i=j;i<a.length;i++) {
                    if(!list.contains(a[i])) list.add(a[i]);
                    else {
                        if(list.size()>=num)  {
                            num=list.size();
                        }
                        list.clear();
                        break;
                    }
                }
            }
            return num;
        }

    }

//    public static Integer lengthOfLongestSubstring(String s) {
//        ArrayList<Character> list = new ArrayList<>();
//        int count = 0;
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!list.contains(s.charAt(i))) {
//                list.add(s.charAt(i));
//            }
//            else {
//                list = new ArrayList<>();
//                list.add(s.charAt(i));
//            }
//            if (list.size() > max) {
//                max = list.size();
//            }
//        }
//        list = new ArrayList<>();
//        for (int i = (s.length() - 1); i >= 0; i--) {
//
//            if (!list.contains(s.charAt(i))) {
//                list.add(s.charAt(i));
//            }
//            else {
//                list = new ArrayList<>();
//                list.add(s.charAt(i));
//            }
//            if (list.size() > max) {
//                max = list.size();
//            }
//        }
//        return max;
//    }
}