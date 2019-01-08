package nowcoder03;

/**
 * @author YaboSun
 */
public class ListNode {
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
