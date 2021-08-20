package com.bigbang.sorting;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/20
 * @ Time 9:38
 */
public class LeetCode147InsertionSortList {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Given the head of a singly linked list, sort the list using insertion sort,
     * and return the sorted list's head.
     * <p>
     * The steps of the insertion sort algorithm:
     * <p>
     * Insertion sort iterates,
     * consuming one input element each repetition and growing a sorted output list.
     * At each iteration, insertion sort removes one element from the input data,
     * finds the location it belongs within the sorted list and inserts it there.
     * It repeats until no input elements remain.
     * The following is a graphical example of the insertion sort algorithm.
     * The partially sorted list (black) initially contains only the first element in the list.
     * One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
     * <p>
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [4,2,1,3]
     * Output: [1,2,3,4]
     * Example 2:
     * <p>
     * <p>
     * Input: head = [-1,5,3,4,0]
     * Output: [-1,0,3,4,5]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [1, 5000].
     * -5000 <= Node.val <= 5000
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        //Runtime: 2 ms, faster than 98.44% of Java online submissions for Insertion Sort List.
        //Memory Usage: 38.3 MB, less than 94.04% of Java online submissions for Insertion Sort List.

        ListNode solution = new ListNode(0);
        ListNode current = solution;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            /* 插入之前，current在有序列表中的末尾，仅仅当head当前的值大于有序列表的末尾值，才将current设置为有序列表的头位 */
            if (current.val >= head.val) current = solution;
            while (current.next != null && current.next.val < head.val) {
                current = current.next;
            }
            head.next = current.next;
            current.next = head;
            head = temp;
        }

        return solution.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode temp = node;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(3);

        ListNode solution = insertionSortList(node).next;
        while (solution!=null){
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}