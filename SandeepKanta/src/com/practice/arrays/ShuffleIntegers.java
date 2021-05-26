package com.practice.arrays;

public class ShuffleIntegers {
    static void shuffleArrayUtils(long arr[], int l, int h){

        if(l >= h || h-l == 1)
            return;
        int mid = (l+h)/2;
        int temp = mid+1;
        int mmid = (l+mid)/2;
        for(int i=mmid+1; i<=mid;i++){
            long t = arr[temp];
            arr[temp] = arr[i];
            arr[i] = t;
        }
        shuffleArrayUtils(arr, l, mid);
        shuffleArrayUtils(arr, mid+1, h);

    }
    static void shuffleArray(long arr[], int n)
    {
        shuffleArrayUtils(arr, 0, n-1);
    }

    public static void main(String[] args) {
        long []arr = {1,2,3,4,5,6,7,8,9,10};
        shuffleArray(arr, arr.length);
        System.out.println(arr);
    }
}
