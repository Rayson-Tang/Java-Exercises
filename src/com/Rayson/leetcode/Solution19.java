package com.Rayson.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        List<String> strings = solution19.letterCombinations("2");
        System.out.println(strings);
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0){
            return combinations;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(digits, combinations, 0, map, new StringBuffer());
        return combinations;

    }
    public void backtrack(String digits, List<String> combinations, int index, Map<Character, String> map, StringBuffer combination){
        if (index == digits.length()){
            combinations.add(combination.toString());
        }
        else {
            char c = digits.charAt(index);
            String letter = map.get(c);
            for (int i = 0; i < letter.length(); i++) {
                combination.append(letter.charAt(i));
                backtrack(digits,combinations,index + 1, map,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
