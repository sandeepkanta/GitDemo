package com.practice.arrays;

import java.util.HashMap;

public class SumEqualsToSum {
    public int findPairs(int arr[],int n)
    {
        var map=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                int value = map.getOrDefault(sum, 0);
                if(value > 1)
                    return 1;
                map.put(sum, value+1);
            }
        }
        return 0;
    }
}
