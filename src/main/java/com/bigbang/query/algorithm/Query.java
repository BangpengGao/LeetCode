package com.bigbang.query.algorithm;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public interface Query {
    /**
     * 顺序查找、二分查找、插值查找、斐波那契查找、树表查找、分块查找、哈希查找
     *
     * @param array
     * @param data
     * @param <T>
     * @return
     */
    <T> int query(T[] array, T data);

}
