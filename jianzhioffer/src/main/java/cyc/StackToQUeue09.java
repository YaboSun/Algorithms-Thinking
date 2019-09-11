package cyc;

import java.util.Stack;

/**
 * @author transwarp
 * @date 19-6-14
 *
 * 用两个栈实现队列,队列中的元素为int类型。
 */
public class StackToQUeue09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int pop = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return pop;
    }
}

