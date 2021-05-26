package com.practice.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class NodeAtDistance {

    int count=0;

    List<Integer> printKDistantfromLeafUtils(Node root, int k){
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            if(root.left == null && root.right == null){
                result.add(0);
            }else {
                result.addAll(printKDistantfromLeafUtils(root.left, k));
                result.addAll(printKDistantfromLeafUtils(root.right, k));
                if (!result.isEmpty()) {
                    for(int i=0;i<result.size();i++)
                        result.set(i, result.get(i) + 1);
                    count = count + (result.stream().filter(ele -> ele == k).findAny().isPresent() ? 1 : 0);
                }
            }
        }
        return result;
    }

    int printKDistantfromLeaf(Node root, int k)
    {

        printKDistantfromLeafUtils(root, k);
        return count;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        new NodeAtDistance().printKDistantfromLeaf(root, 2);
    }
}
