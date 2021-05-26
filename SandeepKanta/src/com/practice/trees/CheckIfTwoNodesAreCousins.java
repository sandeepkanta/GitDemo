package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTwoNodesAreCousins {

    public boolean isCousins(Node root, int a, int b) {
        boolean result = false;
        if(root!=null) {
            var queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()){
                int n = queue.size();
                boolean isNodesHavingSameParent = false;
                boolean nodeFoundWithA = false, nodeFoundWithB=false;
                while (n-- > 0){
                    Node node  = queue.remove();
                    if(node.left!=null && node.right!=null){
                       if(node.left.data == a && node.right.data == b)
                         isNodesHavingSameParent = true;
                       if(node.left.data == b && node.right.data == a)
                           isNodesHavingSameParent = true;
                    }
                    if(node.data == a)
                        nodeFoundWithA = true;
                    if(node.data == b)
                        nodeFoundWithB = true;

                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);

                }
                if(isNodesHavingSameParent)
                    break;;
                if(nodeFoundWithA && nodeFoundWithB)
                    result = true;
            }
        }
        return  result;

    }
}
