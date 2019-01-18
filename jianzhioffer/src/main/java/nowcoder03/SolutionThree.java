package nowcoder03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YaboSun
 */
public class SolutionThree {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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

        public ListNode(int val) {
            this.val = val;
        }
    }
}
