package com.practice.trees;

public class ConstructTreeFromPreOrderTraversal {

    int index = 0;
    Node constructTreeUtils(int n, int pre[], char preLN[]){
        Node node = null;
        if(index < n){
            node = new Node(pre[index]);
            int temp = index++;
            if(pre[temp] == 'L')
                return node;
            node.left = constructTreeUtils(n, pre, preLN);
            node.right = constructTreeUtils(n, pre, preLN);
        }
        return node;
    }
    void printInorder(Node root){
        if(root==null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    Node constructTree(int n, int pre[], char preLN[]){
        Node node = constructTreeUtils(n, pre, preLN);
        printInorder(node);
        System.out.println();
        return node;
    }

    public static void  main(String[] args){
        ConstructTreeFromPreOrderTraversal obj = new ConstructTreeFromPreOrderTraversal();
        int pre[] = {10, 30, 20, 5, 15};
        char preLN[] = {'N', 'N', 'L', 'L', 'L'};
        obj.constructTree(pre.length, pre, preLN);
    }

}
