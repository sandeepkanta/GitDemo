package com.practice.stack;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        int n = q.size();
       var stack = new Stack<Integer>();
       for(int i=0;i<k;i++){
           stack.push(q.remove());
       }

       while (!stack.isEmpty()){
           q.add(stack.pop());
       }
       for(int i=0;i<n-k;i++){
           q.add(q.remove());
       }
       return q;
    }
}
