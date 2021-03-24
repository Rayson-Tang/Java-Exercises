package com.Rayson.dataStructures.stack;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String str = "2+3*5+60";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            ch = str.charAt(index);
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                }
                else {
                    if (operStack.priority(ch) <= operStack.priority(operStack.pickTop())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }
                    else {
                        operStack.push(ch);
                    }
                }
            }
            else {
                //numStack.push(ch - 48);//'1' -> 1
                //处理多位数
                keepNum += ch;
                if (index == str.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }
                else {
                    if (operStack.isOper(str.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= str.length()) {
                break;
            }
        }
            while (true) {
                if (operStack.isEmpty()) {
                    //符号为空，结束
                    break;
                }
                else {
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    oper = operStack.pop();
                    res = numStack.cal(num1, num2, oper);
                    numStack.push(res);
                }
            }
            System.out.println(str + '=' + numStack.pop());

    }
}

class ArrayStack2 {
    int maxSize;
    int[] stack;
    int top = -1;

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //是否为满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //压入
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //查看栈顶
    public int pickTop() {
        return stack[top];
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\t", i, stack[i]);
        }
        System.out.println();
    }

    //判断运算符优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }
        else if (oper == '+' || oper == '-') {
            return 0;
        }
        else {
            return -1;
        }
    }

    //是否为运算符
    public boolean isOper(char value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+': {
                res = num1 + num2;
                break;
            }
            case '-': {
                res = num2 - num1;
                break;
            }
            case '*': {
                res = num1 * num2;
                break;
            }
            case '/': {
                res = num2 / num1;
                break;
            }
            default:
                break;
        }
        return res;
    }
}
