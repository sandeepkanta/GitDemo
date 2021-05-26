package com.practice.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class RottenOranges {

    static class Ele{
        int x;
        int y;
        Ele(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            String []str = br.readLine().split(" ");
            int m = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);
            int [][] arr = new int[m][n];
            str = br.readLine().split(" ");
            Queue<Ele> queue = new LinkedList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(str[i*n+j]);
                    if(arr[i][j] == 2){
                        queue.add(new Ele(i,j));
                    }
                }
            }
            int posx[] = {-1,1,0,0};
            int posy[] = {0,0,-1,1};

            int count=0;
            while (!queue.isEmpty()){
                int size = queue.size();
                boolean foundGoodOrange=false;
                while (size-- > 0){
                    Ele ele = queue.remove();
                    for(int i=0;i<posx.length;i++){
                        int x = ele.x+posx[i];
                        int y = ele.y+posy[i];
                        if(x>=0 && x<m && y>=0 && y<n && arr[x][y] == 1){
                            foundGoodOrange=true;
                            arr[x][y] = 2;
                            queue.add(new Ele(x,y));
                        }
                    }
                }
                if(foundGoodOrange)
                    count++;
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j] == 1){
                        count = -1;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
