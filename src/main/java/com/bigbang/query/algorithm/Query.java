package com.bigbang.query.algorithm;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public interface Query {

    <T> int query(T[] array, T data);

}
