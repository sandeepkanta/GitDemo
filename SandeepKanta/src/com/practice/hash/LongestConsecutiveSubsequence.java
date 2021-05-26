package com.practice.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(arr[i]);
            }
            int result = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(!set.contains(arr[i] -1)){
                   int count =0, val=arr[i];
                   while(true){
                       if(set.contains(val)){
                           count+=1;
                       }else{
                           break;
                       }
                       val++;
                   }
                   if(count > result)
                       result = count;
                }
            }
            System.out.println();
        }
    }
}
