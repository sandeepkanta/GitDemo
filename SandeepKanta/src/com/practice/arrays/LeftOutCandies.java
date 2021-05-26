package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeftOutCandies {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int candies = Integer.parseInt(s[1]);
            int candies_left = candies % ((n*(n+1))/2);
            if(candies_left != 0){
                int i=1;
                while( ((i*(i+1))/2) < candies_left){
                    i++;
                }
                candies_left -= (i*(i+1))/2;
            }
            System.out.println(candies_left);
        }
    }
}
