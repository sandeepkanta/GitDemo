package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NearestMultipleOf10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String s=br.readLine();
            int n = s.length();
            char[] ch = s.toCharArray();
            String result = "";
            if(Integer.parseInt(String.valueOf(ch[n-1])) <=5){
                ch[n-1] = '0';
                result = new String(ch);
            }else{
                int i=n-2, carry=1;
                ch[n-1] = '0';
                while(i>=0 && carry > 0){
                    int x = Integer.parseInt(String.valueOf(ch[i])) + carry;
                    ch[i] = (char)(x%10 + '0');
                    carry = x/10;
                    i--;
                }
                if(carry == 1)
                    result ="1"+ (new String(ch));
                else
                    result = new String(ch);
            }
            System.out.println(result);
        }
    }
}
