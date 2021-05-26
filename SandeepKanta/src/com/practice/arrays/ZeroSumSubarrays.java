package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarrays {

    public static int findSubarray(int[] arr ,int n)
    {
        var map = new HashMap<Integer, Integer>();
        int sum=0, count=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum == 0)
                count++;
            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum , map.get(sum) + 1);
            }else{
                map.put(sum , 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = {5, 0, 0 , -5};
        findSubarray(arr, arr.length);
    }
}
