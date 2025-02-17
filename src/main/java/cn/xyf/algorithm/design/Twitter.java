package cn.xyf.algorithm.design;

import java.util.*;

/**
 * @author Xuyifeng
 * @description 设计推特 - Leetcode355
 * @date 2025/2/17 19:21
 */

public class Twitter {

    private final Map<Integer, User> userMap = new HashMap<>();

    private static int time;

    public Twitter() {

    }

    // 发布文章
    public void postTweet(int userId, int tweetId) {
        User user = userMap.computeIfAbsent(userId, User::new);
        user.head.next = new Tweet(tweetId, time++, user.head.next);

    }

    // 获取最新10篇文章（包括自己和关注用户）
    public List<Integer> getNewsFeed(int userId) {
        User user = userMap.get(userId);
        if (user == null) {
            return List.of();
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<>(Comparator.comparingInt(Tweet::getTime));
        if (user.head.next != null) {
            queue.offer(user.head.next);
        }
        for (Integer id : user.followees) {
            User followee = userMap.get(id);
            if (followee.head.next != null) {
                queue.offer(followee.head.next);
            }
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            Tweet max = queue.poll();
            res.add(max.id);
            if (max.next != null) {
                queue.offer(max.next);
            }
            count++;
        }
        return res;
    }

    // 新增关注
    public void follow(int followerId, int followeeId) {
        User user = userMap.computeIfAbsent(followerId, User::new);
        User followee = userMap.computeIfAbsent(followeeId, User::new);
        user.followees.add(followee.id);
    }

    // 取消关注
    public void unfollow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user != null) {
            user.followees.remove(followeeId);
        }
    }

    static class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time, Tweet next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }
    }

    static class User {
        int id;

        public User(int id) {
            this.id = id;
        }

        Set<Integer> followees = new HashSet<>();
        Tweet head = new Tweet(-1, -1, null);
    }

}
