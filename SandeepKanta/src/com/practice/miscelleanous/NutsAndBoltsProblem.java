package com.practice.miscelleanous;

import java.util.Arrays;

public class NutsAndBoltsProblem {

    int partition(char pivot, char[] arr, int i, int j){
        int m = i;
        while(i <= j){
            if(arr[i] > pivot){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }else {
                if(arr[i] == pivot) {
                    char temp = arr[m];
                    arr[m] = arr[i];
                    arr[i] = temp;
                }
                i++;
            }
        }
        char temp = arr[j];
        arr[j] = arr[m];
        arr[m] = temp;
        return j;

    }

    void sort(char nuts[], char bolts[], int i,  int j){
        if(i < j) {
            int index = partition(bolts[j], nuts, i, j);
            partition(nuts[index], bolts, i, j);
            sort(nuts, bolts, 0, index - 1);
            sort(nuts, bolts, index + 1, j);
        }
    }

    void matchPairs(char nuts[], char bolts[], int n) {

        char [] nuts1 = {'#', '%', '$', '@', '^'};
        char [] bolts1 = { '@', '$', '#', '%', '^'};
        sort(nuts1, bolts1, 0, 4);
        System.out.println("raju");
    }

    public static void main(String[] args) {
        NutsAndBoltsProblem x = new  NutsAndBoltsProblem();
        x.matchPairs(null, null, 4);

    }
}
