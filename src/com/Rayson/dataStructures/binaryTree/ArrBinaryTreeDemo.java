package com.Rayson.dataStructures.binaryTree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前");
        arrBinaryTree.preOrder();
        System.out.println("中");
        arrBinaryTree.midOrder();
        System.out.println("后");
        arrBinaryTree.postOrder();
    }
}

class ArrBinaryTree {
    private int arr[];

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preOrder() {
        this.preOrder(0);
    }

    public void midOrder() {
        this.midOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }

    //顺序存储二叉树前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空");
            return;
        }
        System.out.println(arr[index]);
        //左节点
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //顺序存储二叉树中序遍历
    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空");
            return;
        }
        if (2 * index + 1 < arr.length) {
            midOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if (2 * index + 2 < arr.length) {
            midOrder(2 * index + 2);
        }
    }

    //后序
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空");
            return;
        }
        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
