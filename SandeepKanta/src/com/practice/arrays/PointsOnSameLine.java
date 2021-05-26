package com.practice.arrays;


import java.util.HashMap;

public class PointsOnSameLine {

    int gcd(int a, int b){
         if(a == 0)
             return b;
         if(b == 0)
             return a;
         if(a > b)
             return gcd(a-b, b);
         return gcd(a, b-a);
    }

    int noOfPoints(int X[],int Y[],int N) {
        int max=0;
        var slopeMap = new HashMap<pair, Integer>();
        for(int i=0;i<N;i++){
            int overLapPoints=0, verticalPoints=0, currMax=0;
            for(int j=i+1;j<N;j++)
            {
                if(X[i] == X[j] && Y[i] == Y[j]){
                    overLapPoints++;
                }else if(X[i] == X[j]){
                    verticalPoints++;
                }else{
                   int yDiff = Y[j] - Y[i];
                   int xDiff = X[j] - X[i];
                   int gcd = gcd(yDiff, xDiff);
                   yDiff/=gcd;
                   xDiff/=gcd;
                   var pair = new pair(xDiff,yDiff);
                   slopeMap.put(pair, slopeMap.getOrDefault(pair, 0) + 1);
                   currMax=Math.max(currMax, slopeMap.get(pair));
                }
                currMax = Math.max(currMax, verticalPoints);
            }
            max = Math.max(max, currMax+overLapPoints+1);
            slopeMap.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        int x[] = {0, 1, -1};
        int y[] = {0, 1, -1};
        PointsOnSameLine obj = new PointsOnSameLine();
        obj.noOfPoints(x, y, x.length);
    }
}
