package com.practice.arrays;

public class MooresVotingAlgorithm {

    static int majorityElement(int arr[], int n)
    {
        int maj_count=1,maj_index=0;
        for(int i=1;i<n;i++){
            if(arr[maj_index] == arr[i]){
                maj_count++;
            }else{
                maj_count--;
                if(maj_count==0)
                {
                    maj_count=1;
                    maj_index=i;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i] == arr[maj_index])
                count++;
        }
        if(count > n/2)
            return arr[maj_index];
        else
            return -1;
    }
}
