package com.practice.arrays;

import java.util.Arrays;

public class MinRemoval {

    static int minRemoval(int arr[], int n) {
        Arrays.sort(arr);
        int j=n-1,minRemovals=n-1,i=n-2, count=0;
        while(i>=0 && j>=0){
            if(2 * arr[i] >= arr[j]){
                count = i + n-j-1;
                minRemovals = Math.min(count, minRemovals);
                i--;
            }else{
                j--;
            }
        }
        return minRemovals;
    }

    public static void main(String[] args) {
        int arr[] = {4,7,5,6};
        minRemoval(arr, arr.length);
    }
}
