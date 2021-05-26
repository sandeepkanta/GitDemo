package com.practice.arrays;

import java.util.HashMap;

public class LongestArithmaticProgression {

    int findIndex(int [] set, int x, int l, int h){
        while(l<=h){
            int mid = (l+h)/2;
            if(set[mid] == x){
                return mid;
            }else if(set[mid] > x){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    int lenghtOfLongestAP(int[] set, int n) {
        int arr[][] = new int[n][n];
        int max = Integer.MIN_VALUE;
        var map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++)
            map.put(set[i], i);
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)
                    arr[i][j]=1;
                else{
                    int index = map.getOrDefault(set[j]+set[j]-set[i], -1);
                    if(index <= j)
                        arr[i][j] = 2;
                    else
                        arr[i][j] = 1 + arr[j][index];
                }
                max = Math.max(arr[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []arr={2,4,6,8,10};
        var obj = new LongestArithmaticProgression();
        obj.lenghtOfLongestAP(arr, arr.length);

    }
}
