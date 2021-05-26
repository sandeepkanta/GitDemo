package com.practice.arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElements {

    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<>(k);
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            queue.add(arr[i]);
            if(queue.size() > k)
                queue.remove();
        }
        for(int i=k-1;i>=0;i--){
            result.set(i, queue.remove());
        }
        return result;

    }
}
