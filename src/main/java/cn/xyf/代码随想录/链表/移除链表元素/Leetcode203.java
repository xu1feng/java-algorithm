package cn.xyf.代码随想录.链表.移除链表元素;

import cn.xyf.代码随想录.链表.ListNode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 21:47
 */

public class Leetcode203 {

    public ListNode removeElements(ListNode head, int val) {
        // 设置虚拟头节点
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel.next;
        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return sentinel.next;
    }

}
