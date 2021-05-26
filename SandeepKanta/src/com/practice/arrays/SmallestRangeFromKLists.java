package com.practice.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestRangeFromKLists {

    static class Data {
        int row;
        int col;

        Data(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[] findSmallestRange(int[][] arr, int n, int k) {
        Queue<Data> queue = new PriorityQueue<Data>(k, (Data data1, Data data2) -> arr[data1.row][data1.col] - arr[data2.row][data2.col]);
        int max = Integer.MIN_VALUE, p = 0, q = n;
        for (int i = 0; i < k; i++) {
            max = Math.max(arr[i][0], max);
            queue.add(new Data(i, 0));
        }
        while (true) {
            Data data = queue.remove();
            int min = arr[data.row][data.col];
            if (max - min < q - p) {
                p = min;
                q = max;
            }
            if (data.col + 1 >= n)
                break;
            else {
                max = Math.max(max, arr[data.row][data.col + 1]);
                queue.add(new Data(data.row, data.col + 1));
            }
        }
        int result[] = new int[2];
        result[0] = p;
        result[1] = q;
        return result;
    }
}
