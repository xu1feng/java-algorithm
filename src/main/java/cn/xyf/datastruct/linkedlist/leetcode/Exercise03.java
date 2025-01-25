package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 10:34
 * @description: 删除链表的倒数第 N 个节点 - LeetCode 19
 */

public class Exercise03 {

    /**
     * 方法一 递归
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        recursion(sentinel, n);
        return sentinel.next;
    }

    /**
     * 方法二 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
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

    private int recursion(ListNode p, int n) {
        if (null == p) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数位置
        if (nth == n) {
            // p = 3, p.next = 4, p.next.next = 5
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        new Exercise03().removeNthFromEnd2(o1, 2);
        System.out.println(o1);
    }

}
