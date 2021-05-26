package com.practice.trees;

public class MorrisInorderTraversal {

    public static int countNodes(Node root){
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void findMedian(Node root)
    {
        if(root!=null){
            Node node =root;
            Node result=null, prev=null;
            int count = countNodes(root);
            int median = count/2;
            while(node!=null)
            {
                if(node.left == null){
                    if(median-- == 0)
                    {
                        result = node;
                        break;

                    }
                    prev = node;
                    node = node.right;
                }else{
                    Node temp = node.left;
                    while(temp.right!=null && temp.right!=node)
                        temp = temp.right;
                    if(temp.right == null) {
                        temp.right = node;
                        prev = node;
                        node= node.left;
                    }
                    else {
                        temp.right = null;
                        if(median-- == 0)
                        {
                            result = node;
                            break;

                        }
                        prev = node;
                        node = node.right;
                    }
                }
            }
            if(count%2 == 0){
                if((result.data + prev.data) % 2 == 0){
                    System.out.println((result.data + prev.data) /2);
                }else{
                    System.out.println((result.data + prev.data) /2.0);
                }
            }else
                System.out.println(result.data);



        }
    }

    public static void main(String[] args){
       Node root = new Node(6);
       root.left = new Node(3);
       root.right = new Node(8);
       root.left.left = new Node(1);
       root.left.right = new Node(4);
       root.right.left = new Node(7);
        findMedian(root);
    }
}
