package com.practice.arrays;

public class MaxDifference {

    static int maxIndexDiff(int arr[], int n) {
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = arr[0];
        for(int i=1;i<n;i++)
            left[i] = Math.min(arr[i], left[i-1]);
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
            right[i] = Math.max(arr[i], right[i+1]);
        int i=0,j=0, maxDiff=-1;
        while(i < n && j < n){
            if(left[i] < right[j]){
                maxDiff = Math.max(maxDiff, j-i);
                j+=1;
            }else{
                i+=1;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {82,63,44,74,82,99,82};
        maxIndexDiff(arr, arr.length);
    }
}
