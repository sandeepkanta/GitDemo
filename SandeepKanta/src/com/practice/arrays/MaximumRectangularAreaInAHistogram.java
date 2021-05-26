package com.practice.arrays;

import java.util.Stack;

public class MaximumRectangularAreaInAHistogram {

    public static long getMaxArea(long hist[], long n1)  {
        int n = (int)n1;
        long []prevSmallest = new long[n];
        long []nextSmallest = new long[n];
        nextSmallest[n-1] = n-1;
        var nextSmallestStack = new Stack<Integer>();
        nextSmallestStack.push(n-1);
        var prevSmallestStack = new Stack<Integer>();
        prevSmallestStack.push(0);
        for(int i=n-2;i>=0;i--)
        {
            long ele = hist[i];
            while(!nextSmallestStack.isEmpty() && hist[nextSmallestStack.peek()] >= ele){
                nextSmallestStack.pop();
            }
            if(nextSmallestStack.isEmpty()){
                nextSmallest[i] = n;
            }else{
                nextSmallest[i] = nextSmallestStack.peek()+1;
            }
            nextSmallestStack.push(i);

        }

        for(int i=1;i<n;i++)
        {
            long ele = hist[i];
            while(!prevSmallestStack.isEmpty() && hist[prevSmallestStack.peek()] >= ele){
                prevSmallestStack.pop();
            }
            if(prevSmallestStack.isEmpty()){
                prevSmallest[i] = -1;
            }else{
                prevSmallest[i] = prevSmallestStack.peek()+1;
            }
            prevSmallestStack.push(i);

        }
        long maxArea=0;
        for(int i=0;i<n;i++)
            System.out.print(nextSmallest[i] + " ");
        System.out.println();
        for(int i=0;i<n;i++)
            System.out.print(prevSmallest[i] + " ");
        System.out.println();
        for(int i=0;i<n;i++){
            long diff;
            if(nextSmallest[i] == prevSmallest[i])
                diff = 1;
            else
                diff = nextSmallest[i] - prevSmallest[i] -1;
            maxArea = Math.max(maxArea, diff * hist[i]);
        }
        return maxArea;
    }

    public static void main(String[] args){
        long [] arr ={5,4,3,2,1};
        getMaxArea(arr, arr.length);
    }

}
