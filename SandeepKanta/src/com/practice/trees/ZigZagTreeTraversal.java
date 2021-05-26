package com.practice.trees;

import java.util.ArrayList;
import java.util.Stack;

class Node
{
    int data, height;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
        height = 0;
    }
}

public class ZigZagTreeTraversal {

    ArrayList<Integer> zigZagTraversal(Node root)
    {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        ArrayList<Integer> result = new ArrayList<>();
        int level=0;
        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            result.add(node.data);
            if(level%2 == 0) {
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }else{
                if(node.right!=null)
                    stack2.push(node.right);
                if (node.left != null)
                    stack2.push(node.left);
            }
            if(stack1.isEmpty())
            {
                level++;
                stack1=stack2;
            }

        }
        return result;
    }
}
