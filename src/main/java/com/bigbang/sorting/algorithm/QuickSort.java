package com.bigbang.sorting.algorithm;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/20
 * @ Time 15:42
 */
public class QuickSort extends Sort {
    /**
     * 快排
     *
     * @param arr
     * @param low
     * @param high
     * @param <T>
     */
    public <T> void sort(T[] arr, int low, int high) {
        T pivot = null, temp = null;
        int pos, i;
        if (low < high) {
            pos = low;
            pivot = arr[pos];
            for (i = low + 1; i <= high; i++) {
                if (compare(arr[i], pivot)) {
                    pos++;
                    temp = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = temp;
                }
            }
            temp = arr[low];
            arr[low] = arr[pos];
            arr[pos] = temp;

            sort(arr, low, pos - 1);
            sort(arr, pos + 1, high);
        }
    }
}
