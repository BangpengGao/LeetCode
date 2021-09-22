package com.bigbang.query.algorithm;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public class BinaryQuery implements Query {
    /**
     * 二分查找
     * 二分查找的前提是array必须为有序的
     *
     * @param array 有序数组
     * @param data
     * @param <T>
     * @return
     */
    @Override
    public <T> int query(T[] array, T data) {
        int low = 0, hi = array.length - 1;
        while (low < hi) {
            int mid = (low + hi) >>> 1;

            if (compare(array[mid], data)) {
                low = mid + 1;
            } else if (compare(data, array[mid])) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 自定义比较方法
     *
     * @param data1
     * @param data2
     * @param <T>
     * @return
     */
    public static <T> boolean compare(T data1, T data2) {
        return data1.equals(data2);
    }
}
