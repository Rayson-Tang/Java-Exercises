//package com.Rayson.dataStructures.binaryTree;
//
//public class BinaryTreeDemo {
//
//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        HeroNode h1 = new HeroNode(1, "a");
//        HeroNode h2 = new HeroNode(2, "b");
//        HeroNode h3 = new HeroNode(3, "c");
//        HeroNode h4 = new HeroNode(4, "d");
//        HeroNode h5 = new HeroNode(5, "d");
//        HeroNode h6 = new HeroNode(6, "d");
//        HeroNode root = new HeroNode(0, "z");
//        root.setLeft(h1);
//        root.setRight(h2);
//        h1.setLeft(h3);
//        h1.setRight(h4);
//        h3.setLeft(h5);
//        h4.setRight(h6);
//        binaryTree.setRoot(root);
////        System.out.println("前序");
////        //binaryTree.preOrder();
////        binaryTree.preSearch(0);
////        System.out.println("中序");
////        //binaryTree.midOrder();
////        binaryTree.midSearch(0);
////        System.out.println("后序");
////        //binaryTree.postOrder();
////        binaryTree.postSearch(0);
//    }
//}
//
////定义二叉树
//class BinaryTree {
//    private HeroNode root;
//
//    public HeroNode getRoot() {
//        return root;
//    }
//
//    public void setRoot(HeroNode root) {
//        this.root = root;
//    }
//
//    public void preOrder() {
//        if (this.root != null) {
//            this.root.preOrder();
//        }
//        else {
//            System.out.println("空");
//        }
//    }
//
//    public void midOrder() {
//        if (this.root != null) {
//            this.root.midOrder();
//        }
//        else {
//            System.out.println("空");
//        }
//    }
//
//    public void postOrder() {
//        if (this.root != null) {
//            this.root.postOrder();
//        }
//        else {
//            System.out.println("空");
//        }
//    }
//
//    public HeroNode preSearch(int no) {
//
//        if (this.root != null) {
//            return this.root.preSearch(no);
//        }
//        else {
//            System.out.println("空");
//            return null;
//        }
//    }
//
//    public HeroNode midSearch(int no) {
//
//        if (this.root != null) {
//            return this.root.midSearch(no);
//        }
//        else {
//            System.out.println("空");
//            return null;
//        }
//    }
//
//    public HeroNode postSearch(int no) {
//
//        if (this.root != null) {
//            return this.root.postSearch(no);
//        }
//        else {
//            System.out.println("空");
//            return null;
//        }
//    }
//
//    public void delete(int no){
//        if (root != null){
//            if (root.getNo() == no){
//                root = null;
//            }else {
//                root.delete(no);
//            }
//        }
//        else {
//            System.out.println("空");
//        }
//    }
//}
//
//class HeroNode {
//    private int no;
//    private String name;
//    private HeroNode left;
//    private HeroNode right;
//
//    public HeroNode(int no, String name) {
//        this.no = no;
//        this.name = name;
//    }
//
//    public HeroNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(HeroNode left) {
//        this.left = left;
//    }
//
//    public HeroNode getRight() {
//        return right;
//    }
//
//    public void setRight(HeroNode right) {
//        this.right = right;
//    }
//
//    public int getNo() {
//        return no;
//    }
//
//    public void setNo(int no) {
//        this.no = no;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "HeroNode{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    //前序遍历
//    public void preOrder() {
//        System.out.println(this);//输出父节点
//        //左子树
//        if (this.left != null) {
//            this.left.preOrder();
//        }
//        //右子树
//        if (this.right != null) {
//            this.right.preOrder();
//        }
//    }
//
//    //中序遍历
//    public void midOrder() {
//        if (this.left != null) {
//            this.left.midOrder();
//        }
//        System.out.println(this);
//        if (this.right != null) {
//            this.right.midOrder();
//        }
//    }
//
//    //后序遍历
//    public void postOrder() {
//        if (this.left != null) {
//            this.left.postOrder();
//        }
//        if (this.right != null) {
//            this.right.postOrder();
//        }
//        System.out.println(this);
//    }
//
//    //前序查找
//    public HeroNode preSearch(int no) {
//        System.out.println("前");
//        if (this.no == no) {
//            return this;
//        }
//        HeroNode res = null;
//        if (this.left != null) {
//            res = this.left.preSearch(no);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (this.right != null) {
//            res = this.right.preSearch(no);
//        }
//        return res;
//    }
//
//    //中序查找
//    public HeroNode midSearch(int no) {
//        HeroNode res = null;
//        if (this.left != null) {
//            res = this.left.midSearch(no);
//        }
//        if (res != null) {
//            return res;
//        }
//        System.out.println("中");
//        if (this.no == no) {
//            return this;
//        }
//        if (this.right != null) {
//            res = this.right.midSearch(no);
//        }
//        return res;
//    }
//
//    //后序查找
//    public HeroNode postSearch(int no) {
//        HeroNode res = null;
//        if (this.left != null) {
//            res = this.left.postSearch(no);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (this.right != null) {
//            res = this.right.postSearch(no);
//        }
//        if (res != null) {
//            return res;
//        }
//        System.out.println("后");
//        if (this.no == no) {
//            return this;
//        }
//        return res;
//    }
//
//    public void delete(int no){
//        if(this.left != null && this.left.no == no){
//            this.left = null;
//            return;
//        }
//        if (this.right != null && this.right.no == no){
//            this.right = null;
//            return;
//        }
//        if (this.left != null){
//            this.left.delete(no);
//        }
//        if (this.right != null){
//            this.right.delete(no);
//        }
//    }
//}