package com.practice.miscelleanous;



public class MaxHeap {

    int [] heap;
    int heapSize,capacity;

    MaxHeap(int capacity){
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

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(11);
        maxHeap.insertKey(3);
        maxHeap.insertKey(2);
        maxHeap.deleteKey(1);
        maxHeap.insertKey(15);
        maxHeap.insertKey(5);
        maxHeap.insertKey(4);
        maxHeap.insertKey(45);
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.getMax());
        maxHeap.decreaseKey(2, 100);
        System.out.println(maxHeap.getMax());
    }
}
