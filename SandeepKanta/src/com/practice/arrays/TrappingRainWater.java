package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            s = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            var stack = new Stack<Integer>();
            stack.push(arr[n-1]);
            for(int i=n-2;i>=0;i--)
                if(arr[i] > stack.peek())
                    stack.push(arr[i]);
                else
                    stack.push(stack.peek());
            int total = 0;
            int l_max = arr[0];
            for (int i = 0; i < n; i++) {
                if(arr[i] > l_max)
                    l_max = arr[i];
                int ele = stack.pop();
                total += Math.min(l_max, ele) - arr[i];
            }

            System.out.println(total);
        }
    }
}
