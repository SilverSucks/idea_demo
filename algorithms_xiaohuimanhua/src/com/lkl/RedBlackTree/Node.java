package com.lkl.RedBlackTree;

/**
 * 红黑树中的结点类
 */
public class Node {
    boolean color;        //结点的颜色
    private int num;      //结点存储的值
    private Node left_Node;  //结点的左结点
    private Node right_Node; //结点的右结点
    private Node parent_Node;//结点的父节点

    public Node() {
    }

    public Node(boolean color, int num, Node left_Node, Node right_Node, Node parent_Node) {
        this.color = color;
        this.num = num;
        this.left_Node = left_Node;
        this.right_Node = right_Node;
        this.parent_Node = parent_Node;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getLeft_Node() {
        return left_Node;
    }

    public void setLeft_Node(Node left_Node) {
        this.left_Node = left_Node;
    }

    public Node getRight_Node() {
        return right_Node;
    }

    public void setRight_Node(Node right_Node) {
        this.right_Node = right_Node;
    }

    public Node getParent_Node() {
        return parent_Node;
    }

    public void setParent_Node(Node parent_Node) {
        this.parent_Node = parent_Node;
    }
}
