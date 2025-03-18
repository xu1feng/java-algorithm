package cn.xyf.代码随想录.链表;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 21:48
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
