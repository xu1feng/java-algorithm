package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 16:18
 * @description: 链表的中间节点 - LeetCode 876
 */

public class Exercise08 {

    /**
     * 解法：快慢指针，快指针一次走两步，慢指针一次走一步，当快指针到链表结尾时，慢指针恰好走到链表的一半
     *
     * @param head 链表
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new Exercise08().middleNode(head1));
        ListNode head2 = ListNode.of(1, 2, 3, 4, 5, 6);
        System.out.println(new Exercise08().middleNode(head2));
    }

}
