package com.Rayson.dataStructures.linkedList;
//约瑟夫问题
public class CircleLinkedList {
    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.add(5);
        circleLinked.show();
        System.out.println("出列");
        countBoy(1,5,2,circleLinked.getFirst());
    }

    public static void countBoy(int start, int total, int count, BoyNode first){
        if (start <= 0 || total <= 0 || count <= 0 || start >= total){
            System.out.println("输入错误");
            return;
        }
        CircleLinked circleLinked = new CircleLinked();
        BoyNode helper = first;
        //helper指向最后节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //first指向开始节点，helper指向开始前一个
        for (int i = 0; i < start-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            //开始数数
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //出列
            System.out.println(first.no);
            first = first.getNext();
            helper.setNext(first);
            if (helper == first){
                break;
            }
        }
        System.out.println(first.no);
    }

    static class CircleLinked{
        private BoyNode first =new BoyNode(-1);

        public BoyNode getFirst() {
            return first;
        }

        //添加
        public void add(int nums){
            if (nums < 1){
                System.out.println("输入错误");
                return;
            }
            BoyNode cur = null;
            for (int i = 1; i <= nums; i++) {
                BoyNode boyNode = new BoyNode(i);
                if (i == 1){
                   first = boyNode;
                   first.next = first;
                   cur = first;
               }else {
                    cur.next = boyNode;
                    boyNode.next = first;
                    cur = boyNode;
                }
            }
        }

        //遍历
        public void show(){
            if (first == null){
                System.out.println("链表空");
                return;
            }
            BoyNode cur = first;
            while (true){
                System.out.printf("编号为%d\t",cur.getNo());
                if (cur.next == first){
                    break;
                }
                cur = cur.next;
            }
        }
    }


    static class BoyNode{
        private int no;
        private BoyNode next;

        public BoyNode(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public BoyNode getNext() {
            return next;
        }

        public void setNext(BoyNode next) {
            this.next = next;
        }
    }
}
