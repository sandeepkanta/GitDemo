package com.practice.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxofMinWindow {

    static int findMaxOfMinWindowsUsingDequeue(int arr[], int n, int k){
        Deque<Integer> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            while (!q.isEmpty() && arr[i] <= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        for(int i=k;i<=n;i++){
            if (max < arr[q.peek()]) {
                max = arr[q.peek()];
            }
            if(i < n) {
                while (!q.isEmpty() && q.peek() <= i - k)
                    q.removeFirst();
                while (!q.isEmpty() && arr[i] <= arr[q.peekLast()])
                    q.removeLast();
                q.addLast(i);
            }
        }
        return max;
    }

    static int findMaxOfMinWindowsUsingHeap(int[] arr, int n, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((Integer data1, Integer data2) -> arr[data1] - arr[data2]);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
            queue.add(i);
        for(int i=k;i<=n;i++){
            while (!queue.isEmpty()){
                var entry = queue.peek();
                if(entry >= i-k) {
                    if(max < arr[entry])
                        max = arr[entry];
                    break;
                }
                queue.remove();
            }
            if(i < n)
                queue.add(i);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String []str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            str = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(str[i]);
            for(int k=1;k<=n;k++) {
                int max = findMaxOfMinWindowsUsingHeap(arr, n, k);
                System.out.print(max + " ");
            }
            System.out.println();

        }
    }
}
