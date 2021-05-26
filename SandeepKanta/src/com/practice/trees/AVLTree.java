package com.practice.trees;

public class AVLTree {

    private static int height(Node node) {
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static int getBalance(Node node) {
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private static Node getMinNode(Node node)
    {
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

    private static Node leftRotate(Node x) {
          Node y = x.right;
          Node t = y.left;
          y.left = x;
          x.right = t;
          x.height = 1 + Math.max(height(x.left), height(x.right));
          y.height = 1 + Math.max(height(y.left), height(y.right));
          return y;

    }

    private static Node rightRotate(Node y) {
         Node x = y.left;
         Node t = x.right;
         y.left = t;
         x.right = y;
         x.height = 1 + Math.max(height(x.left), height(x.right));
         y.height = 1 + Math.max(height(y.left), height(y.right));
         return x;
    }

    public static Node insert(Node node, int key)
    {
        if(node == null)
            return new Node(key);
        if(key < node.data)
            node.left = insert(node.left, key);
        else if(key > node.data)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if(balance > 1 && key < node.left.data)
            return rightRotate(node);
        if(balance > 1 && key > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && key > node.right.data)
            return leftRotate(node);

        if(balance < -1 && key < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;

    }

    public static Node deleteNode(Node node, int key)
    {
        if(node == null)
            return node;
        if(node.data > key)
            node.left =  deleteNode(node.left, key);
        else if(node.data < key)
            node.right = deleteNode(node.right, key);
        else {
            if (node.left == null || node.right == null)
                node = node.left == null ? node.right : node.left;
            else {
                Node temp = getMinNode(node.right);
                node.data = temp.data;
                node.right = deleteNode(node.right, temp.data);
            }
        }
        if(node == null)
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if(balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        if(balance > 1 && getBalance(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        if(balance < -1 && getBalance(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;

    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root = deleteNode(root, 4);
        root = deleteNode(root, 1);
        root = deleteNode(root, 3);
        root = deleteNode(root, 6);
    }




}
