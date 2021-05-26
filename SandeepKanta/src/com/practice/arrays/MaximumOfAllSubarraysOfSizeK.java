package com.practice.arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> queue = new LinkedList<Integer>();
        int i;
        for(i=0;i<k;i++){
            while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()])
                queue.removeLast();
            queue.add(i);
        }
        for(;i<n;i++){
            result.add(arr[queue.peek()]);
            while (!queue.isEmpty() && queue.peek() <= i-k)
                queue.removeFirst();
            while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()])
                queue.removeLast();
            queue.add(i);
        }
        result.add(queue.peek());
        return result;
    }
}
