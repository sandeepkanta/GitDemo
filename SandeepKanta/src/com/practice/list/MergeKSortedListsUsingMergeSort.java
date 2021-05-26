package com.practice.list;



public class MergeKSortedListsUsingMergeSort {

    Node sortedMerge(Node headA, Node headB)
    {
        if(headA == null) return headB;
        if(headB == null) return headA;

        if(headA.data < headB.data){
            headA.next = sortedMerge(headA.next, headB);
            return headA;
        }else {
            headB.next = sortedMerge(headA, headB.next);
            return headB;
        }
    }

    Node mergeKListUtils(Node arr[], int last){
        while (last!=1){
            int i =0, j = last;
            while (i < j){
                sortedMerge(arr[i], arr[j]);
                i++;
                j--;
            }
            last = j;
        }
        return arr[0];
    }

    Node mergeKList(Node[]a,int N)
    {
        return mergeKListUtils(a, N-1);
    }
}
