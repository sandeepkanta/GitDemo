package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckIfArrayContainsContigousIntegersWithDuplicatesAllowed {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            int min = arr[0], max = arr[0];
            for(int i=1;i<n;i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            boolean result = true;
            for(int i=0;i<n;i++){
                int x = Math.abs(arr[i]) - min;
                if(x >= n) {
                    result = false;
                    break;
                }
                else if(arr[x] > 0){
                        arr[x] = -arr[x];
                }
            }
            if(result){
                max-=min;
                for(int i=0;i<=max;i++){
                    if(arr[i] >= 0) {
                        result = false;
                        break;
                    }
                }
            }
            if(result)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
