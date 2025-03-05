package cn.xyf.代码随想录.数组.二分查找.相关题目推荐;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/5 20:51
 */

public class Leetcode367 {
    // 和Leetcode69题思路一样，只需要处理最终的结果就行
    public boolean isPerfectSquare(int num) {
        int i = 1;
        int j = num;
        int r = 0;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            // 用除法代替乘法防止溢出（等同于 mid*mid <= x）
            if (mid <= num / mid) {
                i = mid + 1; // 向右半区继续查找更大的可能值
                r = mid; // 当前mid是候选解，先记录下来
            } else {
                j = mid - 1;
            }
        }
        if (r * r == num)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode367().isPerfectSquare(14));
    }
}
