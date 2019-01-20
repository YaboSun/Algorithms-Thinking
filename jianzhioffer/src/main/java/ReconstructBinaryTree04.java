/**
 * @author YaboSun
 *
 *  * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *  * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 *  * 则重建二叉树并返回。
 *  *
 *  * 初步思路
 *  * 使用递归实现二叉树重建
 *  * 先通过前序遍历确定二叉树根节点
 */
public class ReconstructBinaryTree04 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,
                in,0,in.length-1);
        return root;
    }
    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}

    /**
     * 递归重建二叉树核心代码
     * @param pre 前序遍历数组
     * @param startPre 前序遍历开始结点 默认从0开始
     * @param endPre 前序遍历结束结点 默认为数组最大值
     * @param in 中序遍历数组
     * @param startIn 中序遍历开始结点 默认从0开始
     * @param endIn 中序遍历结束结点 默认为数组最大值
     * @return 返回重建的二叉树
     */
    private TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre,
                                           int [] in, int startIn, int endIn)  {

        // 输入的前序遍历以及后序遍历应该符合起始要求
        if(startPre > endPre || startIn > endIn)
            return null;
        // 前序遍历对应的第一个结点应该是二叉树的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        /**
         * 核心实现，主要思路就是左右子树进行递归重建
         * 根据前序数组确定根结点，根据中序遍历找到根节点位置，并分为左右子树，依次进行递归实现
         */
        for(int i = startIn; i <= endIn; i++) {
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre,startPre + 1,startPre + i - startIn,
                        in,startIn,i - 1);
                root.right = reConstructBinaryTree(pre,i - startIn + startPre + 1, endPre,
                        in,i + 1, endIn);
                break;
            }
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
