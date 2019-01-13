package mooc06.unionfind;


import mooc06.unionfind.utils.UnionFindTestHelper;

/**
 * @author YaboSun
 */
public class UnionFindTest {

    // 测试UnionFind1
    public static void main(String[] args) {
        int n = 100000;

        UnionFindTestHelper.testUF1(n);
        UnionFindTestHelper.testUF2(n);
    }
}