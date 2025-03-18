package cn.xyf.代码随想录.链表.翻转链表;

import cn.xyf.代码随想录.链表.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/10 21:19
 */

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null; // 记录cur的下一个节点，以防断链
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
