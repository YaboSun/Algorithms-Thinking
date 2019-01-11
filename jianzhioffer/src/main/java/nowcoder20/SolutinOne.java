package nowcoder20;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author YaboSun
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * 时间复杂度不为O(1)实现
 */
public class SolutinOne {
    private Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    // 实现栈顶元素就是栈中最小元素时间复杂度为O(1)
    public int min() {
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (min > tmp) {
                min = tmp;
            }
        }
        return min;
    }
}
