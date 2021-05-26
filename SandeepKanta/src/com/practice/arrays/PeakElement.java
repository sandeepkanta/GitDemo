package com.practice.arrays;

public class   PeakElement {

    public int peakElement(int[] arr,int n)
    {
        int l=0, h=n-1;
        while(l<= h){
            int mid = (l+h)/2;
            if( (mid-1 < 0 || (mid-1 >=0 && arr[mid-1] <=arr[mid])) && (mid+1>= n || (mid+1<n && arr[mid+1]<=arr[mid]))){
                return mid;
            }
            else if(mid-1 >=0 && arr[mid-1] >=arr[mid]){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakElement obj = new PeakElement();
        int arr[] = {1,2,3};
        obj.peakElement(arr, 3);
    }
}
