package nowcoder26;

import java.util.Stack;

/**
 * @author YBSun
 * Created in 2019-01-14
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class SolutionOne {

    /********************************************************
     *                      第一种实现 非递归
     * 解题思路：
     * 1.核心是中序遍历的非递归算法。
     * 2.修改当前遍历节点与前一遍历节点的指针指向
     * ******************************************************/
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null; // 用于保存中序遍历的上一节点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left; // 中序遍历先将左子树最小节点入栈
            }
            p = stack.pop();
            if (isFirst) {
                pRootOfTree = p; // 将中序遍历中的第一个节点记为root
                pre = pRootOfTree; //
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    /********************************************************
     *                      第二种实现 递归
     * 解题思路：
     * 1.将左子树构造成双链表，并返回链表头节点。
     * 2.定位至左子树双链表最后一个节点。
     * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     * 4.将右子树构造成双链表，并返回链表头节点。
     * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     * 6.根据左子树链表是否为空确定返回的节点。
     * ******************************************************/
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        // 将左子树构造成链表并返回链表头节点
        TreeNode left = Convert2(pRootOfTree.left);
        TreeNode p = left;
        // 定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 如果左子树链表不为空的话 将当前root追加到左子树
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        // 将右子树构造成双链表 并返回链表头节点
        TreeNode right  = Convert2(pRootOfTree.right);
        // 如果右子树链表不为空 将当前根节点追加到右子树
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left != null ? left : pRootOfTree;

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
