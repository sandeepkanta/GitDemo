package com.practice.miscelleanous;

public class KlargestElements {

    int[] kLargest(int[] arr, int n, int k) {
          int []result = new int[k];
          MinHeap minHeap = new MinHeap(k);
          for(int i=0;i<k;i++){
              minHeap.insertKey(arr[i]);
          }
          for(int i=k;i<n;i++){
              int min = minHeap.getMin();
              if(arr[i] >= min){
                  minHeap.extractMin();
                  minHeap.insertKey(arr[i]);
              }
          }
          for(int i=k-1;i>=0;i--)
            result[i] = minHeap.extractMin();
          return result;
    }
}
