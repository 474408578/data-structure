package LinearList.queue;

import LinearList.DynamicArray.ArrayList;
import LinearList.List;

/**
 * 使用动态数组实现队列
 *
 *
 * @param <E>
 */
public class QueueUseArrayList<E> {
    List<E> list = new ArrayList<>();
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

    public boolean isEmpty() {
        return list.isEmpty();
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
