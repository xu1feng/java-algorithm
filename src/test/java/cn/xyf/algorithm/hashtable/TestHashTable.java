package cn.xyf.algorithm.hashtable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/1 14:04
 */

public class TestHashTable {

    @Test
    public void testResize() {
        HashTable hashTable = new HashTable();

        // 初始容量为 16，负载因子为 0.75，阈值为 12
        assertEquals(16, hashTable.table.length);
        assertEquals(12, hashTable.threshold);

        // 添加 12 个元素，未触发扩容
        for (int i = 0; i < 12; i++) {
            hashTable.put(i, "key" + i, "value" + i);
        }
        assertEquals(12, hashTable.size);
        assertEquals(16, hashTable.table.length); // 容量未变

        // 添加第 13 个元素，触发扩容
        hashTable.put(12, "key12", "value12");
        assertEquals(13, hashTable.size);
        assertEquals(32, hashTable.table.length); // 容量变为 32
        assertEquals(24, hashTable.threshold); // 新阈值为 24

        // 验证数据迁移的正确性
        for (int i = 0; i < 13; i++) {
            assertEquals("value" + i, hashTable.get(i, "key" + i));
        }

        // 添加更多元素，验证扩容后的哈希冲突处理
        for (int i = 13; i < 25; i++) {
            hashTable.put(i, "key" + i, "value" + i);
        }
        assertEquals(25, hashTable.size);
        assertEquals(64, hashTable.table.length); // 容量未变，未达到新阈值

        // 验证所有数据是否被正确存储
        for (int i = 0; i < 25; i++) {
            assertEquals("value" + i, hashTable.get(i, "key" + i));
        }
    }

}
