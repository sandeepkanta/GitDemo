package com.practice.arrays;

import java.util.Arrays;

public class SwappingPairsMakeSumEqual {



    static  long findSwapValues(long A[], int n, long  B[], int m)
    {
        long sum1 = Arrays.stream(A).sum();
        long sum2 = Arrays.stream(B).sum();
        long diff = Math.abs(sum1-sum2);
        if(diff%2 == 1)
            return -1;
        if(sum1 < sum2){
            long temp[] = A;
            A=B;
            B=temp;
        }
       B = Arrays.stream(B).map(ele -> ele * -1).toArray();
       Arrays.sort(A);
       Arrays.sort(B);
       int i=0;
       for(;i<n;i++){
            long y = diff/2 - A[i];
            int l=0, h=B.length-1;
            while (l <= h){
                int mid = (l+h)/2;
                 if(B[mid] == y)
                     return 1;
                 else if(B[mid] > y)
                     h = mid-1;
                 else
                     l = mid+1;
            }
       }
       return -1;
    }

    public static void main(String[] args) {
        long [] arr1 = {4,1,2,1,1,2};
        long [] arr2 = {3,6,3,3};
        Arrays.stream(arr1).min();
        findSwapValues(arr1, arr1.length, arr2, arr2.length);
    }
}
