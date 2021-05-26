package com.practice.arrays;

import java.util.Arrays;

public class PossibleGroups {

    static long findgroups(int[] arr, int n) {
        // code here
        int mod[] = new int[2];
        for(int i=0;i<n;i++){
            int t = arr[i]%3;
            mod[t]++;
        }
        long sum = (mod[0]*mod[1]*mod[2]) + (mod[1]*mod[2]) + ((mod[0] * (mod[0]-1))/2)
                + ((mod[0] * (mod[0]-1) * (mod[0]-2))/6);
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 7, 2, 9};
        findgroups(arr, arr.length);
    }
}
