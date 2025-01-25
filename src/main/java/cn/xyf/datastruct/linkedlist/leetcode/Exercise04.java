package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 13:45
 * @description: 删除有序链表重复节点- LeetCode 83
 */

public class Exercise04 {

    /**
     * 方法一 双指针法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        // 链表为空 或者 链表只有一个节点 直接返回链表
        if (null == head || null == head.next) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                // 删除p2
                p1.next = p2.next;
            } else {
                // 向后平移
                p1 = p1.next;
            }
        }
        return head;
    }

    /**
     * 方法二 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(1, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode listNode = new Exercise04().deleteDuplicates2(o1);
        System.out.println(listNode);
    }

}
