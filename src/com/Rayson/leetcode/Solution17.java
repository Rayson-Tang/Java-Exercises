package com.Rayson.leetcode;

import java.util.*;

//有效括号
public class Solution17 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
//        s.charAt(0);
//        System.out.println(s.charAt(0) == '(');
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack != null && stack.peek() == map.get(c)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        else {
            return false;
        }

    }

//    public static boolean isValid(String s) {
//        char[][] chars = new char[3][s.length()];
//        int top0 = 0;
//        int top1 = 0;
//        int top2 = 0;
////        for (int i = 0; i < 3; i++) {
////            chars[i] = new char[];
////        }
//        for (char c:s.toCharArray()){
//            if (c == '('){
//                chars[0][top0] = c;
//                top0++;
//            }
//            if (c == '['){
//                chars[1][top1] = c;
//                top1++;
//            }
//            if (c == '{'){
//                chars[2][top2] = c;
//                top2++;
//            }
//            if (c == ')'){
//                if (top0 > 0 && chars[0][top0-1] == '('){
//                    top0--;
//                }else {
//                    return false;
//                }
//            }
//            if (c == ']'){
//                if (top1 > 0 && chars[1][top1-1] == '['){
//                    top1--;
//                }else {
//                    return false;
//                }
//            }
//            if (c == '}'){
//                if (top2 > 0 && chars[2][top2-1] == '{'){
//                    top2--;
//                }else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
