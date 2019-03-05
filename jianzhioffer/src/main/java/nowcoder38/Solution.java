package nowcoder38;

/**
 * @author YaboSun
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class Solution {
    // 初步思路，递归遍历左右子树
    // 需要记录最长路径以及tmp长度，
    // 每次遍历完一个路径就和当前最长路径进行比较
    // 如果tmp > max则 max = tmp，否则继续

    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left),
                TreeDepth(root.right));
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
