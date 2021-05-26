package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateAndDelete {

    static void rotate(int[] arr, int n){
        int x=arr[n-1];
        int i=0, j=n-2;
        while(i < j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        i=0;
        j=n-1;
        while(i < j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
    private static int deleteEle(int[] arr, int n, int i) {
       int prev = arr[n-1];
       int j=1;
       while(i>j && j<n){
           int t = arr[n-j-1];
           arr[n-j-1] = prev;
           prev=t;
           j++;
       }
       return n-1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().split(" ");
            int []arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(s[i]);
            int m = n;
            for(int i=1;i<m;i++){
                rotate(arr, n);
                n=deleteEle(arr, n, i);
            }
            System.out.println(arr[n-1]);

        }
    }


}
