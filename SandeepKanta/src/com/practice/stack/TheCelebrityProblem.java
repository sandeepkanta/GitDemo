package com.practice.stack;

import java.util.Stack;

public class TheCelebrityProblem {
    int celebrity(int M[][], int n){
        var stack = new Stack<Integer>();
        for(int i=0;i<n;i++)
            stack.push(i);
        int result = -1;
        while (!stack.isEmpty()){
            int A = stack.pop();
            if(stack.isEmpty())
                result =  A;
            int B = stack.pop();
            if(M[A][B] == 1)
                stack.push(B);
            else
                stack.push(A);
        }
        return result;
    }

}
