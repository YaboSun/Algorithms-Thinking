package nowcoder39;

/**
 * @author YaboSun
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {

    // 解法一
    // 最直接的做法就是遍历每个结点，借助一个获取树深度的递归函数
    // 根据该结点的左右子树高度差判断是否平衡
    // 然后递归的对左右子树进行判断
    public boolean IsBalanced_Solution1(TreeNode root) {

        if (root == null) {
            return true;
        }
        // 需要满足左右子树高度差小于等于1
        // 并且左右子树递归都满足这个条件
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
                IsBalanced_Solution1(root.left) && IsBalanced_Solution1(root.right);
    }

    private int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    // 解法二
    // 因为之前判断上层结点时，会多次重复遍历下层结点
    // 增加了不必要的开销
    // 可以直接从下往上遍历
    // 如果子树是平衡二叉树，则返回子树的高度，反之直接停止遍历
    public boolean IsBalanced_Solution2(TreeNode root) {

        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
