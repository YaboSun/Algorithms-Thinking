
public class EntryNodeOfLoop {


    // 自己写的 有问题 贼垃圾哈哈哈
    public ListNode entryNodeOfLoop1(ListNode pHead) {
        // 定义返回值
        ListNode ret = null;

        // 先获得链表长度
        int len = 0;
        while (pHead.next != null) {
            len++;
            pHead = pHead.next;
        }

        // 只有三个或三个以上节点才能构成环
        if (len < 3) {
            return null;
        } else {
            // 定义快慢指针
            ListNode pSlow = pHead.next;
            ListNode pFast = pHead.next.next;

            while (pFast != null) {
                if (pSlow == pFast) {
                    ret = pSlow;
                    break;
                }
                pSlow = pSlow.next;
                pFast = pFast.next;
            }
        }

        return ret;
    }

    /**
     * 思路：
     * 先判断是否存在环，如果存在环，
     * 找环的入口点，如果不存在，直接返回null
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        // 判断是否存在环
        while (slow != fast) {
            // 循环结束条件是快慢指针是否相遇
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }

        // 循环如果退出的话那一定是有fast == slow
        // 找到环的入口节点，通过
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * cyc大佬极度简化代码 真的强
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
