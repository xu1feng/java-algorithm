package cn.xyf.代码随想录.哈希表.有效的字母异位词.相关题目;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/13 21:28
 */

public class Leetcode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        int[] flag = new int[256];
        for (int i = 0; i < r.length; i++) {
            flag[r[i] - 'a']++;
        }
        for (int i = 0; i < m.length; i++) {
            flag[m[i] - 'a']--;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] > 0) {
                return false;
            }
        }
        return true;
    }

}
