package nowcoder16;

/**
 * @author YBSun
 * Created in 2019-01-09
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则
 *
 * 递归进行比较
 */
public class SolutionOne {

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode mergeList = null;
        if (list1.val < list2.val) {
            mergeList = list1;
            mergeList.next = merge(list1.next, list2);
        } else {
            mergeList = list2;
            mergeList.next = merge(list1, list2.next);
        }
        return mergeList;
    }

    private class ListNode {
        int val; // 数据域
        ListNode next = null; // 存放后继节点指针域

        public ListNode(int val) {
            this.val = val;
        }
    }
}
