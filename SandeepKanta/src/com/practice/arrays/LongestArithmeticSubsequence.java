package com.practice.arrays;

import java.util.HashMap;

public class LongestArithmeticSubsequence {
    public static int longestArithSeqLength(int[] set) {
        int max = Integer.MIN_VALUE, n=set.length;
        var map = new HashMap<String, Integer>();
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int diff = set[j] - set[i];
                String key = "";
                String s = "";
                if(diff == 0)
                    continue;
                if(diff< 0) {
                    key = set[j] + "-" + Math.abs(diff);
                    s = set[i] + "-" + Math.abs(diff);
                } else {
                    key = set[j] + "+" + Math.abs(diff);
                    s = set[i] + "+" + Math.abs(diff);
                }
                if(map.containsKey(key)){
                    map.put(s, 1+map.get(key));
                }else{
                    map.put(s, 2);
                }
                max = Math.max(max, map.get(s));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {12,28,13,6,34,36,53,24,29,2,23,0,22,25,53,34,23,50,35,43,53,11,48,56,44,53,31,6,31,57,46,6,17,42,48,28,5,24,0,14,43,12,21,6,30,37,16,56,19,45,51,10,22,38,39,23,8,29,60,18};
        longestArithSeqLength(arr);
    }
}
