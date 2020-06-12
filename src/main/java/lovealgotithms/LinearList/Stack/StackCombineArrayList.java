package lovealgotithms.LinearList.Stack;

import lovealgotithms.LinearList.DynamicArray.ArrayList;
import lovealgotithms.LinearList.List;

/**
 * 栈和动态数组类似，使用在栈中使用动态数组来实现栈的基本操作
 * @param <E>
 */

public class StackCombineArrayList<E> {
    List<E> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void push(E element) {
        list.add(element);
    }

    public void clear() {
        list.clear();
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素
     */
    public E top() {
        return list.get(list.size() - 1);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
