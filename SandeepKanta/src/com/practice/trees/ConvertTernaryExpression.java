package com.practice.trees;

public class ConvertTernaryExpression {

    static Node convertExpression(char[] expression, int i)
    {
        // Base case
        if (i >= expression.length)
            return null;

        // store current character of expression_string
        // [ 'a' to 'z']
        Node root = new Node(expression[i]);

        // Move ahead in str
        ++i;

        // if current character of ternary expression is '?'
        // then we add next character as a left child of
        // current node
        if (i < expression.length && expression[i]=='?')
            root.left = convertExpression(expression, i+1);

            // else we have to add it as a right child of
            // current node expression.at(0) == ':'
        else if (i < expression.length)
            root.right = convertExpression(expression, i+1);

        return root;
    }

    public static void main(String args[]) {
        String exp = "a?b?c:d:e";
        Node node = convertExpression(exp.toCharArray(), 0);
        System.out.println(node);
    }
}
