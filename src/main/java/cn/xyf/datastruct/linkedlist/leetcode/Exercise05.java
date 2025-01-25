package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 14:05
 * @description: 删除有序链表重复节点2 - LeetCode 82
 */

public class Exercise05 {

    /**
     * 方法一 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        if (head.val == head.next.val) {
            ListNode x = head.next.next;
            while (x != null && x.val == head.val) {
                x = x.next;
            }
            return deleteDuplicates1(x);
        } else {
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }

    /**
     * 方法二 非递归 哨兵 + 双指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2, p3;

        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) {

                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode o6 = new ListNode(5, null);
        ListNode o5 = new ListNode(4, o6);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(1, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode listNode = new Exercise05().deleteDuplicates2(o1);
        System.out.println(listNode);
    }

}
