package cn.xyf.algorithm.hashtable;

/**
 * @author Xuyifeng
 * @description 哈希表
 * @date 2025/2/1 13:00
 */

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h3>哈希表</h3>
 * 给每份数据分配一个编号，放入表格（数组）
 * 建立编号与表格索引的关系，将来就可以通过编号快速查找数据
 * <ol>
 *     <li>理想情况编号唯一，表格能容纳所有数据</li>
 *     <li>现实是不能说为了容纳所有数据造一个超大表格，编号也有可能重复</li>
 * </ol>
 * 解决
 * <ol>
 *     <li>有限长度的数组，以【拉链】方式存储数据</li>
 *     <li>允许编号适当重复，通过数据自身来进行区分</li>
 * </ol>
 */
public class HashTable {

    // 节点类
    static class Entry {
        int hash; // 哈希码
        Object key; // 键
        Object value; // 值
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    /*
        求模运算替换为位运算
        - 前提：数组长度是 2 的 n 次方
        - hash % 数组长度 等价于 hash & (数组长度 - 1)
     */

    Entry[] table = new Entry[16];
    int size = 0; // 哈希表中元素的个数
    float loadFactor = 0.75f; // 负载因子
    int threshold = (int) (loadFactor * table.length);

    // 根据 hash 码获取 value
    Object get(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    // 向 hash 表存入新key value，如果 key 重复，则更新 value
    void put(int hash, Object key, Object value) {
        int index = hash & (table.length - 1);
        // 1. index 处有空位，直接新增
        if (table[index] == null) {
            table[index] = new Entry(hash, key, value);
        } else {
            // 2. index 处无空位，沿链表查找，有重复 key 更新，否则新增
            Entry p = table[index];
            while (true) {
                if (p.key.equals(key)) {
                    p.value = value; // 更新
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value); // 新增
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    // 扩容
    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i]; // 拿到每个链表头
            if (p != null) {
            /*
                拆分链表，移动到新数组，拆分规律
                * 一个链表最多拆成两个
                * hash & table.length == 0 的一组
                * hash & table.length != 0 的一组
                                          p
                0->8->16->24->32->40->48->null
                            a
                0->16->32->48->null
                        b
                8->24->40->null
             */
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    if ((p.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;
                        }
                        a = p; // 分配到a
                    } else {
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;
                        }
                        b = p; // 分配到b
                    }
                    p = p.next;
                }
                // 规律： a 链表保持索引位置不变，b 链表索引位置+table.length
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

    // 扩容
    private void resize2() {
        // 1. 创建一个新的数组，容量是原来的两倍
        Entry[] newTable = new Entry[table.length << 1];

        // 2. 遍历旧表中的每个桶
        for (Entry entry : table) {
            Entry p = entry;
            while (p != null) {
                // 3. 计算当前节点在新表中的索引
                int newIndex = p.hash & (newTable.length - 1);

                // 4. 将当前节点插入到新表的对应位置
                Entry next = p.next; // 保存下一个节点
                p.next = newTable[newIndex]; // 将当前节点的 next 指向新表的头节点
                newTable[newIndex] = p; // 将当前节点设置为新表的头节点

                // 5. 移动到下一个节点
                p = next;
            }
        }

        // 6. 更新哈希表的引用和阈值
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

    // 根据 hash 码删除，返回删除的 value
    Object remove(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        Entry prev = null;
        while (p != null) {
            if (p.key.equals(key)) {
                // 找到了
                if (prev == null) {
                    table[index] = p.next;
                } else {
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }
        return null;
    }

    public Object get(Object key) {
        int hash = key.hashCode();
        return get(hash, key);
    }

    public void put(Object key, Object value) {
        int hash = key.hashCode();
        put(hash, key, value);
    }

    public Object remove(Object key) {
        int hash = key.hashCode();
        return remove(hash, key);
    }

    public void print() {
        int[] sums = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            while (p != null) {
                sums[i]++;
                p = p.next;
            }
        }

        Map<Integer, Long> collect = Arrays.stream(sums).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        HashTable table = new HashTable();
        /*for (int i = 0; i < 200000; i++) {
            Object object = new Object();
            table.put(object, object);
        }*/

        int abc = Hashing.murmur3_32().hashString("abc", StandardCharsets.UTF_8).asInt();
        System.out.println(abc);

        table.print();
    }

}
