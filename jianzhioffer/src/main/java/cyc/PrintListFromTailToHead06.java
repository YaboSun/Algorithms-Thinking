package cyc;

import java.util.ArrayList;

/**
 * @author transwarp
 * @date 19-5-25
 */
public class PrintListFromTailToHead06 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {


        ListNode pre = new ListNode(-1);

        while (listNode.next != null) {
            ListNode next = listNode.next;
            listNode.next = pre.next;
            pre.next = listNode;
            listNode = next;
        }

        ArrayList<Integer> ret = new ArrayList<>(100);
        pre = pre.next;

        while (pre != null) {
            ret.add(pre.val);
            pre = pre.next;
        }

        return ret;
    }

    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}

