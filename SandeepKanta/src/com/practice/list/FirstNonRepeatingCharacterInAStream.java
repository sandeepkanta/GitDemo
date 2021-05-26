package com.practice.list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;

public class FirstNonRepeatingCharacterInAStream {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[26];
            String str [] = br.readLine().split(" ");
            List<Character> sequence = new LinkedList<>();
            for(int i =0;i<n;i++){
                int ch = str[i].charAt(0);
                if(arr[ch - 96] == 0) {
                    sequence.add((char) ch);
                    arr[ch - 96]++;
                }
                else{
                    var itr = sequence.listIterator();
                    while (itr.hasNext()){
                        char ele = itr.next();
                        if(ele == ch){
                            itr.remove();
                        }
                    }
                }
                if(sequence.isEmpty())
                    System.out.print(-1 + " ");
                else
                    System.out.print(sequence.get(0) + " ");
            }
        }

    }

}
