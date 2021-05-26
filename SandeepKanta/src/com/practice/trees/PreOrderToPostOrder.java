package com.practice.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PreOrderToPostOrder {

    static void PreOrderToPostOrder(int[] arr, int i, int j){

        if(i == j){
            System.out.print(arr[i] + " ");
        }else if(i < j){
            int element = arr[i];
            int l=i+1, h=j;
            while(l <= h){
                 int mid = (l+h) /2;
                if(arr[mid] < element){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
            PreOrderToPostOrder(arr, i+1, h);
            PreOrderToPostOrder(arr, h+1, j);
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str=br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            PreOrderToPostOrder(arr, 0, arr.length-1);
        }
    }

}
