package com.Rayson.dataStructures.queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        boolean flag = true;
        String key;
        Scanner scanner = new Scanner(System.in);
        CircleArr circleArr = new CircleArr(4);
        while (flag) {
            System.out.println("输入a，添加数据");
            System.out.println("输入g，取出数据");
            System.out.println("输入s，查看数据");
            System.out.println("输入h，查看头数据");
            System.out.println("输入r，查看有效数据");
            System.out.println("输入e，退出");
            key = scanner.nextLine();
            switch (key) {
                case "a": {
                    System.out.println("请输入数字");
                    int num = new Scanner(System.in).nextInt();
                    circleArr.addArr(num);
                    break;
                }
                case "g": {
                    try {
                        int num = circleArr.getArr();
                        System.out.println("取出数据为" + num);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                }
                case "s": {
                    circleArr.showAll();
                    break;
                }
                case "h": {
                    try {

                        System.out.println("头数据为" + circleArr.head());
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "r" :{
                    System.out.println("有效数据为" + circleArr.realNum());
                    break;
                }
                case "e" :{
                    scanner.close();
                    flag = false;
                    break;
                }
                default:{
                    System.out.println("输入错误");
                    break;
                }
            }
        }

    }


    static class CircleArr {
        private int front;
        private int rear;
        private int maxSize;
        private int arr[];

        public CircleArr(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
        }

        //判断队列是否满
        public boolean ifFull() {
            return (rear + 1) % maxSize == front;
        }

        //判断队列是否为空
        public boolean ifEmpty() {
            return rear == front;
        }

        //获取队列数据
        public int getArr() {
            if (ifEmpty()) {
                throw new RuntimeException("队列无数据");
            }
            int n = arr[front];
            front = (front + 1) % maxSize;
            return n;
        }

        //添加数据
        public void addArr(int num) {
            if (ifFull()) {
                System.out.println("队列已满");
                return;
            }
            arr[rear] = num;
            rear = (rear + 1) % maxSize;
        }

        //显示所有数据
        public void showAll() {
            for (int i = front; i < front + realNum(); i++) {
                System.out.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
                System.out.println();
            }
        }

        //计算有效个数
        public int realNum() {
            return (maxSize + rear - front) % maxSize;
        }

        //显示头数据
        public int head() {
            if (ifEmpty()) {
                throw new RuntimeException("队列空");
            }
            return arr[front];
        }
    }
}
