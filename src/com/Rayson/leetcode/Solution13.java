package com.Rayson.leetcode;

public class Solution13 {
    public static void main(String[] args) {
        String str = "{[]}";
        Solution13 solution13 = new Solution13();
        boolean flag = solution13.isValid(str);
        System.out.println(flag);
    }

    public boolean isValid(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (; sb.length() != 0 && sb != null; ) {

        }
        return false;
    }

    public static void fun(StringBuffer sb) {
        int a = 0;
        int b = sb.length();
        for (; a < b; ){
            
        }
    }
//    public boolean isValid(String s) {
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        boolean flag = true;
//        for (int i = 0; i < s.length(); i++) {
//            switch (s.charAt(i)) {
//                case '(': {
//                    a++;
//                    break;
//                }
//                case ')': {
//                    a--;
//                    break;
//                }
//                case '[': {
//                    b++;
//                    break;
//                }
//                case ']': {
//                    b--;
//                    break;
//                }
//                case '{': {
//                    c++;
//                    break;
//                }
//                case '}': {
//                    c--;
//                    break;
//                }
//            }
//            if (a < 0 || b < 0 || c < 0) {
//                flag = false;
//                break;
//            }
//        }
//        if (a != 0 || b != 0 || c != 0){
//            flag = false;
//        }
//        return flag;
//    }
}
