package cn.xyf.algorithm.design;

import java.util.HashMap;

/**
 * @author Xuyifeng
 * @description LRU缓存设计 - Leetcode 146
 * @date 2025/2/17 12:58
 */

public class LRU {

    static class LRUCache {

        private final HashMap<Integer, Node> map = new HashMap<>();

        private final DoublyLinkedList list = new DoublyLinkedList();

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) { // 更新
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else { // 新增
                Node node = new Node(key, value);
                map.put(key, node);
                list.addFirst(node);
                if (map.size() > capacity) {
                    Node removed = list.removeLast();
                    map.remove(removed.key);
                }
            }
        }

        static class Node {
            Node prev;
            Node next;
            int key;
            int value;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        static class DoublyLinkedList {
            Node head;
            Node tail;

            public DoublyLinkedList() {
                head = tail = new Node();
                head.next = tail;
                tail.prev = head;
            }

            // 头部添加
            public void addFirst(Node node) { // O(1)
                Node oldFirst = head.next;
                head.next = node;
                node.next = oldFirst;
                node.prev = head;
                oldFirst.prev = node;
            }

            // 已知节点删除
            public void remove(Node node) { // O(1)
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }

            // 尾部删除
            public Node removeLast() { // O(1)
                Node last = tail.prev;
                remove(last);
                return last;
            }
        }
    }

    public static void main(String[] args) {

    }

}
