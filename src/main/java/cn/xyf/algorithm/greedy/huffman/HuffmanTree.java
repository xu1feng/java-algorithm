package cn.xyf.algorithm.greedy.huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xuyifeng
 * @description Huffman树以及编解码
 * @date 2025/2/10 15:07
 */

public class HuffmanTree {

    /*
        Huffman 树的构建过程

        1. 将统计了出现频率的字符，放入优先级队列

        2. 每次出队两个频次最低的元素，给它俩找个爹
        3. 把爹重新放入队列，重复 2~3
        4. 当队列只剩一个元素时，Huffman 树构建完成
     */

    static class Node {
        Character ch; // 字符
        int freq; // 频次
        Node left;
        Node right;
        String code; // 编码

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int getFreq() {
            return freq;
        }

        boolean isLeaf() {
            return left == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }
    }

    String str;
    Map<Character, Node> map = new HashMap<>();
    Node root;

    public HuffmanTree(String str) {
        this.str = str;
        // 功能1：统计频率
        char[] chars = str.toCharArray();
        for (char c : chars) {
            /*if (!map.containsKey(c)) {
                map.put(c, new Node(c));
            }
            Node node = map.get(c);
            node.freq++;*/
            Node node = map.computeIfAbsent(c, Node::new);
            node.freq++;
        }
        // 功能2：构造树
        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(Node::getFreq)
        );
        queue.addAll(map.values());
        while (queue.size() >= 2) {
            Node x = queue.poll();
            Node y = queue.poll();
            queue.offer(new Node(x.freq + y.freq, x, y));
        }
        root = queue.poll();
        // 功能3：计算每个字符的编码
        int sum = dfs(root, new StringBuilder());
        for (Node node : map.values()) {
            System.out.println(node + " ----> " + node.code);
        }
        // 功能4：字符串编码后占用字符数
        System.out.println("字符串编码后占用字符数: " + sum);
    }

    private int dfs(Node node, StringBuilder code) {
        int sum = 0;
        if (node.isLeaf()) {
            // 找到编码
            node.code = code.toString();
            sum = node.freq * node.code.length();
        } else {
            sum += dfs(node.left, code.append("0"));
            sum += dfs(node.right, code.append("1"));
        }
        if (code.length() > 0) {
            // 往回走要删除字符
            code.deleteCharAt(code.length() - 1);
        }
        return sum;
    }

    // 编码
    public String encode() {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(map.get(c).code);
        }
        return sb.toString();
    }

    // 解码
    public String decode(String str) {
        /*
            从根节点，寻找数字对应的字符
                数字是 0 向左走
                数字是 1 向右走
                如果没走到头，每走一步数字的索引 i++
            走到头就可以找到解码字符，再将 node 重置为根节点
         */
        char[] chars = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Node node = root;
        while (i < chars.length) {
            if (!node.isLeaf()) {
                if (chars[i] == '0') { // 向左走
                    node = node.left;
                } else if (chars[i] == '1') { // 向右走
                    node = node.right;
                }
                i++;
            }
            if(node.isLeaf()) { // 叶子结点
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String origin = "abbccccccc";
        System.out.println("原始字符串：" + origin);
        HuffmanTree huffmanTree = new HuffmanTree(origin);
        String encode = huffmanTree.encode();
        System.out.println("编码：" + encode);
        System.out.println("解码：" + huffmanTree.decode(encode));
    }

}
