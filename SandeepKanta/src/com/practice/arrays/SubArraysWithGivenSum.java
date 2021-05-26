package com.practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//includes negative numbers as well
public class SubArraysWithGivenSum {

    public static int subArraySum(int[] arr, int n, int sum)
    {
        int min_neg=0;
        for(int i=0;i<n;i++){
            if(arr[i] < min_neg)
                min_neg = arr[i];
        }
        min_neg = Math.abs(min_neg);
        for(int i=0;i<n;i++)
            arr[i]+=min_neg;
        int count =0, curr_sum=0, j=0,i=0;
        while(j<=i)
        {
            curr_sum+=arr[i];
            int m = (i-j+1) * min_neg;
            while (j < i-1 && curr_sum > (sum + m)){
                   curr_sum-=arr[j++];
                   m=(i-j+1) * min_neg;
            }
            if(curr_sum == sum + m) {
                count++;
                curr_sum-=arr[j--];
            }
            if(i < n)
                i++;
        }
        return count;
    }

    public static int subArraySum1(int[] arr, int n, int sum){
        int minEle = Integer.MAX_VALUE;

        // Find minimum element in the array
        for (int i = 0; i < n; i++)
            minEle = Math.min(arr[i], minEle);

        // Initialize curr_sum as value of
        // first element and starting point as 0
        int curr_sum = arr[0] + Math.abs(minEle);
        int start = 0, i, count=0;

        // Starting window length will be 1,
        // For generating new target sum,
        // add abs(minEle) to sum only 1 time
        int targetSum = sum;

        // Add elements one by one to curr_sum
        // and if the curr_sum exceeds the
        // updated sum, then remove starting element
        for (i = 1; i <= n; i++)
        {

            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum - (i - start) *
                    Math.abs(minEle) > targetSum &&
                    start < i - 1)
            {
                curr_sum = curr_sum - arr[start] -
                        Math.abs(minEle);
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum - (i - start) *
                    Math.abs(minEle) == targetSum)
            {
                count++;
            }

            // Add this element to curr_sum
            if (i < n)
            {
                curr_sum = curr_sum + arr[i] +
                        Math.abs(minEle);
            }
        }

         return count;
    }

    public static void main(String[] args) {
        int [] arr = {10,2,-2,-20,10};
        subArraySum(arr, 5, -10);
    }
}
