package com.practice.arrays;

import java.util.ArrayList;
import java.util.HashMap;

class Pair{
    int l,r;
    Pair(int l, int r){
        this.l=l;
        this.r=r;
    }
}
public class MountainSubArrayProblem {

    public static ArrayList<Boolean> processQueries(int[] arr, int n, ArrayList<Pair> queries,
                                             int q) {
        int right[] = new int[n];
        right[n-1] = n-1;
        // first decreasing
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i] > arr[i+1])
                right[i] = i;
            else
                right[i] = right[i-1];
        }
        int left[] = new int[n];
        left[0] = 0;
        //last increasing
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1])
                left[i] = i;
            else
                left[i] = left[i-1];
        }

        ArrayList<Boolean> result = new ArrayList<Boolean>();
        for(Pair pair: queries){
             if(right[pair.l] >= left[pair.r]){
                 result.add(true);
             }else{
                 result.add(false);
             }
        }
        return result;

    }

    public static void main(String[] args) {
        int arr[]= {15,16,17,18};
        ArrayList<Pair> queries = new ArrayList<>();
        queries.add(new Pair(13, 14));
        queries.add(new Pair(3, 14));
        processQueries(arr, arr.length, queries, queries.size());

    }
}
