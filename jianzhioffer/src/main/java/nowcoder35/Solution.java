package nowcoder35;

import java.util.Stack;

/**
 * @author YaboSun
 *
 * 输入两个链表，找出它们的第一个公共结点
 */
public class Solution {

    // 解决思路(没通过测试用例)：
    // 两个链表如果有重合的地方那么肯定是之后都重合
    // 通过使用两个辅助栈实现从后往前进行比较，依次将两个链表结点入栈，直到节点值不相同为止
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode node = new ListNode(0);
        while (pHead1.next != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        stack1.push(pHead1);

        while (pHead2.next != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        stack2.push(pHead2);

        while (stack1.pop() != null && stack2.pop() != null) {
            if (stack1.pop().val == stack2.pop().val) {
                stack1.pop();
                stack2.pop();
            } else {
                node = stack1.pop();
            }
        }

        return node;
    }


    // 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
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

    // 辅助内部类
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
