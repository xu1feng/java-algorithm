package cn.xyf.代码随想录.字符串.反转字符串Ⅱ;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/19 21:46
 */

public class Leetcode541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                swap(chars, start, end);
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(ch, i, ch.length - 1);
        }
        return new String(ch);
    }

    // 定义翻转函数
    public void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
