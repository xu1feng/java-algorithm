package cn.xyf.代码随想录.哈希表.快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/16 21:48
 */

public class Leetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
