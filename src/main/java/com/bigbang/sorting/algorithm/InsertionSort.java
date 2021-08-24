package com.bigbang.sorting.algorithm;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 10:02
 */
public class InsertionSort extends Sort {

    /**
     * 插入排序
     *
     * @param arr
     * @param <T>
     */
    @Override
    public <T> void sort(T[] arr) {
        T temp;
        for (int a = 1; a < arr.length; a++)
            for (int b = a; b > 0; b--) {
                if (compare(arr[b], arr[b - 1])) {
                    temp = arr[b];
                    arr[b] = arr[b - 1];
                    arr[b - 1] = temp;
                }
            }
    }

}
