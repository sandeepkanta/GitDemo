package com.practice.miscelleanous;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumEnergy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String [] str = br.readLine().split("\\s+");
            for (int i=0;i<n;i++)
                arr[i] = Integer.parseInt(str[i]);
            int initMinEnergy=0, currentEnergy=0;
            boolean flag=false;
            for(int i=0;i<n;i++){
                currentEnergy+=arr[i];
                if(currentEnergy <= 0){
                    initMinEnergy+=Math.abs(currentEnergy);
                    currentEnergy = 1;
                    flag = true;
                }
            }
            System.out.println(flag?initMinEnergy:1);
        }
    }
}
