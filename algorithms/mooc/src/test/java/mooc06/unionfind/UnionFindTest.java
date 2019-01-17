package mooc06.unionfind;


import mooc06.unionfind.utils.UnionFindTestHelper;

/**
 * @author YaboSun
 */
public class UnionFindTest {

    // 测试UnionFind1
    public static void main(String[] args) {
        int n = 100000;

        // TODO 这里我测出来第二种比第一种还要慢！？
        UnionFindTestHelper.testUF1(n);
        UnionFindTestHelper.testUF2(n);
        UnionFindTestHelper.testUF3(n);
        UnionFindTestHelper.testUF4(n);
    }
}