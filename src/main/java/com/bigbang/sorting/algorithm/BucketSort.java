package com.bigbang.sorting.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/20
 * @ Time 15:18
 */
public class BucketSort {
    /**
     * 桶排序
     *
     * @param arr
     */
    public static void bucketSortFloat(float[] arr) {
        int n = arr.length;
        if (n < 1) return;

        // 1) 创建空的buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];
        for (int i = 0; i < n; i++)
            buckets[i] = new Vector<>();

        // 2) 将原始数组塞入buckets中
        for (float v : arr) {
            float idx = v * n;
            buckets[(int) idx].add(v);
        }

        // 3）对桶进行单独排序
        for (int i = 0; i < n; i++)
            Collections.sort(buckets[i]);

        // 4）按顺序从桶中取出数据，即为有序数据
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void bucketSortInteger(int[] arr) {
        int n = arr.length;
        if (n < 1) return;

        int[] buckets = new int[Arrays.stream(arr).max().getAsInt() + 1];
        Arrays.fill(buckets, Integer.MIN_VALUE);
        for (int i : arr)
            buckets[i] = i;

        int index = 0;
        for (int bucket : buckets) if (bucket != Integer.MIN_VALUE) arr[index++] = bucket;
    }

    public static void main(String[] args) {
        float arr[] = {(float) 0.897, (float) 0.565,
                (float) 0.656, (float) 0.1234,
                (float) 0.665, (float) 0.3434};
        bucketSortFloat(arr);
        System.out.println(Arrays.toString(arr));

        int[] arrInt = {1, 8, 3, 7, 0, 9, 4, 5};
        bucketSortInteger(arrInt);
        System.out.println(Arrays.toString(arrInt));
    }
}
