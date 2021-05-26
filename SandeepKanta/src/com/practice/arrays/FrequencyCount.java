package com.practice.arrays;

public class FrequencyCount {

    public static void frequencycount(int A[], int n)
    {
        for(int i=0;i<n;i++){
            int x = A[i];
            if(x > n)
                x=x%(n+1);
            x-=1;
            A[x]+=n+1;
        }
        for(int i=0;i<n;i++){
            System.out.print(A[i]/(n+1) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []A={4,5,2,5,1};
        frequencycount(A, 5);
    }
}
