package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxValue {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String s[] = br.readLine().split("\\s+");
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(s[i]);
            int max= Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(max < (arr[i] - i))
                    max = arr[i] - i;
                if(min > arr[i]-i)
                    min = arr[i] - i;

            }
            System.out.println(max - min);
        }

    }
}
