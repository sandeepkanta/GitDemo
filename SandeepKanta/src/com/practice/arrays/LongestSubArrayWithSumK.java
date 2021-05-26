package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LongestSubArrayWithSumK {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String s[] = br.readLine().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            s = br.readLine().split("\\s+");
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(s[i]);
            var map = new HashMap<Integer, Integer>();
            int sum=0, max=0;
            for(int i=0;i<n;i++)
            {
                sum+=arr[i];
                if(sum == k)
                    max = i+1;
                else {
                    if(map.containsKey(sum-k)){
                      max = Math.max(max, i - map.get(sum-k));
                    }
                }
                if(!map.containsKey(sum)){
                    map.put(sum, i);
                }
            }
            System.out.println(max);

        }


    }
}
