package cn.xyf.datastruct.priorityqueue;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/23 10:44
 */

public class Entry implements Priority{

    String value;
    int priority;

    public Entry(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "{" + value + " priority = " + priority + "}";
    }

}
