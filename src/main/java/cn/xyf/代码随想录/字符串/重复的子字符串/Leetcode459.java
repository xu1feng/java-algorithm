package cn.xyf.代码随想录.字符串.重复的子字符串;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/20 21:38
 */

public class Leetcode459 {

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

}
