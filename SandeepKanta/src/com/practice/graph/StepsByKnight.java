package com.practice.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

    static class Coordinate{
        int x;
        int y;
        int dist;
        Coordinate(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static boolean boundaryCondition(int i, int j, int n){
        if(i < 1 || i > n || j < 1 || j > n)
            return true;
        return false;
    }

    public static int findMinSteps(boolean[][] visited, int sx, int sy, int dx, int dy, int n) {


        int[] stepsx = {1, -1, 1, -1, 2, -2, 2, -2};
        int[] stepsy = {2, 2, -2, -2, 1, -1, -1, 1};
        visited[sx][sy] = true;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(sx, sy, 0));
        int result = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            var coordinate = queue.remove();
            for(int i=0;i<8;i++){
                if(coordinate.x == dx && coordinate.y == dy && result < coordinate.dist){
                    result = coordinate.dist;
                    break;
                }
                int x = coordinate.x + stepsx[i];
                int y = coordinate.y + stepsy[i];
                if(!boundaryCondition(x, y, n) && !visited[x][y])
                {
                    visited[x][y] = true;
                    queue.add(new Coordinate(x, y, coordinate.dist + 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            boolean[][] visited = new boolean[n + 1][n + 1];
            int[][] dp = new int[n + 1][n + 1];
            System.out.println(findMinSteps(visited, i, j, p, q, n));
        }
    }
}
