package com.bigbang.sorting;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 14:05
 */
public class LeetCode295FindMedianFromDataStream {

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * initialize your data structure here.
 */
class MedianFinder {
    //Runtime: 106 ms, faster than 38.27% of Java online submissions for Find Median from Data Stream.
    //Memory Usage: 69.1 MB, less than 21.69% of Java online submissions for Find Median from Data Stream.

    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        return even ? (small.peek() + large.peek()) / 2.0 : small.peek();
    }
}
