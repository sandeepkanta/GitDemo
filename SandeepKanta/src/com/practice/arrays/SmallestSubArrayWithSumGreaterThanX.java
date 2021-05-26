package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSubArrayWithSumGreaterThanX {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int sum = Integer.parseInt(s[1]);
            s=br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(s[i]);
            int min_length = Integer.MAX_VALUE, curr_sum=0, j=0;
            for(int i=0;i<n;i++){
                curr_sum+=arr[i];
                while (j<=i && curr_sum > sum){
                    if(min_length > (i-j+1)){
                        min_length = i-j+1;
                    }
                    curr_sum-=arr[j++];
                }
            }
            System.out.println(min_length);
        }
    }
}
