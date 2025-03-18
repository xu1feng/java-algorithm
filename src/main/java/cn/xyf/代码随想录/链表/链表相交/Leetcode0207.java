package cn.xyf.代码随想录.链表.链表相交;

import cn.xyf.代码随想录.链表.ListNode;

/**
 * @author Xuyifeng
 * @description 面试题02.07 链表相交
 * @date 2025/3/11 20:22
 */

public class Leetcode0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            lengthA++;
            p = p.next;
        }
        while (q != null) {
            lengthB++;
            q = q.next;
        }
        p = headA;
        q = headB;
        if (lengthB > lengthA) {
            int temp = lengthA;
            lengthA = lengthB;
            lengthB = temp;
            ListNode tempNode = p;
            p = q;
            q = tempNode;
        }
        int gap = lengthA - lengthB;
        while (gap-- > 0) {
            p = p.next;
        }
        while (p != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }


}
