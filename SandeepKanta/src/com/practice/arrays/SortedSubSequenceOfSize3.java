package com.practice.arrays;

import java.util.ArrayList;

public class SortedSubSequenceOfSize3 {

    ArrayList<Integer> find3Numbers(ArrayList<Integer> a, int n) {
        int arr[] = new int[n];
        ArrayList<Integer> result = new ArrayList<Integer>();
        int min=a.get(0);
        arr[0]=-1;
        for(int i=1;i<n;i++){
            if(min < a.get(i))
                arr[i] = min;
            else {
                arr[i] = -1;
                min = a.get(i);
            }
        }
        int max = a.get(n-1);
        for(int i=n-2;i>0;i--){
            if(max > a.get(i)){
                if(arr[i]!=-1) {
                    result.add(arr[i]);
                    result.add(a.get(i));
                    result.add(max);
                    break;
                }
            }else{
                max = a.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var obj = new SortedSubSequenceOfSize3();
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(1);
        data.add(1);
        data.add(3);
        obj.find3Numbers(data, 5);
    }
}
