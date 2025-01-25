package cn.xyf.datastruct.linkedlist;

import org.junit.Test;

public class TestSinglyLinkedList {

    @Test
    public void test1() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.loop2(System.out::println);
    }

    @Test
    public void test2() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.loop1(System.out::println);
    }

    @Test
    public void test4() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        System.out.println(singlyLinkedList.getNodeValue(1));
    }

    @Test
    public void test5() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.insert(2, 5);
        singlyLinkedList.loop1(System.out::println);
    }

    @Test
    public void test6() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.removeFirst();
        singlyLinkedList.remove(1);
        singlyLinkedList.loop1(System.out::println);
    }

    @Test
    public void test7() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.loop3(System.out::println, System.out::println);
    }

}
