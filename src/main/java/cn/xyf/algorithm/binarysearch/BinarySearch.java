package cn.xyf.algorithm.binarysearch;

/**
 * @author: Xuyifeng
 * @date: 2025/1/14 21:28
 * @description: 二分查找
 */

public class BinarySearch {

    /**
     * 二分查找基础版 - 左闭右闭
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 找到则返回 索引下标
     *         找不到则返回 -1
     */
    public static int binarySearchBasic(int[] a, int target) {
        // 这里的 i j 不光作为边界 也有可能作为查找的目标
        int i = 0, j = a.length - 1; // 设置指针和初值
        // L次 元素在最左边 L 次，  元素在最右边 2L 次
        while (i <= j) { // i~j 范围内有东西
//            int mid = (i + j) / 2;
            int mid = (i + j) >>> 1;
            if (a[mid] < target) // 目标值在右边
                i = mid + 1;
            else if (target < a[mid]) // 目标值在左边
                j = mid - 1;
            else // 找到了
                return mid;
        }
        return -1;
    }

    /**
     * 1 [2, 3, 4, 5] 6 右侧没找到更差
     * int i = 0, j = a.length - 1;     2
     * return -1;                       1
     * 元素个数         循环次数
     *    4-7             3
     *    8-15            4
     *    16-31           5
     *    32-63           6
     *    ....          ....
     *     n            floor(log_2(n)) + 1
     *
     * 循环次数L = floor(log_2(n)) + 1
     * i <= j                         L + 1
     * int mid = (i + j) >>> 1;         L
     * a[mid] < target                  L
     * target < a[mid]                  L
     * i = mid + 1;                     L
     *
     *                              5 * (floor(log_2(n)) + 1) + 4
     */

    /**
     * Q1: 为什么是 i <= j 意味着区间内有未必较的元素，而不是 i < j ?
     * A1: i, j 它们指向的元素也会参与比较
     *
     * Q2: (i + j) / 2 有没有问题？
     * A2: 有，当 j = Integer.MAX_VALUE - 1，mid 最终会溢出  通过 >>> （无符号右移运算符）来解决这个问题
     *
     * Q3: 都写成小于号有啥好处？
     * A3: 代码可阅读性更高
     */

    /**
     * 二分查找改动版 - 左闭右开
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 找到则返回 索引下标
     *         找不到则返回 -1
     */
    public static int binarySearchAlternative(int[] a, int target) {
        // 这里的 i 不光作为边界 也有可能作为查找的目标，而 j 只作为边界，一定不作为查找目标
        int i = 0, j = a.length; // 改动1
        while (i < j) { // 改动2
            int mid = (i + j) >>> 1;
            if (a[mid] < target)
                i = mid + 1;
            else if (target < a[mid])
                j = mid; // 改动3
            else
                return mid;
        }
        return -1;
    }

    /**
     * 二分查找平衡版
     *
     * 目的：减少循环内的比较次数
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 找到则返回 索引下标 找不到则返回 -1
     */
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) { // 范围内待查找的元素个数
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else { // target == a[m] || target > a[m]
                i = m;
            }
        }
        // 等范围内只剩 i 时，退出循环，在循环外与目标值进行比较
        return (a[i] == target) ? i : -1;
    }

    /**
     * 二分查找 Java版
     */
    public static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    /**
     * 二分查找 LeftMost 找重复元素最左边的
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 找到则返回最靠左索引 找不到则返回 -1
     *
     */
    public static int binarySearchLeftMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] > target)
                j = mid - 1;
            else if (target > a[mid])
                i = mid + 1;
            else {
                // 记录候选位置
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 RightMost 找重复元素最右边的
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 找到则返回最靠左索引 找不到则返回 -1
     *
     */
    public static int binarySearchRightMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] > target)
                j = mid - 1;
            else if (target > a[mid])
                i = mid + 1;
            else {
                // 记录候选位置
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 LeftMost 找重复元素最左边的 - 改进版
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 返回大于等于 target 的最靠左索引位置
     *
     */
    public static int binarySearchLeftMost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 二分查找 RightMost 找重复元素最右边的 - 改进版
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标
     * @return 返回小于等于 target 的最靠右索引位置
     *
     */
    public static int binarySearchRightMost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }

    /**
     * 应用
     *
     * 范围查询
     * 求排名：leftmost(target) + 1
     * 求前任：leftmost(target) - 1
     * 求后任：rightmost(target) + 1
     * 求最近邻居：前任和后任距离更近者
     */

}
