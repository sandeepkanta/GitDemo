package com.practice.trees;

public class NumberOfTurnsInBinaryTree {
    static Node findLCA(Node root, int first, int second){
        if(root!=null){
            if(root.data == first || root.data == second)
                return root;

            Node left_lca = findLCA(root.left, first, second);
            Node right_lca = findLCA(root.right, first, second);

            if(left_lca!=null && right_lca!=null)
                return root;

            return left_lca!=null?left_lca:right_lca;

        }
        return null;

    }

    static int findTurns(Node lca, int data, boolean left, int turn){

        if(lca == null)
            return Integer.MIN_VALUE;

        if(lca.data == data)
            return turn;

        int value = Integer.MIN_VALUE;

        if(left){
            value =  findTurns(lca.left, data, true, turn);
            if(value == Integer.MIN_VALUE)
                value =  findTurns(lca.right, data, false, turn + 1);
        }else{
            value = findTurns(lca.left, data, true, turn + 1);
            if(value == Integer.MIN_VALUE)
                value =  findTurns(lca.right, data, false, turn);
        }

        return value;

    }

    static int NumberOfTurns(Node root, int first, int second)
    {
        Node lcaNode = findLCA(root, first, second);
        int left_turns = findTurns(lcaNode, first, true, 0);
        int right_turns = findTurns(lcaNode, second, true, 0);
        int total_turns = left_turns + right_turns;
        if(lcaNode.data == first || lcaNode.data == second)
           total_turns-=1;
        if(total_turns == 0)
            return -1;
        return total_turns;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.right.left = new  Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
        NumberOfTurns(root, 5, 10);
    }
}
