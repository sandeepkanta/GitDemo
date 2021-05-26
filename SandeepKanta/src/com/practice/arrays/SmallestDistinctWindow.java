package com.practice.arrays;

import java.util.Arrays;

public class SmallestDistinctWindow {

    public static int  compare(int []scount, int distinct){
        long countInArr = Arrays.stream(scount).filter(ele -> ele >=1).count();
        if(countInArr >= distinct)
            return 1;
        return -1;

    }
    public static String findSubString( String str) {
        int [] ch = new int[256];
        int []scount = new int[256];
        str+="$";
        int n = str.length();
        int count=0, min=str.length(),min_i=0, min_j=n;
        for(int i=0;i<n-1;i++){
            int c = (int) str.charAt(i);
            if(ch[c] == 0){
                ch[c]=1;
                count++;
            }
        }
        int i=0,wl=0, minLength=n;
        while(wl< n && i < n){
            int comparison = compare(scount, count);
            if( comparison > 0){
                if(minLength > i - wl) {
                    minLength = i - wl;
                    min_i = wl;
                    min_j = i;
                }
                scount[(int)str.charAt(wl++)]--;
            }else{
                scount[(int)str.charAt(i++)]++;
            }
        }
        return str.substring(min_i, min_j);
    }

    public static void main(String[] args) {
        findSubString("aabcbcdbca");
    }
}
