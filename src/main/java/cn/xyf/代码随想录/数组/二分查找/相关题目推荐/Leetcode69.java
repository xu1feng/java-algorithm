package cn.xyf.代码随想录.数组.二分查找.相关题目推荐;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/4 16:57
 */

public class Leetcode69 {

    public int mySqrt(int x) {
        /*
        99 = 9.?

        9 * 9 = 81
        10 * 10 = 100

        i   j   m
        1   99  50  6次
        1   49  25
        1   24  12
        1   11  6
        7   11  9
        10  11  10
     */
        int i = 1;
        int j = x;
        int r = 0;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            // 用除法代替乘法防止溢出（等同于 mid*mid <= x）
            if (mid <= x / mid) {
                i = mid + 1; // 向右半区继续查找更大的可能值
                r = mid; // 当前mid是候选解，先记录下来
            } else {
                j = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode69().mySqrt(8));
    }
}
