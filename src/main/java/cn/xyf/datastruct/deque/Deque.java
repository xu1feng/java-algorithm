package cn.xyf.datastruct.deque;

/**
 * @author Xuyifeng
 * @description 双端队列接口
 * @date 2025/1/22 16:16
 */

public interface Deque<E> {

    boolean offerFirst(E value);

    boolean offerLast(E value);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();

}
