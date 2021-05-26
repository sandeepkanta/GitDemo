package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextGreaterEvenNumber {

    static String ans="";
    static boolean findEven(char[] ch, int n){
        int last = n-1,i=n-2;
        boolean violate = false;
        while(i>=0){
            if(ch[last] > ch[i]){
                violate=true;
                break;
            }
            last = i;
            i--;
        }
        if(violate){
           for(int j=n-1;j>i;j--){
               if(ch[j] > ch[i]){
                   char temp = ch[i];
                   ch[i] = ch[j];
                   ch[j] = temp;
                   break;
               }
           }
            Arrays.sort(ch, i+1, n);
            String s = new String(ch);
            if((ch[n-1] - '0') %2 ==0) {
                ans = s;
                return true;
            }
            return findEven(ch, n);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            char ch[] = br.readLine().toCharArray();
            boolean flag = findEven(ch, ch.length);
            if(flag)
                System.out.println(ans);
            else
                System.out.println(-1);
        }

    }
}
