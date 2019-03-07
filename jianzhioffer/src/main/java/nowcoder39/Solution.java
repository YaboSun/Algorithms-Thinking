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
    // 因为之前每次是从
    public boolean IsBalanced_Solution2(TreeNode root) {

        return false;
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
