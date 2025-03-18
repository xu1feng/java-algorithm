package cn.xyf.代码随想录.数组.长度最小的子数组.相关题目推荐;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/7 20:31
 */

public class Leetcode904 {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            cnt.merge(fruits[right], 1, Integer::sum); // fruits[right] 进入窗口
            while (cnt.size() > 2) { // 不满足要求
                int out = fruits[left];
                cnt.merge(out, -1, Integer::sum); // fruits[left] 离开窗口
                if (cnt.get(out) == 0) {
                    cnt.remove(out);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode904().totalFruit(new int[]{1, 2, 1}));
    }
}
