package cn.xyf.datastruct.blockingqueue;

/**
 * @author Xuyifeng
 * @description 阻塞队列
 * @date 2025/1/23 14:25
 */

/**
 * 目前队列存在的问题
 * <ol>
 *     <li>很多场景要求<b>分离</b>生产者、消费者两个<b>角色</b>，它们得由不同的线程来担当，而之前的实现根本没有考虑线程安全问题</li>
 *     <li>队列为空，那么在之前的实现里会返回 null，如果就是硬要拿到一个元素呢？只能不断循环尝试</li>
 *     <li>队列为满，那么在之前的实现里会返回 false，如果就是硬要塞入一个元素呢？只能不断循环尝试</li>
 * </ol>
 * 解决方法
 * <ol>
 *     <li>用锁保证线程安全</li>
 *     <li>用条件变量让 poll 或 offer 线程进入<b>等待</b>状态，而不是不断循环尝试，让 CPU 空转</li>
 * </ol>
 */

public interface IBlockingQueue<E> {

    void offer(E e) throws InterruptedException;

    E poll() throws InterruptedException;

    boolean offer(E e, long timeout) throws InterruptedException;

}
