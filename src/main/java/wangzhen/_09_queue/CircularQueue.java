package wangzhen._09_queue;

/**
 * 循环队列
 * 队空：head == tail
 * 队满：(tail + 1) % n == head
 *
 * @param <T>
 */
public class CircularQueue<T> {
    private T[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = (T[]) new Object[capacity];
        this.n = capacity;
    }

    // 入队
    public boolean enqueue(T value) {
        // 队满
        if ((tail + 1) % n == head) return false;
        items[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public T dequeue() {
        if (head == tail) return null;
        T temp = items[head];
        head = (head + 1) % n;
        return temp;
    }

    public void printAll() {
        for (int i = head; (i % n) != tail; i = (i + 1)% n) {
            System.out.println(items[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        queue.printAll();
        queue.dequeue();
        queue.printAll();

    }
}
