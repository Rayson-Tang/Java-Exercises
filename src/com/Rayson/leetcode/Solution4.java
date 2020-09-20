package com.Rayson.leetcode;

//Z字变化

public class Solution4 {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int n = 3;
        Solution4 solution4 = new Solution4();
        String result = solution4.convert2(str, n);
        System.out.println(result);
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
        String[] str = new String[numRows];//默认每个字符串是null
        for (int i = 0; i < numRows; i++) {
            str[i] = "";//手动置""
        }
        int flag = 0;//进行自增或者自减的标志位
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag == 0 && j < numRows) {//从0自增到nuRows-1
                str[j] = str[j] + s.charAt(i);
                j++;
                if (j == numRows) {
                    flag = 1;
                    j = j - 2;
                }
            }
            else if (flag == 1 && j >= 0) {//从nuRows-2自减到0
                str[j] = str[j] + s.charAt(i);
                j--;
                if (j == -1) {
                    flag = 0;
                    j = j + 2;
                }
            }
        }
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res = res + str[i];//将所有str数组的String组合成结果
        }
        return res;
    }


    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        String[] strings = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = "";
        }
        int flag = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag == 0 && index < numRows) {
                strings[index] = strings[index] + s.charAt(i);
                index++;
                if (index == numRows) {
                    flag = 1;
                    index = index - 2;
                }
            }
            else if (flag == 1 && index > 0) {
                strings[index] = strings[index] + s.charAt(i);
                index++;
                if (index < s.length()) {
                    flag = 0;
                    index = index + 2;
                }
            }
        }

        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res = res + strings[i];
        }
        return res;
    }

}

