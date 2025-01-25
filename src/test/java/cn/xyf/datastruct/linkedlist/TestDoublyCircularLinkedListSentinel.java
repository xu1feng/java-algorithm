package cn.xyf.datastruct.linkedlist;

import org.junit.Test;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 14:58
 * @description:
 */

public class TestDoublyCircularLinkedListSentinel {

    @Test
    public void test1() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.removeFirst();
        list.removeLast();

        for (Integer i : list) {
            System.out.println(i);
        }
    }

}
