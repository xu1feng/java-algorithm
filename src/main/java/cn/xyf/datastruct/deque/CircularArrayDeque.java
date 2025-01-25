package cn.xyf.datastruct.deque;

import java.util.Iterator;

/**
 * @author Xuyifeng
 * @description 基于循环数组实现的双端队列 tail停下的位置不存储元素
 * @date 2025/1/22 16:55
 */

public class CircularArrayDeque<E> implements Deque<E>, Iterable<E> {

    /*
        h - head
        t - tail

                    h
                t
        0   1   2   3
        a   b       c

        offerLast(a)    先添加元素 再 tail++
        offerLast(a)
        offerFirst(c)   先 head-- 再添加元素

        pollFirst()     先获取 head 指向的值 再让 head++
        pollLast()      先获取 tail 指向的值 再让 tail--

        head == tail -> 空
        head ~ tail == 数组长度 - 1 -> 满
     */

    E[] array;
    int head;
    int tail;

    public CircularArrayDeque(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    private static int incr(int i, int length) {
        if (i + 1 > length) {
            return 0;
        }
        return i + 1;
    }

    private static int decr(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        head = decr(head, array.length);
        array[head] = value;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = incr(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        array[head] = null; // help GC
        head = incr(head, array.length);
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = decr(tail, array.length);
        E value = array[tail];
        array[tail] = null; // help GC
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[decr(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else if (head > tail) {
            return head - tail == 1;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = incr(p, array.length);
                return value;
            }
        };
    }

}
