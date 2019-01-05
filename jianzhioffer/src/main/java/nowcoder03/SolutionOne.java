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
            pNode = pNode.next;
        }

        while (!temp.empty()) {
            pNode = temp.peek();
            arrayList.add(pNode.val);
            temp.pop();
        }
        return arrayList;
    }
}
