package com.Rayson.dataStructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
//        String str = "3 5 + 6 *";
        String str = "1+((2+3)×4)-5";
        List<String> listString = toInfixList(str);
        List<String> strings = parseSuffixExpreesionList(listString);
        //int cal = cal(strings);
        System.out.println(str + "----" + listString + "----" + strings);
        //System.out.println(cal);
    }

    //将中缀表达式存入对应ArrayList
    public static List<String> toInfixList(String str) {
        //定义一个List，存入
        List<String> list = new ArrayList<>();
        int i = 0;
        //多位数拼接
        char c = ' ';
        String s = "";
        while (i < str.length()) {
            c = str.charAt(i);
            if (c < 48 || c > 57){//非数字
                list.add(c + "");
                i++;
            }else {
                s = "";
                while (i < str.length() && str.charAt(i)>= 48 && str.charAt(i) <= 57){
                    s += str.charAt(i);
                    i++;
                }
                list.add(s);
            }
        }
        return list;
    }

    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈s2
        List<String> s2 = new ArrayList<String>(); // 储存中间结果的Lists2

        //遍历ls
        for(String item: ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            }
            else if (item.equals("(")) {
                s1.push(item);
            }
            else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                String peek = s1.peek();
                while (!peek.equals("(")) {
                    s2.add(s1.pop());
                    peek = s1.peek();
                }
                s1.pop();//!!! 将 ( 弹出 s1栈， 消除小括号
            }
            else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }while(s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2; //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List

    }
    //中缀表达式转后缀表达式
//    public static List<String> parseList(List<String> ls){
//        Stack<String> s1 = new Stack<>();
//        ArrayList<String> s2 = new ArrayList<>();
//        for (String l : ls){
//            if (l.matches("\\d+")){
//                s2.add(l);
//            }else if (l.equals("(")) {
//                s1.push(l);
//            }else if(l.equals(")")) {
//                while (!s1.peek().equals("(")) {
//                    s2.add(s1.pop());
//                }
//                s1.pop();
//            }
//               else {
//                 while (s1.size() != 0 && Operation.getValue(s1.peek())>=Operation.getValue(l)){
//                     s2.add(s1.pop());
//                 }
//                 s1.push(l);
//            }
//        }
//        while (s1.size() != 0){
//            s2.add(s1.pop());
//        }
//        return s2;
//    }

    //将逆波兰表达式存入集合
    public static List<String> getListString(String str) {
        String[] s = str.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : s) {
            list.add(ele);
        }
        return list;
    }

    //运算逆波兰表达式
    public static int cal(List<String> strings) {
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            if (s.matches("\\d+")) {//匹配多位数
                stack.push(s);
            }
            else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (s) {
                    case "+": {
                        res = num1 + num2;
                        break;
                    }
                    case "-": {
                        res = num2 - num1;
                        break;
                    }
                    case "*": {
                        res = num1 * num2;
                        break;
                    }
                    case "/": {
                        res = num2 / num1;
                        break;
                    }
                    default: {
                        System.out.println("输入错误");
                        break;
                    }
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 1;
    private static int DIV = 1;
    public static int getValue(String s){
        int res = 0;
        switch (s){
            case "+":{
                res = ADD;
                break;
            }case "-":{
                res = SUB;
                break;
            }case "*":{
                res = MUL;
                break;
            }case "/":{
                res = DIV;
                break;
            }
            default:{
                break;
            }
        }
        return res;
    }
}

