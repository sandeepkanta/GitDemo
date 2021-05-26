package com.practice.arrays;

import java.util.Arrays;

public class InversionOfArray {

    private static int merge(long[] arr, int l, int mid, int h) {

        int count=0;
        long arr1[]= Arrays.copyOfRange(arr, l,mid+1);
        long arr2[]= Arrays.copyOfRange(arr, mid+1, h+1);
        int k=l, i=0,j=0;
        while (i<arr1.length && j<arr2.length){
            if(arr1[i] <= arr2[j]){
                arr[k++]=arr1[i++];
            }else{
                arr[k++]=arr2[j++];
                count+= (mid+1) - (l+i);
            }
        }
        while(i<arr1.length)
            arr[k++] = arr1[i++];
        while (j<arr2.length)
            arr[k++] = arr2[j++];
        return count;
    }

    static int mergeSortAndCount(long arr[], long l, long h){
        int count=0;
        if(l< h){
            long mid = (l+h)/2;
            count+=mergeSortAndCount(arr, l, mid);
            count+=mergeSortAndCount(arr, mid+1, h);
            count+=merge(arr, (int)l, (int)mid, (int)h);
        }
        return count;
    }



    static long inversionCount(long arr[], long N)
    {
        return mergeSortAndCount(arr, 0, N-1);
    }

    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        inversionCount(arr, 5);

    }
}
