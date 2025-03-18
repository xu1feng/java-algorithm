package cn.xyf.代码随想录.哈希表.有效的字母异位词.相关题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/14 21:14
 */

public class Leetcode438 {

    // 定长滑窗
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // 统计 p 的字母
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }

    // 不定长滑窗
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26]; // 统计 p 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]--; // 右端点字母进入窗口
            while (cnt[c] < 0) { // 字母 c 太多了
                cnt[s.charAt(left) - 'a']++; // 左端点字母离开窗口
                left++;
            }
            if (right - left + 1 == p.length()) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
        }
        return ans;
    }

    // 我自己写的，时间复杂度太高了，虽然能通过
    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) return res;
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String pSorted = new String(pArr);
        for (int i = 0; i <= sLen - pLen; i++) {
            String sub = s.substring(i, i + pLen);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            if (Arrays.equals(pArr, subArr)) { // 直接比较数组更高效
                res.add(i);
            }
        }
        return res;
    }

}
