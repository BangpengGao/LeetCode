package com.bigbang.sorting.algorithm;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/15
 * @since 1.0.0
 */
public class ShellSort extends Sort {
    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int value = arr[i], j;
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
