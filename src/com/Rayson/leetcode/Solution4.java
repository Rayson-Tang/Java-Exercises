package com.Rayson.leetcode;

//Z字变化

import java.util.ArrayList;

public class Solution4 {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int n = 3;
        Solution4 solution4 = new Solution4();
        String result = solution4.convert(str, n);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        ArrayList<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < s.length() && i < numRows; i++) {
            list.add(new StringBuffer());
        }
        int cur = 0;
        boolean flag = true;
        for (char c : s.toCharArray()) {
            list.get(cur).append(c);
            if (cur == 0 || cur == numRows-1){
                flag = !flag;
            }
            cur += flag?1:-1;
        }
        StringBuffer ret = new StringBuffer();
        for (StringBuffer row : list) ret.append(row);
        return ret.toString();

    }
}

