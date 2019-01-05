package hw201601.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author YaboSun
 */
public class SolutionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 存放N、M
            int[] firstLine = {scanner.nextInt(), scanner.nextInt()};
            int N = firstLine[0];
            int M = firstLine[1];

            // 动态数组用于存放学生分数
            List<Integer> studentScores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                studentScores.add(scanner.nextInt());
            }

            // 后面每一行字符位
            char c;
            // 字符后俩位整数
            int A, B;
            // 用于遍历后面每一行
            int m = 0;
            for (; m < M; m++) {
                c = scanner.next().charAt(0);
                A = scanner.nextInt();
                B = scanner.nextInt();

                if (c == 'Q') {
                    int start, end; // 定义操作数下标
                    // 正常输入 从左到右
                    if (A < B) {
                        start = A - 1;
                        end = B - 1;
                    } else {
                        start = B - 1;
                        end = A - 1;
                    }

                    int max = studentScores.get(start); // 从第一个开始进行比较得到最高分数
                    for (int i = start + 1; i <= end; i++) {
                        max = Math.max(max, studentScores.get(i));
                    }
                    System.out.println(max);
                }

                if (c == 'U') {
                    int index = A - 1;
                    int newValue = B;
                    studentScores.set(index, newValue);
                }
            }
        }
        scanner.close();
    }
}
