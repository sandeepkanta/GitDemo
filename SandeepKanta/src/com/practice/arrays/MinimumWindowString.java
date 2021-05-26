package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {

    public String minWindow(String s, String t)
    {
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i=0;i<t.length();i++)
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0)+1);
        int formed =0;
        Map<Character, Integer> dictS = new HashMap<>();
        int l=0,r=0, result = Integer.MAX_VALUE, min_i=0,min_j=0;
        while (l <= r)
        {
            if(formed == t.length()){
                if(result > r-l){
                    result =  r-l;
                    min_i = l;
                    min_j = r;
                }

                 char chInS = s.charAt(l++);
                 if(dictS.containsKey(chInS)) {
                     dictS.put(chInS, dictS.get(chInS) - 1);
                     if (dictS.get(chInS) < dictT.get(chInS))
                         formed--;
                 }
            }else if(r < s.length()){
                char chInS = s.charAt(r++);
                if(dictT.containsKey(chInS)){
                    if(dictT.get(chInS) > dictS.getOrDefault(chInS, 0))
                       formed++;
                    dictS.put(chInS, dictS.getOrDefault(chInS, 0)+1);
                }
            }else{
                break;
            }
        }
        return s.substring(min_i, min_j);
    }

    public static void main(String[] args) {
        var obj = new MinimumWindowString();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }
}
