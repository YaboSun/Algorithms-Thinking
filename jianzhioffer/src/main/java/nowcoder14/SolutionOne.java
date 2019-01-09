package nowcoder14;

/**
 * @author YaboSun
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 初步思路：
 * 直接遍历 通过next找到链表尾，设置计数器，每次++，到最后结点再反向遍历，到j - k + 1处
 */
public class SolutionOne {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int count = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        if (count < k)  return null;

        ListNode p = head;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }

        return p;
    }

    private class ListNode {
        int val; // 数据域
        ListNode next = null; // 存放后继节点指针域

        public ListNode(int val) {
            this.val = val;
        }
    }
}
