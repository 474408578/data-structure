package wangzhen._09_queue;

/**
 * 基于链表实现的队列:
 *  队空：head == null
 *  队满：链表是无界的
 */
public class QueueBaseOnLinkedList<T> {

    // 队列的队首和队尾
    private Node<T> head = null;
    private Node<T> tail = null;

    // 入队
    public void enqueue(T value) {
        // 空队列
        if (tail == null) {
            Node<T> newNode = new Node<>(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node<>(value, null);
            tail= tail.next;
        }
    }

    // 出队
    public T dequeue() {
        if (head == null) return null;

        T value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node<T> p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        QueueBaseOnLinkedList<Integer> queue = new QueueBaseOnLinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.printAll();
        queue.dequeue();
        queue.printAll();
    }
}
