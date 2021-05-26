package com.practice.miscelleanous;

public class MinHeap {
    int [] heap;
    int heapSize,capacity;

    MinHeap(int capacity){
        this.heapSize = 0;
        this.heap = new int[capacity];
        this.capacity = capacity;
    }

    int parent(int i) { return (i-1)/2; }

    int left(int i) { return  2*i+1;}

    int right(int i) {return  2*i+2;}

    int getMin() { return heap[0];}

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
        while (i > 0 && heap[parent(i)] > heap[i]){
            swap(parent(i), i);
            i=parent(i);
        }
    }

    void decreaseKey(int i, int new_val){
        heap[i] = new_val;
        while (i > 0 && heap[parent(i)] > heap[i]){
            swap(parent(i), i);
            i=parent(i);
        }
    }

    int extractMin()
    {
        if(heapSize <=0)
            return Integer.MIN_VALUE;
        if(heapSize == 1)
            return heap[--heapSize];
        int root = heap[0];
        heap[0] = heap[--heapSize];
        MinHeapify(0);
        return root;
    }

    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int min = i;
        if(l < heapSize && heap[l] < heap[min])
            min = l;
        if(r < heapSize && heap[r] < heap[min])
            min = r;
        if(i!=min){
            swap(i, min);
            MinHeapify(min);
        }

    }

    void deleteKey(int i){
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

}
