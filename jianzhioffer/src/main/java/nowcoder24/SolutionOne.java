package nowcoder24;

import java.util.ArrayList;

/**
 * @author YaboSun
 *
 * 输入一棵二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 深度遍历 别人答案
 */
public class SolutionOne {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) { // 根节点为空直接返回空的list
            return listAll;
        }
        list.add(root.val); // 如果根结点不为空 将根节点对应的值添加到list
        // 默认已经从根节点开始，所以其他加起来为target - root.val即可
        target -= root.val;
        // 如果此时找到叶子节点，且前面相加已经为target，那么就是一条路径
        // 递归的终止条件
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list)); // 这里注意需要重新new一个list的引用
        }
        // 如果当前target不为0，就递归求左右子树
        FindPath(root.left, target);
        FindPath(root.right, target);

        // 这句是关键 深度遍历如果子节点不满足需要退回到父节点继续遍历
        list.remove(list.size() - 1);
        return listAll;
    }

    private class TreeNode {
        private int val = 0;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
