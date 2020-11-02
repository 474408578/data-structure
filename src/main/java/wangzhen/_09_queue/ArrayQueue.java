package wangzhen._09_queue;

/**
 * 数据实现的队列
 * 队空：head == tail
 * 队满：tail == n
 */
public class ArrayQueue<T> {
    private T[] items;
    private int n = 0;
    // head表示队头下标、tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        this.n = capacity;
    }

    // 入队
    public void enqueue(T item) {
        // 扩容
        if (tail == n) {
            // 确实没有空间了，需要扩容
            if (head == 0) {
                resize(2 * n);
            } else {
                // 还有空间，数据搬迁操作
                for (int i = head; i < tail; i++) {
                    items[i-head] = items[i];
                }
                tail -= head;
                head = 0;
            }

        }
        items[tail] = item;
        ++tail;
    }

    // 出队
    public T dequeue() {
        // head == tail说明队列为空
        if (head == tail) return null;

        T temp = items[head];
        ++head;
        return temp;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }
    
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = head; i < tail; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.printAll();
        queue.dequeue();
        queue.printAll();
    }
}
