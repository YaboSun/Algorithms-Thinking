package nowcoder03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YaboSun
 *
 * 排行榜第一解法
 */
public class SolutionTwo {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.getVal());
            listNode = listNode.getNext();
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private class ListNode {
        private int val; // 数据域
        private ListNode next = null; // 存放后继节点指针域

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
