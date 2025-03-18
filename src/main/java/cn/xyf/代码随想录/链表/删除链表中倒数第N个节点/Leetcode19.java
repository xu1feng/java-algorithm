package cn.xyf.代码随想录.链表.删除链表中倒数第N个节点;

import cn.xyf.代码随想录.链表.ListNode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/10 21:50
 */

public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return sentinel.next;
    }

}
