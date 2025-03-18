package cn.xyf.代码随想录.链表.设计链表;

import cn.xyf.datastruct.linkedlist.SinglyLinkedListSentinel;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/10 20:54
 */

public class Leetcode707 {

    class MyLinkedList {

        private Node head = new Node(-1, null); // 头指针指向哨兵

        public MyLinkedList() {

        }

        public int get(int index) {
            int i = -1;
            for (Node p = head; p != null; p = p.next, i++) {
                if (index == i) {
                    return p.value;
                }
            }
            return -1;
        }

        public Node findNode(int index) {
            int i = -1;
            for (Node p = head; p != null; p = p.next, i++) {
                if (index == i) {
                    return p;
                }
            }
            return null;
        }

        public void insert(int index, int value) {
            Node prevNode = findNode(index - 1); // 前一个节点
            if (null == prevNode) {
                return;
            }
            prevNode.next = new Node(value, prevNode.next);
        }

        public Node findLast() {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            return p;
        }

        public void addAtHead(int val) {
            insert(0, val);
        }

        public void addAtTail(int val) {
            Node last = findLast();
            last.next = new Node(val, null);
        }

        public void addAtIndex(int index, int val) {
            Node preNode = findNode(index - 1);
            if (preNode == null) {
                return;
            }
            Node nextNode = preNode.next;
            preNode.next = new Node(val, nextNode);
        }

        public void deleteAtIndex(int index) {
            Node preNode = findNode(index - 1);
            if (preNode == null) {
                return;
            }
            Node removed = preNode.next;
            if (removed == null) {
                return;
            }
            preNode.next = removed.next;
        }

        private static class Node {
            int value; // 值
            Node next; // 下一个节点指针

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }

}
