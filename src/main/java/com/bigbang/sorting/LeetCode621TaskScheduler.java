package com.bigbang.sorting;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/6
 * @ Time 14:08
 */
public class LeetCode621TaskScheduler {
    /**
     * Given a characters array tasks, representing the tasks a CPU needs to do,
     * where each letter represents a different task.
     * Tasks could be done in any order. Each task is done in one unit of time.
     * For each unit of time, the CPU could complete either one task or just be idle.
     * <p>
     * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
     * that is that there must be at least n units of time between any two same tasks.
     * <p>
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation:
     * A -> B -> idle -> A -> B -> idle -> A -> B
     * There is at least 2 units of time between any two same tasks.
     * Example 2:
     * <p>
     * Input: tasks = ["A","A","A","B","B","B"], n = 0
     * Output: 6
     * Explanation: On this case any permutation of size 6 would work since n = 0.
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * And so on.
     * Example 3:
     * <p>
     * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * Output: 16
     * Explanation:
     * One possible solution is
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= task.length <= 104
     * tasks[i] is upper-case English letter.
     * The integer n is in the range [0, 100].
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        // 需要通过贪心算法进行解决，是最简单最快速的方法
        // Runtime: 3 ms, faster than 60.99% of Java online submissions for Task Scheduler.
        // Memory Usage: 40.4 MB, less than 43.23% of Java online submissions for Task Scheduler.

        int[] buckets = new int[26];
        int max = 0, maxCount = 0;
        for (char t : tasks) {
            buckets[t - 'A']++;
            if (max == buckets[t - 'A'])
                maxCount++;
            else if (max < buckets[t - 'A']) {
                max = buckets[t - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1,
                partLength = n - maxCount + 1,
                emptySlots = partCount * partLength,
                availableTasks = tasks.length - max * maxCount,
                idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }

    public static void main(String[] args) {
//        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
//        System.out.println(leastInterval(chars, 0));

        char[] chars1 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(chars1, 2));
    }
}
