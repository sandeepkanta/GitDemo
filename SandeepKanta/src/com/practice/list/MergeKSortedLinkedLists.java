package com.practice.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    Node mergeKList(Node[] a, int N)
    {
      var q = new PriorityQueue<>(a.length, (Node n1, Node n2) -> n1.data - n2.data);
      Arrays.stream(a).forEach(head -> q.add(head));
      Node result =  null, curr = null;
      while (!q.isEmpty()){
          Node node = q.remove();
          if(result == null){
              result = node;
              curr = node;
          }else{
              curr.next = node;
              curr = node;
          }
          if(node.next!=null){
              q.add(node.next);
          }
      }
      return result;

    }
}
