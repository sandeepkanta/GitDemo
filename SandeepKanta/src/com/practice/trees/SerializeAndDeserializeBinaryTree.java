package com.practice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public void serialize(Node root, ArrayList<Integer> A) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                if(node == null){
                    A.add(-1);
                }else {
                    A.add(node.data);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
    }

    public Node deSerialize(ArrayList<Integer> A) {
        Node root = null;
        if (!A.isEmpty()) {
            root = new Node(A.get(0));
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            int i = 1;
            while (i < A.size()) {
                Node node = queue.remove();
                if (A.get(i++) != -1) {
                    node.left = new Node(A.get(i - 1));
                    queue.add(node.left);
                }
                if (A.get(i++) != -1) {
                    node.right = new Node(A.get(i - 1));
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        ArrayList<Integer> result = new ArrayList<>();
        var obj = new SerializeAndDeserializeBinaryTree();
        obj.serialize(root, result);
        Node node = obj.deSerialize(result);
    }
}
