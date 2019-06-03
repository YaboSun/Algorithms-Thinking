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
            /** 先相当于备份一份链表 */
            ListNode next = listNode.next;
            /** 将第一个节点从原链表中分离出来 */
            listNode.next = pre.next;
            /** 将分离出来的节点插入到头结点下一个构成一个新的链表 */
            pre.next = listNode;
            /** 更新当前要操作的链表头 */
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


    /**
     * 递归版本
     * @param listNode
     * @return
     */
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

