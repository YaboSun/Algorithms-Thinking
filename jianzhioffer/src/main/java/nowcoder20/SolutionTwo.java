package nowcoder20;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author YaboSun
 *
 * 时间复杂度为O(1)
 *
 * 讨论区高赞
 */

public class SolutionTwo {
    /*借用辅助栈存储min的大小，自定义了栈结构*/
    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<>();
    private Integer[] elements = new Integer[10];
    public void push(int node) {
        ensureCapacity(size + 1);
        elements[size++] = node;
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
        //    System.out.println(min+"");
    }

    // 原生代码判断条件
    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if(size > len){
            int newLen = (len*3)/2+1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    public void pop() {
        Integer top = top();
        if(top != null){
            elements[size-1] = (Integer) null;
        }
        size--;
        minStack.pop();
        min = minStack.peek();
        //    System.out.println(min+"");
    }

    public int top() {
        if(!empty()){
            if(size-1>=0)
                return elements[size-1];
        }
        return (Integer) null;
    }
    public boolean empty(){
        return size == 0;
    }

    public int min() {
        return min;
    }
}
