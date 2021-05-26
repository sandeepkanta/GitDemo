package com.practice.arrays;

import java.util.ArrayList;

public class EvenAndOddElementsAtEvenAndOddPositions {

    static ArrayList<Long> arrangeOddAndEven(long a[], int n)
    {
        long arr[] = new long[n];
        int i=0,j=n-1,count=0;
        for(int k=0;k<n;k++){
            if(a[k]%2 == 0)
                count++;
        }
        j=count;
        for(int k=0;k<n;k++){
            if(a[k]%2 == 0)
                arr[i++] = a[k];
            else
                arr[count++] = a[k];
        }
        var result = new ArrayList<Long>();
        count=j;
        i=0;
        int k=0;
        while(i < count || j < n){
            if(i < count)
                result.add(arr[i++]);
            if(j < n)
                result.add(arr[j++]);
        }
        return result;
    }

    public static void main(String[] args) {
        long [] arr= {1, 2, 3, 4, 5, 6};
        arrangeOddAndEven(arr, arr.length);
    }

}
