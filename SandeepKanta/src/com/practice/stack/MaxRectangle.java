package com.practice.stack;

import java.util.Stack;

public class MaxRectangle {

    public static int calculateMaxArea(int []arr, int n){

        var stack = new Stack<Integer>();
        int maxArea = Integer.MIN_VALUE;
        int i=0;
        while(i < n){
            if(stack.isEmpty() || arr[stack.peek()]<=arr[i])
                stack.push(i++);
            else {
                int area = arr[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxArea < area)
                    maxArea = area;
            }
        }

        while (!stack.isEmpty()){
            int area = arr[stack.pop()] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            if(maxArea < area)
                maxArea = area;
        }

        return maxArea;
    }

    public static int maxArea(int M[][], int m, int n) {

        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            if(i!=0){
                for(int j=0;j<n;j++) {
                    if(M[i][j] != 0)
                     M[i][j] += M[i - 1][j];
                }
            }
            int area = calculateMaxArea(M[i],n);
            if(maxArea < area)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int M[][]= {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        maxArea(M,4,4);
    }

}
