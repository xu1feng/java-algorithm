package cn.xyf.algorithm.design;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Xuyifeng
 * @description TinyURL加密与解密 Leetcode535
 * @date 2025/2/17 18:39
 */

public class Codec {

    /*
        要让【长】【短】网址一一对应

            1. 用【随机数】作为短网址标识
            2. 用【hash码】作为短网址标识
            3. 用【递增数】作为短网址标识
                1) 多线程下可以使用吗？
                2) 分布式下可以使用吗？
                3) 4e9iAk 是怎么生成的？

                a-z 0-9 A-Z  62进制的数字

        0   1   2   3   4   5   6   7   8   9   a   b   c   d   e   f

        十进制 => 十六进制
        31       1f

        31 % 16 = 15
        31 / 16 = 1

        1 % 16 = 1
        1 / 16 = 0


        长网址： https://leetcode.cn/problems/encode-and-decode-tinyurl/description/
        对应的短网址： http://tinyurl.com/4e9iAk
     */

    private Map<String, String> longToShort = new HashMap<>();

    private Map<String, String> shortToLong = new HashMap<>();

    private static final String SHORT_PREFIX = "http://tinyurl.com/";

    public String encode(String longUrl) {
        String shortUrl = longToShort.get(longUrl);
        if (shortUrl != null) {
            return shortUrl;
        }
        // 生成短网址
        while (true) {
            int id = ThreadLocalRandom.current().nextInt();
            shortUrl = SHORT_PREFIX + id;
            if (!shortToLong.containsKey(shortUrl)) {
                longToShort.put(longUrl, shortUrl);
                shortToLong.put(shortUrl, longUrl);
                break;
            }
        }
        return shortUrl;
    }

    public String decode(String shortUrl) {
        // 从 shortToLong 中查找对应的长网址
        return shortToLong.get(shortUrl);
    }

    static class CodecHashCode {
        private Map<String, String> longToShort = new HashMap<>();

        private Map<String, String> shortToLong = new HashMap<>();

        private static final String SHORT_PREFIX = "http://tinyurl.com/";

        public String encode(String longUrl) {
            String shortUrl = longToShort.get(longUrl);
            if (shortUrl != null) {
                return shortUrl;
            }
            // 生成短网址
            int id = longUrl.hashCode();
            while (true) {
                shortUrl = SHORT_PREFIX + id;
                if (!shortToLong.containsKey(shortUrl)) {
                    longToShort.put(longUrl, shortUrl);
                    shortToLong.put(shortUrl, longUrl);
                    break;
                }
                id++;
            }
            return shortUrl;
        }

        public String decode(String shortUrl) {
            // 从 shortToLong 中查找对应的长网址
            return shortToLong.get(shortUrl);
        }
    }

    static class CodecSequence {
        private static final char[] toBase62 = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        public static String toBase62(int number) {
            if (number == 0) {
                return String.valueOf(toBase62[0]);
            }
            StringBuffer sb = new StringBuffer();
            while (number > 0) {
                int r = number % 62;
                sb.append(toBase62[r]);
                number = number / 62;
            }
            return sb.toString();
        }

        private Map<String, String> longToShort = new HashMap<>();

        private Map<String, String> shortToLong = new HashMap<>();

        private static final String SHORT_PREFIX = "http://tinyurl.com/";

        private static int id = 1;

        public String encode(String longUrl) {
            String shortUrl = longToShort.get(longUrl);
            if (shortUrl != null) {
                return shortUrl;
            }
            // 生成短网址
            shortUrl = SHORT_PREFIX + toBase62(id);
            longToShort.put(longUrl, shortUrl);
            shortToLong.put(shortUrl, longUrl);
            id++;
            return shortUrl;
        }

        public String decode(String shortUrl) {
            // 从 shortToLong 中查找对应的长网址
            return shortToLong.get(shortUrl);
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 62; i++) {
//            System.out.println(i + "\t" + CodecSequence.toBase62(i));
//        }
        System.out.println(CodecSequence.toBase62(23489723));
    }

}
