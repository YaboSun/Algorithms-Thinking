package cyc;

import java.util.ArrayList;

/**
 * @author transwarp
 * @date 19-5-25
 */
public class PrintListFromTailToHead06 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {


        ListNode pre = new ListNode(-1);

        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = pre.next;
            pre.next = listNode;
            listNode = next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        pre = pre.next;

        while (pre != null) {
            ret.add(pre.val);
            pre = pre.next;
        }

        return ret;
    }


    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        ArrayList<Integer> ret = new ArrayList<>();

        if (listNode != null) {
            ret.addAll(printListFromTailToHead1(listNode.next));
            ret.add(listNode.val);
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

