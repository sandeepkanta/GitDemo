package com.practice.arrays;

import java.util.Arrays;

public class SegregateEvenAndOddNumbers {
    int segregateEvenOddUtils(int arr[], int l, int h){
        if(l >= h)
            return l;
        int i=l,j=h;
        for(;i<h;i++){
            if(arr[i]%2 == 1)
                break;
        }
        for(;j>=0;j--){
            if(arr[j]%2==0)
                break;
        }
        if(i < j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            return segregateEvenOddUtils(arr, i+1, j-1);
        }
        return i;
    }
    void segregateEvenOdd(int arr[], int n) {
        int t = segregateEvenOddUtils(arr, 0, n-1);
        if(arr[t]%2 == 0){
            Arrays.sort(arr, 0, t+1);
            Arrays.sort(arr, t+1, n);
        }else{
            Arrays.sort(arr, 0, t);
            Arrays.sort(arr, t, n);
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};
        var obj = new SegregateEvenAndOddNumbers();
        obj.segregateEvenOdd(arr, arr.length);
    }
}
