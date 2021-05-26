package com.practice.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpanProblem {

    static void approachWithOutStack(int[] arr, int n){

        int []ans = new int[n+1];
        for(int i=1;i<=n;i++) {
            int counter = 1;
            while (i - counter >= 1 && arr[i - counter] <= arr[i]){
                  counter += ans[i - counter];
            }
            ans[i] = counter;
            System.out.print(i - counter + " ");

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            int arr[] = new int[n+1];
            for(int i=1;i<=n;i++)
                arr[i] = Integer.parseInt(str[i-1]);
            var stack = new Stack<Integer>();
            /*for(int i=1;i<=n;i++){
                int max_days = i;
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty())
                    max_days = i - stack.peek();
                System.out.print(max_days + " ");
                stack.push(i);
            }*/
            approachWithOutStack(arr, n);
        }
    }
}
