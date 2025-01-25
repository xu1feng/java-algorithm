package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/20 18:09
 * @description: 环形链表 - LeetCode 141
 */

public class Exercise10 {

    public boolean hasCycle(ListNode head) {
        ListNode h = head; // 兔子
        ListNode t = head; // 龟
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if (h == t)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode o8 = new ListNode(5, null);
        ListNode o7 = new ListNode(5, o8);
        ListNode o6 = new ListNode(5, o7);
        ListNode o5 = new ListNode(5, o6);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        o8.next = o5;

        System.out.println(new Exercise10().hasCycle(o1));
    }

}
