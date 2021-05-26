package com.practice.graph;

import java.util.ArrayList;

public class Dijkstra {

    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        int[] result = new int[V];
        for(int dest=0; dest<V; dest++){
            if(dest == src - 1) {
               result[dest] = 0;
            }else{
                result[dest] = getShortestDistance(src-1,dest,V,g,new boolean[V]);
            }
        }
        return result;
    }

    private static int getShortestDistance(int src, int dest, int V, ArrayList<ArrayList<Integer>> g, boolean[] visited) {
        if(src == dest)
            return 0;
        int result = Integer.MAX_VALUE;
        visited[src] = true;
        for(int j=0;j<V;j++){
            if(!visited[j]) {
                result = Math.min(result, g.get(src).get(j) + getShortestDistance(j, dest, V, g, visited));
            }
        }
        return result;
    }
}
