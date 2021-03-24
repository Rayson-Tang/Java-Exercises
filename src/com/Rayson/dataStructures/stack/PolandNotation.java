package com.Rayson.dataStructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String str = "3 5 + 6 *";
        List<String> listString = getListString(str);
        int cal = cal(listString);
        System.out.println(cal);
    }
    //将逆波兰表达式存入集合
    public static List<String> getListString(String str){
        String[] s = str.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele:s){
            list.add(ele);
        }
        return list;
    }

    //运算逆波兰表达式
    public static int cal(List<String> strings){
        Stack<String> stack = new Stack<>();
        for (String s:strings){
            if (s.matches("\\d+")){//匹配多位数
                stack.push(s);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (s){
                    case "+":{
                        res = num1 + num2;
                        break;
                    }case "-":{
                        res = num2 - num1;
                        break;
                    }case "*":{
                        res = num1 * num2;
                        break;
                    }case "/":{
                        res = num2 / num1;
                        break;
                    }
                    default:{
                        System.out.println("输入错误");
                        break;
                    }
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

