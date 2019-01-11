package bst;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        // 创建一个数组 包含0-1000000所有元素
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        // 测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        for (int i = 0; i < N; i++) {
            bst.insert(arr[i], Integer.toString(arr[i]));
        }

        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(i);
            if (i < N) {
                assert res.equals(Integer.toString(i));
            } else {
                assert res == null;
            }
        }
    }
}