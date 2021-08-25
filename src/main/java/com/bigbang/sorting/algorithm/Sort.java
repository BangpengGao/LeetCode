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
    /*
    基于对比的排序算法：
        冒泡排序
        快排排序
        插入排序
        希尔排序
        堆排序
        选择排序
        归并排序
    非基于比较的排序算法：
        基数排序
        桶排序
        计数排序
     */


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
