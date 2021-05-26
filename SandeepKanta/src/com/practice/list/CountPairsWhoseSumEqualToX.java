package com.practice.list;

import java.util.Collections;
import java.util.LinkedList;

public class CountPairsWhoseSumEqualToX {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                                 int x) {

        Collections.sort(head1);
        Collections.sort(head2, Collections.reverseOrder());
        var itr1 = head1.iterator();
        var itr2 = head2.iterator();
        int count =0;
        Integer num1 = null, num2=null;
        while(itr1.hasNext() && itr2.hasNext())
        {
           if(num1 == null)
               num1 = itr1.next();
           if(num2 == null)
               num2 = itr2.next();
           if(num1 + num2  == x){
               count++;
           }else if(num1 + num2 < x){
               num1 = null;
           }else{
               num2 = null;
           }
        }

        return count;
    }
}
