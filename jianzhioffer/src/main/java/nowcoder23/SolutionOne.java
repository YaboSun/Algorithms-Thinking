package nowcoder23;

/**
 * @author YaboSun
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 *
 * 二叉搜索树满足根节点值大于左子节点 小于右子结点
 * 后序遍历最后一个是根节点
 *
 * 递归实现
 */
public class SolutionOne {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    private boolean isTreeBST(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int i = start;
        // 先找到第一个比根节点大的值，根据二叉搜索树特点
        // 从此节点到根节点一定都比根节点值要大
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        // 遍历sequence[i...end],如果出现比sequence[end]小的数则肯定不能构成
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        // i实际上将根节点的左右子树分开 后面递归执行判断是否满足就可以
        return isTreeBST(sequence, start, i - 1) && isTreeBST(sequence, i, end - 1);
    }
}
