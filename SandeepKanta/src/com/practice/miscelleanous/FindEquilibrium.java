package com.practice.miscelleanous;

import java.util.Arrays;

public class FindEquilibrium {

    public static int findEquilibrium(int arr[], int n){
       int sum = Arrays.stream(arr).sum();
       int psum=0;
       for(int i=0;i<n;i++){
           if(psum + arr[i] == sum - arr[i]){
               return i+1;
           }
           psum+=arr[i];
           sum-=arr[i];
       }
       return -1;
    }
}
