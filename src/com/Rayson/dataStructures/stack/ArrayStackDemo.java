package com.Rayson.dataStructures.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.list();
        System.out.println("出");
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.list();
    }
}
class ArrayStack{
    int maxSize;
    int [] stack;
    int top = -1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //是否为满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //压入
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\t",i,stack[i]);
        }
        System.out.println();
    }
}
