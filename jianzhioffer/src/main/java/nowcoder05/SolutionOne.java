package nowcoder05;

import java.util.Stack;

/**
 * @author YaboSun
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：
 * 使用stack1进行push，如果想要pop的时候先将stack1进行pop，并push到stack中，最后将stack2进行pop操作
 */
public class SolutionOne {
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
