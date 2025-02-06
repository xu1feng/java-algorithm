package cn.xyf.algorithm.sort;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/6 12:03
 */

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h3>双边循环</h3>
 * <ul>
 *     <li>选择最左侧元素作为基准点</li>
 *     <li>j 找比基准点小的，i 找比基准点大的，一旦找到，二者进行交换</li>
 *     <ul>
 *         <li>i 从左向右</li>
 *         <li>j 从右向左</li>
 *     </ul>
 *     <li>最后基准点与 i 交换，i 即为基准点最终索引</li>
 * </ul>
 */

public class QuickSortHoare {

    public static void sort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(a, left, right); // p 代表基准点元素索引
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    /*
        注意事项：
        1. 要加内层循环的 i < j 条件
        2. 要先处理 j，再处理 i
        3. 随机元素作为基准点
        4. 如果有大量重复元素
     */
    private static int partition(int[] a, int left, int right) {
        // 随机元素作为基准点
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        // [0, 9], right - left + 1 = 3, [0, 2] + 4 = [4, 6]
        swap(a, idx, left);
        int pv = a[left]; // 基准点元素的值
        int i = left;
        int j = right;
        while (i < j) {
            // 1. j 从右向左找小（等）的
            while (i < j && a[j] > pv) {
                j--;
            }
            // 2. i 从左向右找大的
            while (i < j && a[i] <= pv) {
                i++;
            }
            // 3. 交换位置
            swap(a, i, j);
        }
        swap(a, i, left);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
