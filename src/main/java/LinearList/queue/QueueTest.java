package LinearList.queue;

public class QueueTest {
    public static void main(String[] args) {
//        QueueUseArrayList<Integer> queue = new QueueUseArrayList<>();
//        QueueUseDoubleLinkedList<Object> queue = new QueueUseDoubleLinkedList<>();
        Deque<Integer> queue = new Deque<>();
        queue.enQueueFront(2);
        queue.enQueueRear(7);
        queue.enQueueFront(7);
        queue.enQueueRear(3);
        queue.enQueueRear(6);
        queue.enQueueFront(5);
        System.out.println(queue);
        queue.deQueueFront();
        System.out.println(queue);
        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue);
    }
}
