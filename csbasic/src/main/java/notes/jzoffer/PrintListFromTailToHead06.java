package notes.jzoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YaboSun
 */
public class PrintListFromTailToHead06 {

    /**
     * 解法一 使用栈实现
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty())
            list.add(stack.pop());

        return list;
    }

    /**
     * 解法二 使用递归
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.addAll(printListFromTailToHead1(listNode.next));
            list.add(listNode.val);
        }

        return list;
    }

    /**
     * 解法三 头插法
     * 这种方式会改变链表结构,将链表翻转
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode node) {
        // 头插法构建逆序链表
        ListNode preNode = new ListNode(-1);
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = preNode.next;
            preNode.next = node;
            node = nextNode;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        preNode = preNode.next;
        while (preNode != null) {
            ret.add(preNode.val);
            preNode = preNode.next;
        }
        return ret;
    }
    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
