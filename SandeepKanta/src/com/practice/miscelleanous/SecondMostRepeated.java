package com.practice.miscelleanous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SecondMostRepeated {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String str[]=br.readLine().split("\\s+");
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsKey(str[i])){
                    map.put(str[i], map.get(str[i]) + 1);
                }else{
                    map.put(str[i], 1);
                }
            }
            int first=Integer.MIN_VALUE, second=Integer.MIN_VALUE;
            String f="", s="";
            for (String key: map.keySet()){
                int value = map.get(key);
                if( value >= first){
                    second = first;
                    first = value;
                    s=f;
                    f=key;
                }else if(value >= second){
                    second = value;
                    s=key;
                }
            }
            System.out.println(s);
        }

    }

}
