package leetcode.linkedList;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * 解决方案：
 *      两个栈：inStack, outStack
 *      入队时，push到inStack
 *      出队时：
 *          如果outStack为空，将inStack所有元素逐一弹出，push到outStack，outStack弹出栈顶元素
 *          如果outStack不为空，弹出outStack栈顶元素即可。
 */
public class _232_ImplementQueueusingStacks {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public _232_ImplementQueueusingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**入队 */
    public void push(int x) {
        inStack.push(x);
    }

    /** 出队*/
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** 获取队头元素*/
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /** 判断是否为空*/
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
