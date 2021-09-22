package com.bigbang.query.algorithm;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public class OrderQuery implements Query {
    /**
     * 顺序查找
     *
     * @param array
     * @param data
     * @param <T>
     * @return
     */
    @Override
    public <T> int query(T[] array, T data) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(data))
                return i;
        return -1;
    }
}
