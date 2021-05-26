package com.practice.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Spiral {

    ArrayList<Integer> findSpiral(Node node)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(node!=null) {
            Deque<Node> deque = new LinkedList<>();
            deque.add(node);
            int i = 1;
            while (!deque.isEmpty()){
                int n = deque.size();
                while (n-->0){
                    if(i%2 == 1){
                       Node temp = deque.removeLast();
                       result.add(temp.data);
                       if(temp.right!=null)
                           deque.addFirst(temp.right);
                       if(temp.left!=null)
                           deque.addFirst(temp.left);
                    }else {
                       Node temp = deque.removeFirst();
                       result.add(temp.data);
                       if(temp.left != null)
                           deque.addLast(temp.left);
                       if(temp.right!=null)
                           deque.addLast(temp.right);
                    }
                }
                i++;
            }
        }
        return result;
    }
}
