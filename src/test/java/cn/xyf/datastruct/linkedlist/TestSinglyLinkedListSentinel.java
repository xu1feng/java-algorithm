package cn.xyf.datastruct.linkedlist;

import org.junit.Test;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 9:43
 * @description: 单向链表带哨兵
 */

public class TestSinglyLinkedListSentinel {

    @Test
    public void test1() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.getNodeValue(1));
    }

    @Test
    public void test3() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.insert(0, 5);
        list.loop1(System.out::println);
    }

    @Test
    public void test4() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(5);
        list.loop1(System.out::println);
    }

    @Test
    public void test5() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.remove(1);
        list.loop1(System.out::println);
    }

}
