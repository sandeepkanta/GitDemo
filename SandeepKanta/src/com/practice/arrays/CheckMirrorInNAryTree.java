package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckMirrorInNAryTree {

    public static boolean checkMirrorUtil( Queue<Integer> tree1 , Stack<Integer> tree2 ){

        while(!tree1.isEmpty() && !tree2.isEmpty()){
            if(tree1.poll() != tree2.pop())
                return false;
        }
        if(!tree1.isEmpty() || !tree2.isEmpty())
            return false;
        return true;

    }

    public static boolean checkMirror(int arr1[], int arr2[], int n, int e){
         var tree1 = new ArrayList<Queue<Integer>>();
         var tree2 = new ArrayList<Stack<Integer>>();
         for(int i=0;i<=n;i++) {
             tree1.add(new LinkedList<>());
             tree2.add(new Stack<>());
         }
        for(int i=0;i<2*e;i+=2){

            tree1.get(arr1[i]).add(arr1[i+1]);
            tree2.get(arr2[i]).push(arr2[i+1]);
        }
        for(int i=1;i<=n;i++){
            if(!checkMirrorUtil(tree1.get(i), tree2.get(i)))
                return false;
        }
        return true;

    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            var str1 = br.readLine().split(" ");
            var str2 = br.readLine().split(" ");
            var arr1 = new int[2 * e];
            var arr2 = new int[2 * e];
            for (int i = 0; i < 2 * e; i++) {
                arr1[i] = Integer.parseInt(str1[i]);
                arr2[i] = Integer.parseInt(str2[i]);
            }
            if(checkMirror(arr1, arr2, n, e)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }
}

