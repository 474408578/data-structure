package lovealgotithms.LinearList.queue;

/**
 * 循环队列：
 *  front为队头，存储队头的下标
 * @param <E>
 */
public class CircleQueue<E> {
    // 队头存储下标，初始值为0
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;


    public CircleQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircleQueue(int capacity) {
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

    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
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

    /**
     * 出队
     * @return
     */
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        // 队头往前挪一位
        front = index(1);
        size--;
        return frontElement;
    }

    // 获取队头元素
    public E front() {
        return elements[front];
    }

    // front 上的基准
    private int index(int index) {
        index += front;
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
