import java.util.Stack;

/**
 * @author YaboSun
 */
public class TwoStackQueue05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 将第一个栈中所有元素存放在第二个栈中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // 第二个栈顶输出的就是队列输出的元素
        int pop = stack2.pop();
        // 再将第二个栈中的所有元素放回第一个栈中
        // 维持后面的push操作
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return pop;
    }
}
