package com.practice.list;

class DNode {
    int data;
    DNode left,right;
    DNode(int d){
        data=d;
        left=right=null;
    }

}
public class BinaryTreeToCDLL {

    DNode head = null;

    void bTreeToClistUtils(DNode root)
    {
        if(root != null){
            bTreeToClist(root.right);
            root.right = head;
            if(head!=null)
                head.left = root;
            head = root;
            bTreeToClist(root.left);
        }
    }

    DNode bTreeToClist(DNode root)
    {
        //your code here
        head = null;
        bTreeToClistUtils(root);
        if(head == null)
            return null;
        DNode node = head;
        while(node.right!=null){
            node = node.right;
        }
        head.left = node;
        node.right = head;
        return head;

    }

    public static void main(String[] args) {
        var obj = new BinaryTreeToCDLL();
        DNode node = new DNode(1);
        node.left = new DNode(3);
        node.right = new DNode(2);
        obj.bTreeToClist(node);
    }
}
