package cn.xyf.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Xuyifeng
 * @description Leetcode435 无重叠区间本质就是活动选择问题
 * @date 2025/2/10 16:14
 */

public class ActivitySelectionProblem {

    /*
        要在一个会议室举办 n 个活动
        - 每个活动有它们各自的起始和结束时间
        - 找出在时间上互不冲突的活动组合，能够最充分利用会议室（举办的活动次数最多）

        例1
            0   1   2   3   4   5   6   7   8   9
                |-------)
                    |-------)
                        |-------)
        例2
            0   1   2   3   4   5   6   7   8   9
                |---)
                        |---)
            |-----------------------)
                                |-------)
                                            |---)
                                |---------------)





        几种贪心策略
        1. 优先选择持续时间最短的活动
            0   1   2   3   4   5   6   7   8   9
                |---------------)
                            |-------)
                                |---------------)

        2. 优先选择冲突最少的活动
            0   1   2   3   4   5   6   7   8   9
            |-------)                                       3
                |-------)                                   4
                |-------)                                   4
                |-------)                                   4
                    |-------)                               4
                        |-------)                           2
                            |-----------)                   4
                                    |-------)               4
                                    |-------)               4
                                    |-------)               4
                                        |-------)           3

        3. 优先选择最先开始的活动
            0   1   2   3   4   5   6   7   8   9
            |-----------------------------------)
                |---)
                    |---)
                        |---)

        4. 优先选择最先结束的活动
     */

    static class Activity {
        int index;
        int start;
        int finish;

        public Activity(int index, int start, int finish) {
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "Activity(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(0, 1, 3),
                new Activity(1, 2, 4),
                new Activity(2, 3, 5)
        };
        Arrays.sort(activities, Comparator.comparingInt(Activity::getFinish));
//        Activity[] activities = new Activity[]{
//                new Activity(0, 1, 2),
//                new Activity(1, 3, 4),
//                new Activity(2, 0, 6),
//                new Activity(3, 5, 7),
//                new Activity(4, 8, 9),
//                new Activity(5, 5, 9)
//        };
        select(activities, activities.length);
    }

    public static void select(Activity[] activities, int n) {
        List<Activity> result = new ArrayList<>();
        int i, j;
        i = 0;
        result.add(activities[i]);
        for (j = 1; j < n; j++) {
            if (activities[j].start >= activities[i].finish) {
                result.add(activities[j]);
                i = j;
            }
        }
        System.out.println(result);
    }

}
