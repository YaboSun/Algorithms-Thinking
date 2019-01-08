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
}
