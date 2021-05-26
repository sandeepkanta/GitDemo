package com.practice.arrays;

public class MergeWithOutExtraSpace {
    public static int findIndex(int i, int j , int x, int []arr){
        int index=i-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] > x){
                j = mid-1;
            }else{
                index = mid;
                i = mid+1;
            }
        }
        return index;
    }


    public static void merge(int arr1[], int arr2[], int m, int n)
    {
        int i=0,j=0;
        while(i < m && j < n){
            if(arr1[i] > arr2[j]){
                int t = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = t;
                t = arr2[j];
                int k=j+1;
                for(;k<n;k++){
                    if(arr2[k] < t){
                        arr2[k-1] = arr2[k];
                    }else{
                        break;
                    }
                }
                if(k < n)
                    arr2[k-1] = t;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int []arr1={1,3,5,7};
        int []arr2={0,2,6,8,9};
        merge(arr1, arr2, 4,5);

    }
}
