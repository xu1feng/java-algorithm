package cn.xyf.代码随想录.链表.环形链表;

import cn.xyf.代码随想录.链表.ListNode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/11 20:57
 */

public class Leetcode141 {

    public boolean hasCycle(ListNode head) {
        ListNode rabbit = head;
        ListNode turtle = head;
        while (rabbit != null && rabbit.next != null) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if (rabbit == turtle) {
                return true;
            }
        }
        return false;
    }

}
