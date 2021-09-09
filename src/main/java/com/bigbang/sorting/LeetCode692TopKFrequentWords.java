package com.bigbang.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/9
 * @since 1.0.0
 */
public class LeetCode692TopKFrequentWords {
    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     * <p>
     * Return the answer sorted by the frequency from highest to lowest.
     * Sort the words with the same frequency by their lexicographical order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
     * Output: ["i","love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     * Example 2:
     * <p>
     * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
     * Output: ["the","is","sunny","day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     * with the number of occurrence being 4, 3, 2 and 1 respectively.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= words.length <= 500
     * 1 <= words[i] <= 10
     * words[i] consists of lowercase English letters.
     * k is in the range [1, The number of unique words[i]]
     * <p>
     * <p>
     * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        //Runtime: 14 ms, faster than 7.81% of Java online submissions for Top K Frequent Words.
        //Memory Usage: 43 MB, less than 6.54% of Java online submissions for Top K Frequent Words.

        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for (String w : words)
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);

        wordMap = wordMap.entrySet().
                stream().
                sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> solution = new ArrayList<>(k);
        for (String key : wordMap.keySet()) {
            solution.add(key);
            if (solution.size() == k) break;
        }
        return solution;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        System.out.println(topKFrequent(words, 2));
    }
}
