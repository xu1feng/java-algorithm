package cn.xyf.datastruct.priorityqueue;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/23 10:29
 */

public interface Priority {

    /**
     * 返回对象的优先级，约定数字越大，优先级越高
     * @return 优先级
     */
    int priority();

}
