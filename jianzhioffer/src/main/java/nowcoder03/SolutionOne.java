package nowcoder03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YaboSun
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 * 初步思路就是可以直接遍历链表所有节点，并加入一个栈中，
 * 最后根据栈的特点先进后出
 *
 * 还有就是从找到链表尾然后再执行倒序添加
 */
public class SolutionOne {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // 定义一个临时栈存放从头到尾读取的链表数据
        Stack<ListNode> temp = new Stack<>();

        ListNode pNode = listNode;
        while (pNode != null) {
            temp.push(pNode);
            pNode = pNode.getNext();
        }

        while (!temp.empty()) {
            pNode = temp.peek();
            arrayList.add(pNode.getVal());
            temp.pop();
        }
        return arrayList;
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
