package com.practice.arrays;

public class MaximizeNumberOf1 {

    static int findZeroes(int arr[], int n, int m) {
         int WL=0, zeroCount=0,WR=0, bestW=Integer.MIN_VALUE;
         while (WR < n){
             if(zeroCount<=m){
                 if(arr[WR] ==0)
                     zeroCount++;
                 WR++;
             }
             if(zeroCount > m){
                 if(arr[WL] == 0)
                     zeroCount--;
                 WL++;
             }
             if(WR-WL > bestW && zeroCount <=m){
                 bestW = WR-WL;
             }
         }
         return bestW;
    }

    public static void main(String[] args) {
        int arr[] = {1,0,1,0};
        findZeroes(arr,arr.length,0);
    }
}
