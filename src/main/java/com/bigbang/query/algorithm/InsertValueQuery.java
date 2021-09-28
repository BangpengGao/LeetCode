package com.bigbang.query.algorithm;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/28
 * @since 1.0.0
 */
public class InsertValueQuery implements Query {
    @Override
    public <T> int query(T[] array, T data) {
        return 0;
    }

    public int query(int[] array, int start, int end, int data) {
        if (start > end || data < array[0] || data > array[array.length - 1])
            return -1;

        // 插值查找的关键，是计算出mid
        int mid = start + (end - start) * (data - array[start]) / (array[end] - array[start]);
        int midValue = array[mid];

        if (midValue > data) {
            return query(array, start, mid - 1, data);
        } else if (midValue < data) {
            return query(array, mid + 1, end, data);
        } else {
            return mid;
        }
    }
}
