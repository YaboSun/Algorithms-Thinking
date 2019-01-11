package nowcoder22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YaboSun
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 *
 * 二叉树层次遍历
 * 借助队列实现
 */
public class SolutionOne {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            nodes.add(treeNode.val);
        }
        return nodes;
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
