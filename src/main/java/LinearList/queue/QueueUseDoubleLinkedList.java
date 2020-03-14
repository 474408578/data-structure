package LinearList.queue;

import LinearList.LinkedList.doubleLinkedList.DoubleLinkedList;
import LinearList.List;

/**
 * 使用双向链表实现队列
 * 由于队列的主要操作在队头和队尾，所以推荐使用双向链表进行实现
 * @param <E>
 */
public class QueueUseDoubleLinkedList<E> {
    List<E> list = new DoubleLinkedList<>();
    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(0, element);
    }

    public E deQueue() {
        return list.remove(list.size() - 1);
    }

    public E front() {
        return list.get(0);
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
