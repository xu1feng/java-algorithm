package cn.xyf.algorithm.design;

import com.google.errorprone.annotations.Var;

import java.util.Random;

/**
 * @author Xuyifeng
 * @description 跳表 - Leetcode1206
 * @date 2025/2/17 14:31
 */

public class SkipList {

    static class Skiplist {
        private static final int MAX = 10; // 每个节点的next指针数量

        static int randomLevel(int max) {
            Random r = new Random();
            int x = 1;
            while (x < max) {
                if (r.nextBoolean()) {
                    return x;
                }
                x++;
            }
            return x;
        }

        private final Node head = new Node(-1);

        public Skiplist() {

        }

        /*
            下楼梯规则
                1. 若 next 指针为 null，或者 next 指向的节点值 >= 目标，向下找
                2. 若 next 指针不为 null，且 next 指向的节点值 < 目标，向右找
         */
        public Node[] find(int value) {
            Node[] path = new Node[MAX];
            Node curr = head;
            for (int level = MAX - 1; level >= 0; level--) { // 从上向下找
                while (curr.next[level] != null && curr.next[level].value < value) { // 向右找
                    curr = curr.next[level];
                }
                path[level] = curr;
            }
            return path;
        }

        public boolean search(int target) {
            Node[] path = find(target);
            Node node = path[0].next[0];
            return node != null && node.value == target;
        }

        /*
            1. 确定添加位置 把 num 当作目标查询，经历的路径就可以确定添加位置
            2. 创建新节点随机高度
            3. 修改路径节点 next 指针，以及新节点 next 指针
         */
        public void add(int num) {
            Node[] path = find(num);
            Node node = new Node(num);
            int level = randomLevel(MAX);
            for (int i = 0; i < level; i++) {
                node.next[i] = path[i].next[i];
                path[i].next[i] = node;
            }
        }

        public boolean erase(int num) {
            Node[] path = find(num);
            Node node = path[0].next[0];
            if (node == null || node.value != num) {
                return false;
            }
            for (int i = 0; i < MAX; i++) {
                if (path[i].next[i] != node) {
                    break;
                }
                path[i].next[i] = node.next[i];
            }
            return true;
        }

        static class Node {
            int value; // 值
            Node[] next = new Node[MAX]; // next 数组

            public Node(int value) {
                this.value = value;
            }
        }
    }

}
