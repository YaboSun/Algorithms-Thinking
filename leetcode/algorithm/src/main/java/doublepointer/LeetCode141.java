package doublepointer;

/**
 * @author YaboSun
 *
 * 给定一个链表以及链表尾指向的节点下标，判断是否有环
 *
 * 初步思路 设置俩个指针 一个每次移动1个节点，一个每次移动2个节点
 * 如果相遇 那么一定存在环
 */
public class LeetCode141 {

    // -----------------------------自己想法-----------------------------------
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    // ------------------------------notebook--------------------------------
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }



    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
