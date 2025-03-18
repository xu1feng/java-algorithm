package cn.xyf.代码随想录.链表.两两交换链表中的节点;

import cn.xyf.代码随想录.链表.ListNode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/10 21:40
 */

public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1); // 设置一个虚拟节点
        dummyHead.next = head; // 将虚拟节点指向head，方便后续的删除操作
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode p = cur.next; // 临时节点，保存两个节点之中的第一个节点
            ListNode q = cur.next.next; // 临时节点，保存两个节点之中的第二个节点
            ListNode temp = cur.next.next.next; // 临时节点，保存两个节点后面的节点
            cur.next = q; // 步骤一
            q.next = p; // 步骤二
            p.next = temp; // 步骤三
            cur = cur.next.next; // cur后移，准备下一轮交换
        }
        return dummyHead.next;
    }

}
