package com.practice.arrays;

public class RearrangeAnArrayWithO1Space {

    static void arrange(long arr[], int n)
    {
        for(int i=0;i<n;i++)
            arr[i] = arr[i] + (arr[((int)arr[i])]%n) * n;
        for(int i=0;i<n;i++)
            arr[i] = arr[i]/n;
    }

    public static void main(String[] args) {
        long arr[] = {4,0,2,1,3};
        arrange(arr, 5);
    }
}
