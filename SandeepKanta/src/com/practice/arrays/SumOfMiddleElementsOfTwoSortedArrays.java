package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfMiddleElementsOfTwoSortedArrays {

    static int sumOfMiddleElements(int arr1[], int arr2[], int n){
        int low=0;
        int high=n;
        while (low<=high){
            int partitionX = (low + high)/2;
            int partitionY = (2*n+1)/2 - partitionX;
            int maxLeftX = partitionX==0?Integer.MIN_VALUE:arr1[partitionX-1];
            int minRightX = partitionX==n?Integer.MAX_VALUE:arr1[partitionX];
            int maxLeftY = partitionY==0?Integer.MIN_VALUE:arr2[partitionY-1];
            int minRightY = partitionY==n?Integer.MAX_VALUE:arr2[partitionY];
            if(maxLeftX <= minRightY && maxLeftY <=minRightX){
                return Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY);
            }else if(maxLeftX > minRightY){
                high = partitionX-1;
            }else{
                low = partitionX+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            String s[]=br.readLine().split(" ");
            String s1[]=br.readLine().split(" ");
            int arr1[]=new int[n];
            int arr2[]=new int[n];
            for(int i=0;i<n;i++){
                arr1[i]=Integer.parseInt(s[i]);
                arr2[i]=Integer.parseInt(s1[i]);
            }
            System.out.println(sumOfMiddleElements(arr1, arr2, n));
        }
    }
}
