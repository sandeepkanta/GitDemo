package com.practice.arrays;

public class MaxAverageSubArray {

    static int findMaxAverage(int[] arr, int n, int k) {
        int sum=0, max=Integer.MIN_VALUE;
        for(int i=0;i<k-1;i++)
            sum+=arr[i];
        int i=0, j=k-1;
        while (j < n){
            sum+=arr[j++];
            if(sum > max)
                max = sum;
            sum-=arr[i++];
        }

        return max/k;
    }

    public static void main(String[] args) {
        int [] arr = {3, -435, 335, 10, -50, 100, 20};
        findMaxAverage(arr, arr.length,3);
    }

}


