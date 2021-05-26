package com.practice.arrays;

import java.util.Arrays;
import java.util.Stack;

public class PairsWithPositiveNegativeValues {

    public static  long[] PosNegPair(long arr[], long n)
    {
        Arrays.sort(arr);
        int i=0, j=(int)n-1;
        var stack = new Stack<Long>();
        while(i < j){
            if(arr[i] < 0 && arr[j] > 0 && Math.abs(arr[i]) == Math.abs(arr[j])){
                stack.push(arr[j]);
                i++;
                j--;
            }else if(Math.abs(arr[i]) < Math.abs(arr[j])){
                j--;
            }else{
                i++;
            }
        }
        long result[] = new long[2*stack.size()];
        i=0;
        while(!stack.isEmpty()){
            result[i++]= -(stack.pop());
            result[i] = Math.abs(result[i-1]);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        long [] arr = {1, -3, 2,3,6,-1};
        PosNegPair(arr, arr.length);
        String s="";

    }
}
