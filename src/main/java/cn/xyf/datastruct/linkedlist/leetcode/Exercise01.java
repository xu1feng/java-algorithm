package cn.xyf.datastruct.linkedlist.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 17:49
 * @description: 反转单向链表 - LeetCode206
 */

public class Exercise01 {

    /**
     * 方法一<br>
     * 构造一个新链表，从旧链表依次拿到每个节点，创建新节点添加至新链表头部，完成后新链表即是倒序的
     *
     * @param o1 旧链表第一个节点
     * @return
     */
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (null != first) {
                head = first.next;
            }
            return first;
        }

    }

    /**
     * 方法二<br>
     * 构造一个新链表，从旧链表头部移除节点，添加到新链表头部，完成后新链表即是倒序的，区别在于原题目未提供节点外层的容器类，这里提供一个，另外一个区别是并不去构造新节点
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode first = list1.removeFirst();
            if (null == first)
                break;
            list2.addFirst(first);
        }
        return list2.head;
    }

    /**
     * 方法三 - 递归
     */
    public ListNode reverseList3(ListNode p) {
        if (null == p || p.next == null) {
            return p; // 找到最后的节点
        }

        // 找到链表最后节点 作为新链表的头节点
        ListNode last = reverseList3(p.next);
        // 让相邻的两个节点逆序
        p.next.next = p;
        p.next = null;

        return last;
    }

    /**
     * 方法四 从链表每次拿到第二个节点，将其从链表断开，插入头部，直至它为 null 结束
     */
    public ListNode reverseList4(ListNode o1) {
        // 链表为空 或者 链表只有一个节点
        if (null == o1 || null == o1.next) {
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    /**
     * 方法五 类似方法二 面向过程
     */
    public ListNode reverseList5(ListNode o1) {
        if (null == o1 || null == o1.next)
            return o1;
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new Exercise01().reverseList5(o1);
        System.out.println(n1);
    }

}
