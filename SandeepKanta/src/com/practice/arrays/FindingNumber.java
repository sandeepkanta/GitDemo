package com.practice.arrays;

public class FindingNumber {

    static int findMaximum(int[] arr, int low, int high){
        if(low == high)
            return low;
        if(high == low+1 && arr[low] >= arr[high])
            return low;

        if(high == low+1 && arr[low] < arr[high])
            return high;

        int mid = (low+high)/2;

        if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1])
            return mid;
        if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1])
            return findMaximum(arr, mid+1, high);

        return findMaximum(arr, low, mid-1);

    }

    static int findNumber(int[] arr, int n, int k) {
        int l=0, h=n-1, index=-1;
        index = findMaximum(arr, l, h);
        l=0;
        h=index;
        int result=-1;
        while (l<=h){
            int mid=(l+h)/2;
            if(arr[mid] == k) {
                result = mid;
                break;
            }
            else  if(arr[mid] > k)
                h=mid-1;
            else
                l=mid+1;
        }
        l=index+1;
        h=n;
        while (l<=h){
            int mid=(l+h)/2;
            if(arr[mid] == k) {
                result = mid;
                break;
            }
            else if(arr[mid] > k)
                l=mid+1;
            else
                h=mid-1;
        }

        return result;

    }

    public static void main(String[] args) {
        int arr[]= {5,6,7,8,9,10,3,2,1};
        findNumber(arr, arr.length, 5);
    }
}
