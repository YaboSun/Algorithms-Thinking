import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YaboSun
 *
 *  * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *  *
 *  * 初步思路就是可以直接遍历链表所有节点，并加入一个栈中，
 *  * 最后根据栈的特点先进后出
 *  *
 *  * 还有就是从找到链表尾然后再执行倒序添加
 */
public class PrintList03 {

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // 定义一个临时栈存放从头到尾读取的链表数据
        Stack<ListNode> temp = new Stack<>();

        ListNode pNode = listNode; // 用一个新的结点表示listNode
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

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
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

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> vals = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();

        if(listNode != null) {
            while(listNode != null) {
                stack.push(listNode);
                listNode = listNode.next;
            }
            while(!stack.isEmpty()) {
                int temp = stack.peek().val;
                vals.add(temp);
                stack.pop();
            }
        }
        return vals;
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
