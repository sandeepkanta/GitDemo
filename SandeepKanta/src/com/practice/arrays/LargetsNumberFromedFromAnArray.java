package com.practice.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargetsNumberFromedFromAnArray {

    static String printLargest(String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
               char ch2[] = s2.toCharArray();
               char ch1[] = s1.toCharArray();
               int i=0;
               while(i < ch1.length && i < ch2.length)
               {
                   if(ch1[i] == ch2[i])
                        i++;
                   else if(ch1[i] > ch2[i])
                      return -1;
                   else
                       return 1;
               }
               if(i < ch1.length){
                   return compare(s1.substring(i, ch1.length), s2);
               }

               if(i < ch2.length){
                   return compare(s1, s2.substring(i, ch2.length));
               }
               return 0;
            }
        });
        String result = "";
        for(int i=0;i<arr.length;i++){
            result+=arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String arr[]= {"32", "323"};
        printLargest(arr);
    }
}
