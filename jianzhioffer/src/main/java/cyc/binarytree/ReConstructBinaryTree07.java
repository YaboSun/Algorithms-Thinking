package cyc.binarytree;

import java.util.HashMap;

/**
 * @author transwarp
 * @date 19-5-29
 *
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class ReConstructBinaryTree07 {

    private HashMap<Integer, Integer> indexForInOrders = new HashMap<>();
    /**
     *
     * @param pre 前序遍历
     * @param in 中序遍历
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {

        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {

        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int index = indexForInOrders.get(root.val);
        int leftTreeSize = index - inL;

        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);

        return root;

    }


    /**
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree1(pre,0,pre.length-1,
                in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree1(int [] pre, int startPre, int endPre,
                                           int [] in, int startIn, int endIn)  {

        // 输入的前序遍历以及后序遍历应该符合起始要求
        if(startPre > endPre || startIn > endIn) {
            return null;
        }
        // 前序遍历对应的第一个结点应该是二叉树的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        /**
         * 核心实现，主要思路就是左右子树进行递归重建
         * 根据前序数组确定根结点，根据中序遍历找到根节点位置，并分为左右子树，依次进行递归实现
         */
        for(int i = startIn; i <= endIn; i++) {
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree1(pre,startPre + 1,startPre + i - startIn,
                        in,startIn,i - 1);
                root.right = reConstructBinaryTree1(pre,i - startIn + startPre + 1, endPre,
                        in,i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startIn > endIn || startPre > endPre) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree2(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree2(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}

