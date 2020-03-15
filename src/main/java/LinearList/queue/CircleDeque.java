package LinearList.queue;

/**
 * 循环双端队列
 * @param <E>
 */

public class CircleDeque<E> {
    // 队头存储下标, 不需要尾部的坐标，只需要知道front以及size便可以获取尾部坐标
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;


    public CircleDeque() {
        this(DEFAULT_CAPACITY);
    }

    public CircleDeque(int capacity) {
        capacity = (capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    /**
     * 在尾部添加元素
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }


    // 从头部入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }


    // 动态扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // 获取在数组中的真实索引
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        // 重置front
        front = 0;
    }

    // 从头部出队，与循环队列一样
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    // 获取队头元素
    public E front() {
        return elements[front];
    }

    // 从队尾出队
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    // 返回尾部元素
    public E rear() {
        return elements[index(size - 1)];
    }

    private int index(int index) {
        index += front;
        if (index < 0) {
            return index + elements.length;
        }
        return index - (index >= elements.length ? elements.length : 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity=").append(elements.length)
                .append(", size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
