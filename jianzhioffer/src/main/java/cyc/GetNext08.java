package cyc;

/**
 * @author transwarp
 * @date 19-6-13
 */
public class GetNext08 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        /* 如果该节点右子树不为空，右子树最左节点就是下一节点 */
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

