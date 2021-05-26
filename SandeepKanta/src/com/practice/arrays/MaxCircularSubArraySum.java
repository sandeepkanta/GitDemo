package com.practice.arrays;

public class MaxCircularSubArraySum {

    // Function to find circular subarray with maximum sum
    // a: input array
    // n: size of array
    static int circularSubarraySum(int a[], int n) {
        int arr_sum=a[0], max_so_far=a[0], curr_max=a[0], min_so_far=a[0], curr_min=a[0];
        for(int i=1;i<n;i++){
            arr_sum +=a[i];
            if(curr_max + a[i] < a[i])
                curr_max = a[i];
            else
                curr_max+=a[i];

            if(curr_min + a[i] < a[i])
                curr_min+=a[i];
            else
                curr_min=a[i];
            max_so_far = Math.max(max_so_far, curr_max);
            min_so_far = Math.min(min_so_far, curr_min);
        }
        if(min_so_far == arr_sum)
            return max_so_far;
        return Math.max(max_so_far, arr_sum-min_so_far);

    }

    public static void main(String[] args) {
        int arr[]={10,-3,-4,7,6,5,-4,-1};
        circularSubarraySum(arr, 8);
    }
}
