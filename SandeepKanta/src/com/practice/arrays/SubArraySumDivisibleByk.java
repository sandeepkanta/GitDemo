package com.practice.arrays;

public class SubArraySumDivisibleByk {

    long subCount(long arr[] ,int n,int k)
    {
        long sum=0;
        int mod[] = new int[k];
        long total = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            mod[(int)(((sum%k)+k)%k)]++;
        }

        for(int i=0;i<k;i++){
            total += (mod[i]*(mod[i]-1)/2);
        }
        return total+mod[0]-1;
    }

    public static void main(String[] args) {
        long arr[] = {2,2,2,2,2,2};
        var obj = new SubArraySumDivisibleByk();
        obj.subCount(arr, arr.length, 2);
    }
}
