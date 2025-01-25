package cn.xyf.datastruct.linkedlist;

import java.util.Iterator;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 10:10
 * @description: 双向链表带哨兵
 */

public class DoublyLinkedListSentinel {

    private static class Node {
        Node prev; // 指向上一个节点指针
        int value; // 节点值
        Node next; // 指向下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

    }

    private Node head; // 头部哨兵
    private Node tail; // 尾部哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, tail);
        tail = new Node(head, 888, null);
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index)
                return p;
        }
        return null;
    }

    public void addFirst(int value) {
        Node first = head.next;
        Node added = new Node(head, value, first);
        first.prev = added;
        head.next = first;
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void insert(int index, int value) throws Exception {
        Node prev = findNode(index - 1);
        if (null == prev) {
            throw new Exception("index 不合法");
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        Node removed = tail.prev;
        if (tail == removed) {
            throw new IllegalArgumentException(String.format("index : {%d} 不合法\n", 0));
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (null == prev) {
            throw new IllegalArgumentException(String.format("index : {%d} 不合法\n", index));
        }
        Node removed = prev.next;
        if (tail == removed) {
            throw new IllegalArgumentException(String.format("index : {%d} 不合法\n", index));
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
