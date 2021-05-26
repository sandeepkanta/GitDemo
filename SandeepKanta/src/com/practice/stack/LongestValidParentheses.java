package com.practice.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String str = br.readLine();
            var stack = new Stack<Integer>();
            stack.push(-1);
            int result=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '(')
                    stack.push(i);
                else{
                    if(!stack.isEmpty())
                        stack.pop();
                    if(!stack.isEmpty())
                        result = Math.max(result, i - stack.peek());
                    else
                        stack.push(i);
                }
            }
            System.out.println(result);
        }

    }
}
