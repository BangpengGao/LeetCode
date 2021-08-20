package com.bigbang.sorting;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/20
 * @ Time 10:20
 */
public class LeetCode148SortList {
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
     * Given the head of a linked list, return the list after sorting it in ascending order.
     * <p>
     * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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
     * Example 3:
     * <p>
     * Input: head = []
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [0, 5 * 104].
     * -105 <= Node.val <= 105
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        // 采用归并排序方法进行处理
        //Runtime: 6 ms, faster than 81.27% of Java online submissions for Sort List.
        //Memory Usage: 46.9 MB, less than 80.85% of Java online submissions for Sort List.

        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sort = sortList(slow.next);
        slow.next = null;
        return merge(sortList(head), sort);
    }

    /**
     * 单向链表的归并排序
     */
    public static ListNode merge(ListNode node1, ListNode node2) {
        ListNode solution = new ListNode(Integer.MIN_VALUE);
        ListNode temp = solution;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if (node1 != null)
            temp.next = node1;
        if (node2 != null)
            temp.next = node2;

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

        ListNode solution = sortList(node).next;
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
