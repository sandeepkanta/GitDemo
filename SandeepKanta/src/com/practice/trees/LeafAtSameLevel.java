package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeafAtSameLevel {

    boolean check(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        boolean leaf_found = false;
        q.add(root);
        boolean result = true;
        while (!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                Node node = q.remove();
                Node left = node.left, right = node.right;
                if(left == null && right == null){
                    if(!leaf_found)
                        leaf_found = true;
                }
                if(left!=null)
                    q.add(node.left);
                if(right!=null)
                    q.add(node.right);
            }
            if(leaf_found && !q.isEmpty()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
