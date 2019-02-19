package nowcoder36;

/**
 * @author YaboSun
 *
 * 输入两个链表，找出它们的第一个公共结点
 */
public class Solution {
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        // 计算两个链表的长度
        int count1 = 0; // 记录第一个链表长度
        int count2 = 0; // 记录第二个链表长度
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            p1 = p1.next;
            count1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            count2++;
        }

        // 通过两链表长度差位置开始一起走
        int flag = count1 - count2;
        if (flag <= 0) {
            while (flag < 0) {
                pHead2 = pHead2.next;
                flag++;
            }
            while (pHead1 != pHead2) {
                pHead2 = pHead2.next;
                pHead1 = pHead1.next;
            }
            return pHead1;
        } else {
            while (flag > 0) {
                pHead1 = pHead1.next;
                flag--;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
    }

    // 上一种解法的简化版 思路类似
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }

        return p1;
    }
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
