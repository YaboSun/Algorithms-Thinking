package nowcoder25;

/**
 * @author YaboSun
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 实现步骤主要分三步
 * 插入新节点
 * 建立random链接
 * 拆分
 */
public class SolutionOne {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        // 插入新节点
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next; // 将头结点下一个结点变为clone结点的下一个结点
            cur.next = clone; // 链接头结点和克隆结点
            cur = clone.next; // 从克隆结点下一个结点开始下一次插入
        }

        // 建立random链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next; // 首先建立克隆结点和当前根节点链接
            if (cur.random != null) {
                clone.random = cur.random.next; // 克隆结点的random应该和上一个结点的random是相同的
            }
            cur = clone.next; // 将克隆结点的下一个结点变为当前结点进行下次链接
        }

        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next; // 当前头结点的下一个结点是复制产生的
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next; // 跳过复制的结点实现拆分
            cur = next; // 将当前结点设置为克隆结点并进行下一次拆分
        }
        return pCloneHead;
    }

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
