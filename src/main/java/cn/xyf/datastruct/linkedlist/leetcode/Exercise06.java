package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 15:08
 * @description: 合并两个有序链表 - LeetCode 21
 */

public class Exercise06 {

    /**
     * 方法一
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
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
     * 方法二 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = ListNode.of(1, 3, 8, 9);
        ListNode p2 = ListNode.of(2, 4);
        System.out.println(new Exercise06().mergeTwoLists2(p1, p2));
    }

}
