package cn.xyf.pat.yi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 16:47
 */

public class Test15 {

    /*
        考生总数N    最低分数线L  优先录取线H 这里的H默认是>L的
        德分>=L && 才分>=L -> 有资格被录取

        第一类考生：德分>=H && 才分>=H -> 才德全尽
        第二类考生：德分>=H && L=<才分<H -> 德胜才
        第三类考生：德分<H && L=<才分<H && 德分>=才分 -> 才德兼亡但尚有德
        第四类考生： L=<德分<H && L=<才分<H

        排序规则：按德才总分从高到低排序
     */

    // 学生类
    static class Student {
        int id;
        int de;
        int cai;

        public Student(int id, int de, int cai) {
            this.id = id;
            this.de = de;
            this.cai = cai;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 人数
        int L = scanner.nextInt(); // 国家线
        int H = scanner.nextInt(); // 院线

        // 初始化四个分类
        // 这里的categories相当于是个二维数组，只不过是4*N的
        List<Student>[] categories = new List[4];
        for (int i = 0; i < 4; i++) {
            categories[i] = new ArrayList<>();
        }

        int qualified = 0; // 通过国家线的人数
        for (int i = 0; i < N; i++) {
            int id = scanner.nextInt();
            int de = scanner.nextInt();
            int cai = scanner.nextInt();

            if (de < L || cai < L) continue; // 没有通过国家线就跳过

            // 以下逻辑是通过国家线的

            qualified++; // 通过国家线的人数++
            Student stu = new Student(id, de, cai);

            // 分类逻辑
            if (de >= H && cai >= H) {
                categories[0].add(stu);
            } else if (de >= H && cai >= L) {
                categories[1].add(stu);
            } else if (de >= cai && de < H && cai < H) {
                categories[2].add(stu);
            } else {
                categories[3].add(stu);
            }
        }

        // 定义比较器
        Comparator<Student> comparator = (s1, s2) -> {
            int sum1 = s1.de + s1.cai;
            int sum2 = s2.de + s2.cai;
            if (sum1 != sum2) return sum2 - sum1;
            if (s1.de != s2.de) return s2.de - s1.de;
            return s1.id - s2.id;
        };

        // 排序并输出
        System.out.println(qualified);
        for (List<Student> list : categories) {
            list.sort(comparator);
            for (Student s : list) {
                System.out.printf("%d %d %d\n", s.id, s.de, s.cai);
            }
        }
    }

}
