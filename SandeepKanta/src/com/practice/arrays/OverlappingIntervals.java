package com.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


class pair
{
    int first;
    int second;
    pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pair pair = (pair) o;
        if(pair.first < 0 && pair.second < 0){
            pair.first = Math.abs(pair.first);
            pair.second = Math.abs(pair.second);
        }
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

public class OverlappingIntervals {

    public static ArrayList<pair> overlappedInterval(ArrayList<pair> vec, int n)
    {
        ArrayList<pair> result = new ArrayList<>();
        if(!vec.isEmpty()) {
            Collections.sort(vec, (pair pair1, pair pair2) -> pair1.first - pair2.first);
            int i = vec.get(0).first, j = vec.get(0).second;
            for(int k=1;k<vec.size();k++){
                 int p = vec.get(k).first;
                 int q = vec.get(k).second;
                 if(p <= j){
                     j = Math.max(j,q);
                 }else{
                     result.add(new pair(i, j));
                     i = p;
                     j = q;
                 }
            }
            result.add(new pair(i, j));
        }
        return result;

    }




}
