package com.practice.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckMirrorInNAryTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            var str1 = br.readLine().split(" ");
            var str2 = br.readLine().split(" ");
            var arr1 = new int[2 * e + 2];
            var arr2 = new int[2 * e + 2];
            for (int i = 0; i < 2 * e; i++) {
                arr1[i] = Integer.parseInt(str1[i]);
                arr2[i] = Integer.parseInt(str2[i]);
            }
            boolean flag = true;
            int prev = -1;
            var stack = new Stack<Integer>();
            var queue = new LinkedList<Integer>();
            var map = new HashMap<Integer, Integer>();
            for(int j=0;j<2*e+2;j+=2){
                if(!map.containsKey(arr2[j]))
                    map.put(arr2[j], j);
            }
            int j=0;
            for (int i = 0; i < 2 * e + 2; i += 2) {
                if (arr1[i] != prev) {
                    j = map.getOrDefault(arr1[i], -1);
                    if(j == -1){
                        flag = false;
                        break;
                    }
                    while (!stack.isEmpty() && !queue.isEmpty()) {
                        if (stack.pop() != queue.remove())
                            flag = false;
                    }
                    if (!flag)
                        break;
                }
                prev = arr1[i];
                queue.add(arr1[i + 1]);
                stack.push(arr2[j + 1]);
                j+=2;
            }
            if (flag)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
