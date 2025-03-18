package cn.xyf.代码随想录.数组.长度最小的子数组.相关题目推荐;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/7 21:54
 */

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            cnt.merge(c, 1, Integer::sum);

            // 收缩窗口：当当前字符计数 >1 时，移动左指针并减少移出字符的计数
            while (cnt.get(c) > 1) {
                char leftChar = chars[left];
                cnt.merge(leftChar, -1, Integer::sum);
                left++;
            }

            ans = Integer.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode3().lengthOfLongestSubstring("abcabcbb"));
    }
}
