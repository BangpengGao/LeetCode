package com.bigbang.sorting.algorithm;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 9:58
 */
public class BubbleSort extends Sort {

    /**
     * 冒泡排序
     *
     * @param arr
     * @param <T>
     */
    public <T> void sort(T[] arr) {
        T temp;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (compare(arr[j], arr[j + 1])) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
    }
}
