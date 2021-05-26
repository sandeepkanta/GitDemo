package com.practice.arrays;


import java.util.*;

public class RotatedSortedArraySearch {

    public int binarySearch(final List<Integer> A, int B, int low, int high, int n){
        if(low > high)
            return -1;

        int mid = (low+high)/2;

        if(A.get(mid) == B)
            return mid;

        if(A.get(low) <= A.get(mid)){
            if(B >= A.get(low) && B <= A.get(mid)){
                return binarySearch(A, B, low, mid-1, n);
            }
            return binarySearch(A, B, mid+1, high, n);
        }
        if((mid +1 < n) && B >= A.get(mid+1) && B <= A.get(high))
            return binarySearch(A,B, mid+1, high, n);
        return binarySearch(A, B, low, mid-1, n);
    }

    public int search(final List<Integer> A, int B) {
        return  binarySearch(A, B, 0, A.size()-1, A.size());
    }

    public static void main(String[] args) {
        int arr[] = { 9, 10, 11, 12, 14, 15, 17, 19, 24, 25, 30, 39, 40, 44, 46, 48, 51, 53, 54, 56, 59, 60, 69, 70, 73, 75, 80, 87, 88, 89, 92, 93, 97, 99, 104, 107, 109, 110, 111, 117, 123, 124, 125, 126, 127, 128, 135, 136, 137, 141, 148, 153, 154, 161, 166, 167, 169, 175, 177, 180, 181, 182, 185, 186, 189, 193, 198, 202, 1, 2, 6, 7 };
        RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i< arr.length;i++)
            list.add(arr[i]);
        System.out.println(obj.search(list, 198));

    }

}
