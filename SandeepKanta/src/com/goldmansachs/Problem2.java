package com.goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    static Map<Integer,Integer> memoizedNumberOfWays = new HashMap<>();
    static int noOfWaysToDrawTheGame(int totalScore) {
        if(totalScore%2==1 || totalScore<0){
            return 0;
        }
        if(totalScore==0){
            return 1;
        }
        if(memoizedNumberOfWays.containsKey(totalScore)){
            return memoizedNumberOfWays.get(totalScore);
        }
        int totalNumberOfWays = noOfWaysToDrawTheGame(totalScore-2)+noOfWaysToDrawTheGame(totalScore-4)+noOfWaysToDrawTheGame(totalScore-6);
        memoizedNumberOfWays.put(totalScore,totalNumberOfWays);
        return totalNumberOfWays;
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysToDrawTheGame(6));
    }
}
