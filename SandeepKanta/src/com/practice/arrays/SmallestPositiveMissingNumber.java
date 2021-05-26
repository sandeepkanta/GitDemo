package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SmallestPositiveMissingNumber {

    public static int findMissingElement(int[] arr, int n){
        boolean found1=false;
        for(int i=0;i<n;i++){
            if(arr[i] == 1)
                found1=true;
        }
        if(!found1)
           return 1;
        for(int i=0;i<n;i++){
            if(arr[i] <=0 || arr[i] >=n)
                arr[i] = 1;
        }
        for(int i=0;i<n;i++)
            arr[arr[i]-1 %n]+=n;
        for(int i=0;i<n;i++)
            if(arr[i] < n)
                return i+1;
        return n+1;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            s = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            System.out.println(findMissingElement(arr, n));
        }
    }
}
