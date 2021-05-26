package com.practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
    public static String infixToPostfix(String exp) {
        var stack = new Stack<Character>();
        String result = "";
        Map<Character, Integer> order = new HashMap<>();
        order.put('+', 1);
        order.put('-', 1);
        order.put('*', 2);
        order.put('/', 2);
        order.put('^', 3);
        for(int i=0;i<exp.length();i++){
           char ch = exp.charAt(i);
           if(ch == '(')
               stack.push('(');
           else if(order.containsKey(ch)){
               if(!stack.isEmpty() && order.get(stack.peek()) < order.get(ch)){
                   stack.push(ch);
               }else{
                   while (!stack.isEmpty() && order.get(stack.peek()) > order.get(ch)){
                       result += stack.pop();
                   }
                   stack.push(ch);
               }
           } else if(ch == ')'){
               while (!stack.isEmpty() && stack.peek() != '(')
                   result+=stack.pop();
               stack.pop();
           } else{
               result += exp.charAt(i);
           }
        }
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String result = infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println(result);

    }
}
