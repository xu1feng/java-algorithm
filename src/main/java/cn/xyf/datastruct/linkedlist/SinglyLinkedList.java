package cn.xyf.datastruct.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author: Xuyifeng
 * @date: 2025/1/17 14:55
 * @description: 单向链表
 */

public class SinglyLinkedList implements Iterable<Integer> { // 整体

    private Node head = null; // 头指针

    /**
     * 向链表头部添加
     *
     * @param value 待添加的值
     */
    public void addFirst(int value) {
        // 1. 链表为空
//        head = new Node(value, null);
        // 2. 链表非空
        head = new Node(value, head);
    }

    /**
     * 查找最后一个节点
     *
     * @return 最后一个节点
     */
    private Node findLast() {
        if (null == head) { // 空链表
            return null;
        }

        // 链表非空
        Node p = head;
        while (p.next != null)
            p = p.next;
        return p;
    }

    /**
     * 向链表尾部添加
     *
     * @param value 待添加的值
     */
    public void addLast(int value) {
        Node last = findLast();
        if(null == last) { // 空链表
            addFirst(value);
            return;
        }

        last.next = new Node(value, null);
    }

    /**
     * 根据索引查找节点
     *
     * @param index 索引
     * @return 找到返回该节点 没找到返回 null
     */
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }

    /**
     * 获取索引所指向节点的值
     *
     * @param index 索引
     * @return 节点的值
     */
    public int getNodeValue(int index) {
        Node node = findNode(index);
        if (null == node) {
            throw new IllegalArgumentException(String.format("index : %d 不合法\n", index));
        }
        return node.value;
    }

    /**
     * 向索引位置插入节点
     *
     * @param index 索引
     * @param value 薪节点的值
     */
    public void insert(int index, int value) {
        if (0 == index) {
            addFirst(value);
            return;
        }
        Node prevNode = findNode(index - 1); // 前一个节点
        if (null == prevNode) {
            throw new IllegalArgumentException(String.format("index : %d 不合法\n", index));
        }
        prevNode.next = new Node(value, prevNode.next);
    }

    /**
     * 删除链表第一个节点
     */
    public void removeFirst() {
        if (null == head) {
            throw new IllegalArgumentException("链表为空");
        }
        head = head.next;
    }

    /**
     * 删除索引位置的节点
     *
     * @param index 索引
     */
    public void remove(int index) {
        if (0 == index) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (null == prev) {
            throw new IllegalArgumentException(String.format("index : %d 不合法\n", index));
        }
        Node remove = prev.next;
        if (null == remove) {
            throw new IllegalArgumentException(String.format("index : %d 不合法\n", index));
        }
        prev.next = remove.next;
    }

    /**
     * 遍历链表 - while
     *
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表 - for
     *
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /**
     * 遍历链表 - iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类
        return new NodeIterator();
    }

    /**
     * 遍历链表 - 递归
     */
    public void loop3(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head, before, after);
    }

    private void recursion(Node cur, Consumer<Integer> before, Consumer<Integer> after) { // 某个节点要进行的操作
        if (null == cur) {
            return;
        }
        before.accept(cur.value);
        recursion(cur.next, before, after);
        after.accept(cur.value);
    }

    /**
     * 节点类
     * <br>
     * 内部类 对外隐藏内部细节
     */
    private static class Node {

        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    // 当内部类使用外部类的成员变量时，不能加 static
    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前元素的值，并指向下一个元素
            int value = p.value;
            p = p.next;
            return value;
        }
    }

}