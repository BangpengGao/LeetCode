package com.bigbang.sorting.algorithm;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 10:03
 */
public class Sort {
    public <T> void sort(T[] arr) {
    }

    /**
     * 该比较方法，自写
     *
     * @param T1
     * @param T2
     * @param <T>
     * @return
     */
    public <T> boolean compare(T T1, T T2) {
        return T1.equals(T2);
    }
}
