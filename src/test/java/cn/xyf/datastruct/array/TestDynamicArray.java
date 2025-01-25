package cn.xyf.datastruct.array;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author: Xuyifeng
 * @date: 2025/1/17 10:08
 * @description: 测试动态数组的方法
 */

public class TestDynamicArray {

    @Test
    @DisplayName("DynamicArray add 添加元素")
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.add(1, 2);

        for (int i = 0; i < 6; i++) {
            System.out.println(dynamicArray.get(i));

        }
    }

    @Test
    @DisplayName("DynamicArray foreach 遍历")
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.foreach(element -> {
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("DynamicArray iterator 遍历")
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        for (Integer i : dynamicArray) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("DynamicArray stream 遍历")
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("DynamicArray remove 删除")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int remove = dynamicArray.remove(1);
        System.out.println("被删除的元素: " + remove);
        
        dynamicArray.stream().forEach(System.out::println);
    }

}
