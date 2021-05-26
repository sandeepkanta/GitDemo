package com.practice.arrays;

public class MaxProductSubArray {

    long maxProduct(int[] arr, int n)
    {
        long max_product_so_far = arr[0], min_product_so_far=arr[0], max_product=arr[0];
        int i=1;
        while(i < n)
        {
            if(arr[i] == 0) {
                if(i < n-1){
                    max_product_so_far = arr[i+1];
                    min_product_so_far = arr[i+1];
                }else{
                    max_product_so_far = 0;
                    min_product_so_far = 0;
                }
                i++;

            }else {
                 if(arr[i] < 0){
                     long temp = max_product_so_far;
                     max_product_so_far = min_product_so_far;
                     min_product_so_far = temp;
                 }
                 max_product_so_far = Math.max(arr[i], max_product_so_far * arr[i]);
                 min_product_so_far = Math.min(arr[i], min_product_so_far * arr[i]);
            }
            if(max_product_so_far > max_product)
                max_product = max_product_so_far;
            i++;

        }
        return max_product;
    }

    public static void main(String[] args) {
        MaxProductSubArray obj = new MaxProductSubArray();
        int arr[] = {90,91,-91,91,-91,-90,90,90,-90,-90};
        obj.maxProduct(arr, 10);
    }
}
