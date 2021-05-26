package com.practice.arrays;

import java.util.ArrayList;

public class LargestDistanceBetweenNodesOfATree {

    int max = Integer.MIN_VALUE;

    public int solveUtils(ArrayList<Integer>[] arr, int index, int root)
    {
        ArrayList<Integer> children = arr[index];
        if(children==null)
            return 0;
        int max1 =0, max2 =0;
        for(int i: children)
        {
            int subTreeHeight = solveUtils(arr, i, root) + 1;
            if(max1 <= subTreeHeight){
                max2 = max1;
                max1 = subTreeHeight;
            }else if(max2 < subTreeHeight){
                max2 = subTreeHeight;
            }
            max = Math.max(max, max1+max2);

        }
        return Math.max(max1, max2);
    }

    public int solve(ArrayList<Integer> A)
    {
        int n = A.size();
        ArrayList<Integer> [] arr = new ArrayList[n];
        int root=0;
        for(int i=0;i<n;i++){
            if(A.get(i) == -1) {
                root = i;
                continue;
            }
            if(arr[A.get(i)] == null)
                arr[A.get(i)] = new ArrayList<Integer>();
            arr[A.get(i)].add(i);
        }
        solveUtils(arr, root, root);
        return max;
    }

    public static void main(String[] args) {
        var obj = new LargestDistanceBetweenNodesOfATree();
        int arr[] = {-1, 0, 1, 1, 3, 0, 4, 0, 2, 8, 9, 0, 4, 6, 12, 14, 7, 9, 6, 4, 14, 13, 1, 9, 16, 17, 17, 0, 21, 10, 13, 14, 25, 28, 27, 0, 35, 20, 34, 23, 37, 3, 6, 25, 30, 22, 15, 37, 8, 6, 11, 22, 50, 12, 4, 2, 54, 23, 18, 52, 34, 49, 61, 8, 15, 63, 31, 51, 48, 41, 26, 37, 30, 15, 59, 12, 0, 40, 37, 73, 32, 19, 70, 29, 8, 21, 83, 33, 7, 13, 12, 82, 43, 86, 38, 31, 1, 84, 62, 83};
        var list = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)
            list.add(arr[i]);
        System.out.println(obj.solve(list));
    }
}
