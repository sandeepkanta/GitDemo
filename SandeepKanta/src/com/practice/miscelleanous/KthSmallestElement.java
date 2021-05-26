package com.practice.miscelleanous;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KthSmallestElement {

    int [] heap;
    int heapSize,capacity;

    KthSmallestElement(int capacity){
        this.heapSize = 0;
        this.heap = new int[capacity];
        this.capacity = capacity;
    }

    int parent(int i) { return (i-1)/2; }

    int left(int i) { return  2*i+1;}

    int right(int i) {return  2*i+2;}

    int getMax() { return heap[0];}

    int getSize() { return heapSize;}

    void swap(int i, int j){
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

    void insertKey(int k){
        if(this.heapSize == capacity){
            System.out.println("Overflow could not insert key");
            return;
        }
        heap[heapSize++] = k;
        int i = heapSize - 1;
        while (i > 0 && heap[parent(i)] < heap[i]){
            swap(parent(i), i);
            i=parent(i);
        }
    }

    void decreaseKey(int i, int new_val){
        heap[i] = new_val;
        while (i > 0 && heap[parent(i)] < heap[i]){
            swap(parent(i), i);
            i=parent(i);
        }
    }

    int extractMax()
    {
        if(heapSize <=0)
            return Integer.MAX_VALUE;
        if(heapSize == 1)
            return heap[--heapSize];
        int root = heap[0];
        heap[0] = heap[--heapSize];
        MaxHeapify(0);
        return root;
    }

    void MaxHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int max = i;
        if(l < heapSize && heap[l] > heap[max])
            max = l;
        if(r < heapSize && heap[r] > heap[max])
            max = r;
        if(i!=max){
            swap(i, max);
            MaxHeapify(max);
        }

    }

    void deleteKey(int i){
        decreaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }


    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            int k = Integer.parseInt(br.readLine());
            KthSmallestElement obj = new KthSmallestElement(k);
            for(int i=0;i<k;i++){
                obj.insertKey(arr[i]);
            }
            for(int i=k;i<n;i++){
                int max = obj.getMax();
                if(max >= arr[i]){
                    obj.extractMax();
                    obj.insertKey(arr[i]);
                }
            }
            System.out.println(obj.getMax());
        }

    }
}
