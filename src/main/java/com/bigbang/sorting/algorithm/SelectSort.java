package com.bigbang.sorting.algorithm;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/16
 * @since 1.0.0
 */
public class SelectSort extends Sort {
    @Override
    public <T> void sort(T[] arr) {
        T temp = null;
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (compare(arr[j], arr[i]))
                    idx = j;
            if (idx != i) {
                temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    /**
     * 该比较方法，自写
     *
     * @param T1
     * @param T2
     * @param <T>
     * @return
     */
    @Override
    public <T> boolean compare(T T1, T T2) {
        return T1.equals(T2);
    }
}
