package com.practice.arrays;

import java.util.Vector;

public class Complement {

    static Vector<Integer> findRange(String str, int n) {

        Vector<Integer> result = new Vector<Integer>();
        int p=-1,q=-1, count=0, max_i=-1, max_j=-1, max = 0;

        for(int i=n-1;i>=0;i--)
        {
            if(str.charAt(i) == '0'){
                count++;
                if(p==-1){
                    p=i;
                    q=i;
                }else{
                    p=i;
                }
            }else{
                if(count >= max){
                    max_i = p;
                    max_j = q;
                    max = count;
                }
                count--;
                if(count <=0){
                    p=-1;
                    q=-1;
                    count=0;
                }
            }
        }
        if(count >= max){
            max_i = p;
            max_j = q;
        }

        if(max==0)
            result.add(-1);
        else{
            result.add(max_i+1);
            result.add(max_j+1);
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "100111";
        findRange(s, s.length());
    }
}
