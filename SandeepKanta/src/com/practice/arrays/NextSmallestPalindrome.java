package com.practice.arrays;

import java.util.Vector;

public class NextSmallestPalindrome {

    boolean checkForPalindrome(int num[], int n){
        int i=0, j=n-1;
        while(i < j){
            if(num[i] != num[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    int generateNextPalindromeUtils(int num[], int carry, int i, int j){
        if(i <= j){
            int value = generateNextPalindromeUtils(num, carry, i+1, j-1);
            if(value == 0){
               num[j] = num[i];
               return 0;
            }else if(value == 1){
                int t = num[i]+1;
                num[i] = t%10;
                num[j] = num[i];
                return t/10;
            }
            return value;
        }
        return carry;
    }

    Vector<Integer> generateNextPalindrome(int num[], int n)
    {
        int i=0, j=n-1;
        if(n%2 == 0){
            i=n/2-1;
            j=n/2;
        }else{
            i =n/2-1;
            j = n/2+1;
        }
        boolean addCarry = false;
        Vector<Integer> result = new Vector<>();
        while (i>=0 && j < n){
            if(num[i] < num[j]){
               addCarry = true;
               break;
            }else if(num[i] > num[j]){
                break;
            }
            i--;
            j++;
        }

        int carry =-1;
        if(addCarry){
            carry = generateNextPalindromeUtils(num, 1, 0, n-1);
        }else{
             carry = generateNextPalindromeUtils(num, 0, 0, n-1);
        }
        if(carry == 1){
          result.add(1);
          for(int k=0;k<n-1;k++)
              result.add(0);
          result.add(1);
        }else {
            for(int k=0;k<n;k++){
                result.add(num[k]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var obj = new NextSmallestPalindrome();
        int [] arr={1,5,3,4,6,7,1,7,4,2,7,3,5,4,7,2,6};
        obj.generateNextPalindrome(arr, arr.length);
    }
}
