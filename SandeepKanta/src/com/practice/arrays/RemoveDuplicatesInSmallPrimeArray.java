package com.practice.arrays;

import java.util.LinkedHashSet;

public class RemoveDuplicatesInSmallPrimeArray {

    int[] removeDuplicate(int arr[], int n)
    {
       var set = new LinkedHashSet<Integer>();
       for(int i=0;i<n;i++)
           set.add(arr[i]);
       int a[] = new int[set.size()];
       int i=0;
       for(var ele: set){
           a[i++] = ele;
       }
       return a;
    }

}
