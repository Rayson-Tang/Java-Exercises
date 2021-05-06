package com.Rayson.algorithm.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[]arr = {10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            avlTree.add(node);
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
}

class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        }
        else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("空");
            return;
        }
        root.infixOrder();
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        else {
            Node targetNode = root.search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //删除节点为叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left == targetNode) {
                    parent.left = null;
                }
                else if (parent.right != null && parent.right == targetNode) {
                    parent.right = null;
                }
            }
            //删除节点有两个子树
            else if (targetNode.left != null && targetNode.right != null) {
                int rightMin = deleteRightMin(targetNode.right);
                targetNode.value = rightMin;
            }
            //删除节点有一个子树
            else {
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        }
                        else {
                            parent.right = targetNode.left;
                        }
                    }
                    else {
                        root = targetNode.left;
                    }
                }
                else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        }
                        else {
                            parent.right = targetNode.right;
                        }
                    }
                    else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    public int deleteRightMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }
}

class Node {
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //左子树高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    //右子树高度
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    //返回当前节点高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转
    public void leftRotate(){
        //1.创建新的节点
        //2.新的节点的左子树设为当前节点的左子树
        //3.新的节点的右子树设为当前节点的右子树的左子树
        //4.当前节点的值替换成右子节点的值
        //5.当前节点的右子树设为当前节点的右子树的右子树
        //6.当前节点的左子树设为新的节点
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    //右旋转
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.left = left.right;
        newNode.right = right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    //查找删除节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        }
        else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }

    }

    //查找删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            }
            else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            }
            else {
                return null;
            }
        }
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            }
            else {
                this.left.add(node);
            }
        }
        else {
            if (this.right == null) {
                this.right = node;
            }
            else {
                this.right.add(node);
            }
        }
        //当加完后（右子树高度-左子树高度）>1，进行左旋转
        if ((rightHeight() - leftHeight()) > 1){
            //如果它的右子树的左子树高度大于它的右子树的左子树高度，先对右子树右旋转，再整体左旋转
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
            }
            leftRotate();
            return;//!!!!!
        }
        //当加完后（左子树高度-左子树高度）》1，进行右旋转
        if ((leftHeight() - rightHeight()) > 1){
            //如果它的左子树的右子树高度大于它的左子树的左子树高度，先对左子树左旋转，再整体右旋转
            if(left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
            return;
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}