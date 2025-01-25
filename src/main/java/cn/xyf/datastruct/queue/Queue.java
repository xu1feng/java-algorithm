package cn.xyf.datastruct.queue;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 11:13
 * @description: 队列
 */

public interface Queue<E> {

    /**
     * 向队列尾插入值
     * @param value 待插入值
     * @return 插入成功返回 true，插入失败返回 false
     */
    boolean offer(E value);

    /**
     * 从队列头获取值，并移除
     * @return 如果队列非空返回队头值，否则返回 null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return 如果队列非空返回队头值，否则返回 null
     */
    E peek();

    /**
     * 检查队列是否为空
     * @return 空返回 true，否则返回 false
     */
    boolean isEmpty();

    /**
     * 检查队列是否已满
     * @return 满返回 true 否则返回 false
     */
    boolean isFull();

}
