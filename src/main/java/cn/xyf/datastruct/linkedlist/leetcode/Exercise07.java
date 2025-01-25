package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 15:55
 * @description: 合并 K 个升序链表 - LeetCode23
 */

public class Exercise07 {

    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode p = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return sentinel.next;
    }

    /**
     *
     * @param lists
     * @param i 左边界
     * @param j 右边界
     * @return 合并后的链表
     */
    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) { // 数组内只有一个链表时
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    /**
     * 分而治之（分 治 合）
     * 减而治之
     */
    public static void main(String[] args) {
        ListNode[] lists = {ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)};
        ListNode m = new Exercise07().mergeKLists(lists);
        System.out.println(m);
    }

}
