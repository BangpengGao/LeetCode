package com.bigbang.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 10:10
 */
public class BasicSort extends Sort {

    /**
     * 基数排序
     *
     * @param arr
     * @param <T>
     */
    @Override
    public <T> void sort(T[] arr) {

    }

    public void sort(int[] arr) {
        int max = 0;
        for (int a : arr) {
            max = Math.max(max, a);
        }
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }

        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> q = new ArrayList<>();
            queue.add(q);
        }

        for (int i = 0; i < times; i++) {
            for (int k : arr) {
                int x = (int) (k % Math.pow(10, i + 1) / Math.pow(10, i));
                ArrayList<Integer> q = queue.get(x);
                q.add(k);
            }

            int count = 0;
            for (int z = 0; z < 10; z++) {
                while (queue.get(z).size() > 0) {
                    ArrayList<Integer> c = queue.get(z);
                    arr[count] = c.get(0);
                    c.remove(0);
                    count++;
                }
            }
        }
    }
}
