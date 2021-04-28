package com.Rayson.algorithm.binarySortTree;

public class BinarySortTree {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            binaryTree.add(new Node(arr[i]));
        }
        binaryTree.infixOrder();
        System.out.println("---------------");
        binaryTree.delete(1);
        binaryTree.infixOrder();
    }


}

class BinaryTree {
    private Node root;

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
