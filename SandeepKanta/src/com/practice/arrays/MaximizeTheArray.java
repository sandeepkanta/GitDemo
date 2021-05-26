package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximizeTheArray {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int arr1[] = new int[n];
            int arr2[] = new int[n];
            String s1[] = br.readLine().split(" ");
            String s2[] = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                arr1[i] = Integer.parseInt(s1[i]);
                arr2[i] = Integer.parseInt(s2[i]);
            }
            int []map = new int[10];
            for(int i=0;i<n;i++){
                if(map[arr1[i]] == 0)
                    map[arr1[i]] = 1;
                if(map[arr2[i]] == 0)
                    map[arr2[i]] = 1;
            }
            int count=n;
            for(int i=9;i>=0;i--){
                if(count ==0 && map[i] == 1)
                    map[i] = 0;
                else if(map[i] == 1){
                    count--;
                }
            }
            for(int i=0;i<n;i++)
            {
                if(map[arr2[i]] == 1){
                    System.out.print(arr2[i] + " ");
                    map[arr2[i]]--;
                }
            }
            for(int i=0;i<n;i++)
            {
                if(map[arr1[i]] == 1){
                    System.out.print(arr1[i] + " ");
                    map[arr1[i]]--;
                }
            }
            System.out.println();
        }
    }
}
