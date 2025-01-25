package cn.xyf.datastruct.heap;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 堆排序
 * @date 2025/1/24 11:01
 */

public class HeapSort {

    /*
        1. buildHeap 建立大顶堆
        2. 将堆顶与堆底交换（最大元素被交换到堆底），缩小并下潜调整堆
        3. 重复第二步直至堆里剩一个元素
     */

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 6, 4, 5};
        MaxHeap heap = new MaxHeap(array);
        System.out.println(Arrays.toString(heap.array));

        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }
        System.out.println(Arrays.toString(heap.array));
    }

}
