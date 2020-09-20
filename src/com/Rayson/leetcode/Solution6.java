package com.Rayson.leetcode;

//整数反转

public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int r = solution6.reverse(210046);
        System.out.println(r);
    }

    public int reverse(int x) {

        int tmp = x;
        int res = 0;
        for (int i = x; ; ) {
            i = tmp % 10;
            if (res > 214748364 || (res == 214748364 && i > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && i < -8)) {
                return 0;
            }


            tmp = tmp / 10;

            res = res * 10 + i;
            if (tmp == 0) {
                break;
            }
        }
        return res;
    }
//    public int reverse(int x) {
//        if (x < (-Math.pow(2, 31)) || x > Math.pow(2, 31) - 1) {
//            return 0;
//        }
//        int y = Math.abs(x);
//        StringBuilder sb1 = new StringBuilder();
//        int tmp = y;
//        for (int i = y; ; ) {
//            i = tmp % 10;
//            tmp = tmp / 10;
//
//            sb1.append(i);
//            if (tmp == 0) {
//                break;
//            }
//        }
//        String str = sb1.toString();
//        System.out.println(str);
//        int r = Integer.parseInt(str.trim());
//        if (x < 0) {
//            return 0 * (-1);
//        }
//        return 0;
//    }

}
