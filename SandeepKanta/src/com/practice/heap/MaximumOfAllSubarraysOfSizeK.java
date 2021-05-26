package com.practice.heap;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaximumOfAllSubarraysOfSizeK {


    static void printMaxUsingPriorityQueue(int[] arr, int n, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>( (Integer data1, Integer data2)  -> data2 - data1);
        for(int i=0;i<k;i++)
            queue.add(i);
        for(int i=k;i<=n;i++){
            while (!queue.isEmpty()){
                var entry = queue.peek();
                if(entry >= i-k) {
                    System.out.print(arr[entry] + " ");
                    break;
                }
                queue.remove();
            }
            if(i < n)
                queue.add(i);
        }
        System.out.println();
    }

    static void printMaxUsingDequeue(int arr[], int n, int k){
        Deque<Integer> q = new LinkedList<>();

        for(int i=0;i<k;i++){
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        for(int i=k;i<n;i++){
            System.out.print(arr[q.peek()] + " ");
            while (!q.isEmpty() && q.peek() <= i-k)
                q.removeFirst();
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String []str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            str = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(str[i]);
            printMaxUsingPriorityQueue(arr, n, k);

        }
    }
}
