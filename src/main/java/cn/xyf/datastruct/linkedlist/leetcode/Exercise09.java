package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 16:28
 * @description: 回文链表 - LeetCode 234
 */

public class Exercise09 {

    /*
        方法一：
            步骤1：找中间点
            步骤2：中间后半个链表反转
            步骤3：反转后链表与原链表逐一比较
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode middle = p1;

        ListNode n1 = null;
        while (middle != null) {
            ListNode o2 = middle.next;
            middle.next = n1;
            n1 = middle;
            middle = o2;
        }
        ListNode reverse = n1;

        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    /*
        方法二：
            将方法一的步骤1和步骤2合并
            步骤1：找中间点的同时反转前半个链表
            步骤2：反转后的前半个链表 与 中间点开始的后半个链表 逐一比较
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快
        ListNode n1 = null; // 新链表的头
        ListNode o1 = head; // 旧链表的头
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转链表
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }

        if (p2 != null) { // 奇数个节点
            p1 = p1.next;
        }

        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.of(1, 2, 2, 1);
        System.out.println(new Exercise09().isPalindrome2(head1));
        ListNode head2 = ListNode.of(1, 2, 3, 2, 1);
        System.out.println(new Exercise09().isPalindrome2(head2));
    }

}
