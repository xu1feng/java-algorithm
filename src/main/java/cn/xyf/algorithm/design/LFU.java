package cn.xyf.algorithm.design;

import java.util.HashMap;

/**
 * @author Xuyifeng
 * @description LFU缓存 - Leetcode 460
 * @date 2025/2/17 13:29
 */

public class LFU {

    static class LFUCache {
        private HashMap<Integer, Node> kvMap = new HashMap<>();

        private HashMap<Integer, DoublyLinkedList> freqMap = new HashMap<>();

        private int capacity;

        private int minFreq = 1;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        /*
            key 不存在
                返回 -1
            key 存在
                返回 value值
                增加节点的使用频度，将其转移到频度+1的链表当中
         */
        public int get(int key) {
            if (!kvMap.containsKey(key)) {
                return -1;
            }
            Node node = kvMap.get(key);
            DoublyLinkedList list1 = freqMap.get(node.freq);
            list1.remove(node);
            if (freqMap.get(node.freq).isEmpty() && node.freq == minFreq) {
                minFreq++;
            }
            node.freq++;
            /*DoublyLinkedList list2 = freqMap.get(node.freq);
            if (list2 == null) {
                list2 = new DoublyLinkedList();
                freqMap.put(node.freq, list2);
            }
            list2.addFirst(node);*/
            DoublyLinkedList list2 = freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList());
            list2.addFirst(node);
            return node.value;
        }

        /*
            更新
                将节点的 value 更新，增加节点的使用频度，将其转移到频度+1的链表当中
            新增
                检查是否超过容量，若超过，淘汰 minFreq 链表的最后节点
                创建新节点，放入 kvMap，并加入频度为 1 的双向链表
         */
        public void put(int key, int value) {
            if (kvMap.containsKey(key)) { // 更新
                Node node = kvMap.get(key);
                DoublyLinkedList list1 = freqMap.get(node.freq);
                list1.remove(node);
                if (freqMap.get(node.freq).isEmpty() && node.freq == minFreq) {
                    minFreq++;
                }
                node.freq++;
                DoublyLinkedList list2 = freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList());
                list2.addFirst(node);
                node.value = value;
            } else { // 新增
                if (kvMap.size() == capacity) {
                    DoublyLinkedList minFreqList = freqMap.get(minFreq);
                    Node node = minFreqList.removeLast();
                    kvMap.remove(node.key);
                }
                Node node = new Node(key, value);
                kvMap.put(key, node);
                DoublyLinkedList list = freqMap.computeIfAbsent(1, k -> new DoublyLinkedList());
                list.addFirst(node);
                minFreq = 1;
            }
        }

        static class Node {
            Node prev;
            Node next;
            int key;
            int value;
            int freq; // 频度

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.freq = 1;
            }
        }

        static class DoublyLinkedList {
            Node head;
            Node tail;
            int size; // 链表中元素个数

            public DoublyLinkedList() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            // 头部添加
            public void addFirst(Node node) { // O(1)
                Node oldFirst = head.next;
                head.next = node;
                node.next = oldFirst;
                node.prev = head;
                oldFirst.prev = node;
                size++;
            }

            // 已知节点删除
            public void remove(Node node) { // O(1)
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                size--;
            }

            // 尾部删除
            public Node removeLast() { // O(1)
                Node last = tail.prev;
                remove(last);
                return last;
            }

            // 判空
            public boolean isEmpty() {
                return size == 0;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1 freq=2
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3 freq=2
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3  freq=3
        System.out.println(cache.get(4)); // 4  freq=2

    }
}
