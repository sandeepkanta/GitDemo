package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FillArrayWith1 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().split("\\s+");
            int arr[] = new int[n];
            int count0=0;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
                if(arr[i] == 0)
                    count0+=1;
                else
                    q.add(i);
            }

            int count=0;
            while (!q.isEmpty() && count0 > 0){
                int m = q.size();
                count+=1;
                while(m-- > 0){
                    int index = q.remove();
                    if(index-1 >= 0 && arr[index-1] == 0) {
                        arr[index-1] = 1;
                        q.add(index - 1);
                        count0--;
                    }
                    if(index+1 < n && arr[index+1] == 0){
                        arr[index+1] = 1;
                        q.add(index+1);
                        count0--;
                    }
                }
            }
            if(count0 == 0)
                System.out.println(count);
            else
                System.out.println(-1);

        }
    }
}
