package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransformTheArray {

    public static ArrayList<Integer> valid(int arr[] , int n)
    {
        ArrayList<Integer> result=new ArrayList<Integer>(Collections.nCopies(n, 0));
        int k=0;
        int prev =-1;
        for(int i=0;i<n;i++){
            if(arr[i] > 0){
                if(prev < 0 || arr[prev]!=arr[i]) {
                    if(prev > 0) {
                        result.set(k, arr[prev]);
                        k++;
                    }
                    prev = i;

                }
                else{
                    arr[prev] = 2 * arr[prev];
                    arr[i] = 0;
                }
            }
        }
        if(prev > 0 && arr[prev] > 0)
            result.set(k, arr[prev]);
        return  result;
    }

    public static void main(String[] args) {
        int [] arr = {2, 4, 5, 0, 0, 5, 4, 8, 6, 0, 6, 8};
        valid(arr, arr.length);
    }
}
