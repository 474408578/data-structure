package lovealgotithms.LinearList.queue;

import lovealgotithms.LinearList.LinkedList.doubleLinkedList.DoubleLinkedList;
import lovealgotithms.LinearList.List;

/**
 * 双端队列：能够在头尾两端进行添加和删除
 */
public class Deque<E> {
    List<E> list = new DoubleLinkedList<>();
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    // 从队尾入队
    public void enQueueRear(E element) {
        list.add(element);
    }

    // 从队头出队
    public E deQueueFront() {
        return list.remove(0);
    }

    // 从头部入队
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    // 从尾部出队
    public E deQueu() {
        return list.remove(list.size() - 1);
    }

    // 获取队列的头元素
    public E front() {
        return list.get(0);
    }

    // 获取队列的尾元素
    public E rear() {
        return list.get(list.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) sb.append(", ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
