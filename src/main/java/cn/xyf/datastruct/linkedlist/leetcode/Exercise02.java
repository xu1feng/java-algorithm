package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 10:14
 * @description: 根据值删除节点 - LeetCode 203
 */

public class Exercise02 {

    /**
     * 方法一 哨兵 非递归
     * @param head 链表头
     * @param val 目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements1(ListNode head, int val) {
        // 哨兵节点
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel.next;
        while (p2 != null) {
            if (p2.val == val) {
                // 删除，p2向后平移
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                // p1 p2 向后平移
                p1 = p2;
                p2 = p2.next;
            }
        }
        return sentinel.next;
    }

    /**
     * 方法二 递归
     * @param head 链表头
     * @param val 目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (null == head)
            return null;
        if (val == head.val) {
            return removeElements2(head.next, val);
        } else {
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new Exercise02().removeElements2(o1, 2);
        System.out.println(n1);
    }

}
