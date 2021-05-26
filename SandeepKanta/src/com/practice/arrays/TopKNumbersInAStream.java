package com.practice.arrays;

import javax.swing.text.html.HTMLDocument;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKNumbersInAStream {

    static class Data {
        int value, frequency;
        Data(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }

    static ArrayList<Integer> kTop(int[] a, int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
         var map = new HashMap<Integer, Data>();
         var queue = new PriorityQueue<Data>((o1, o2) -> {
             if(o1.frequency < o2.frequency)
                 return o1.frequency-o2.frequency;
             else if(o1.frequency > o2.frequency)
                 return o2.frequency-o1.frequency;
             else {
                 if(o1.value < o2.value)
                   return o2.value - o1.value;
                 return o1.value-o2.value;
             }
         });

         for(int i=0;i<n;i++){
             if(!map.containsKey(a[i])) {
                 map.put(a[i], new Data(a[i], 1));
                 if(queue.size() < k)
                     queue.add(map.get(a[i]));
                 else{
                     if(queue.peek().frequency ==1 && queue.peek().value > a[i]){
                         queue.remove();
                         queue.add(map.get(a[i]));
                     }
                 }
             } else {
                 map.get(a[i]).frequency++;
                 boolean present = queue.remove(map.get(a[i]));
                 if(present)
                     queue.add(map.get(a[i]));
                 else {
                     if(queue.peek().frequency < map.get(a[i]).frequency){
                         queue.remove();
                         queue.add(map.get(a[i]));
                     }
                 }
             }
             int size = result.size();
             for(int p=0;p<queue.size();p++)
                 result.add(0);
             int p = queue.size() -1;
             var itr = queue.iterator();
               while (p >= 0){
                result.set(p+size, itr.next().value);
                p--;
             }
         }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={5, 2, 1, 3, 2};
        kTop(arr, arr.length, 4);
    }
}
