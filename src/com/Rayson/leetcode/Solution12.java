package com.Rayson.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution12 {
    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        HashMap map = new HashMap<Character,String>();
        List<String> list = new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            letters(map,digits.charAt(i),list);
        }
        return null;
    }
    public void letters(HashMap<Character,String> map, char c, List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String l = map.get(c);
            for (int j = 0; j < l.length(); j++) {
                String str = list.get(i);
                str += l.charAt(j);
                list.add(str);
            }


        }
    }

}
