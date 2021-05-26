package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubArrayWithGivenSum {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int S = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(s[i]);
            int i=0,j=0,sum=0;
            boolean found = false;
            while(i < n){
                sum+=arr[i++];
                while (j<=i && sum > S){
                    sum-=arr[j++];
                }
                if(sum == S)
                {
                    if(sum == 0 && arr[i] == 0){
                        System.out.println((i+1) + " " + (i+1));
                        found = true;
                    }else if(sum!=0) {
                        System.out.println((j+1) + " " + (i+1));
                        found = true;
                    }
                }
            }
            if(!found)
                System.out.println(-1);

        }

    }
}
