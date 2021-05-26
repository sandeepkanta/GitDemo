package com.practice.trees;

import java.util.Stack;

public class FindAPairWithGivenTargetInBST {

    public static int isPairPresent(Node root, int target)
    {
        var stack1 = new Stack<Node>();
        var stack2 = new Stack<Node>();
        Node r1=root, r2=root;
        boolean found = false;
        while(r1!=null || r2!=null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(r1!=null){
                stack1.push(r1);
                r1=r1.left;
            }
            while(r2!=null){
                stack2.push(r2);
                r2=r2.right;
            }
            if(stack1.peek().data >= stack2.peek().data)
                break;

            if(stack1.peek().data + stack2.peek().data > target){
                r2=stack2.pop();
                r2=r2.left;
            }
            else if(stack1.peek().data + stack2.peek().data < target) {
                r1=stack1.pop();
                r1=r1.right;
            }
            else {
                found = true;
                break;
            }
        }
        return found?1:0;

    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        isPairPresent(node, 5);
    }
}
