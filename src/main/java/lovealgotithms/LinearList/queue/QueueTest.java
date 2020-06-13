package lovealgotithms.LinearList.queue;

public class QueueTest {
    static void  test() {
        CircleQueue<Integer> queue = new CircleQueue<>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }

        for (int i = 15; i < 30; i++) {
            queue.enQueue(i);
        }

        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    static void test2() {
        CircleDeque<Integer> queue = new CircleDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }
        //
        System.out.println(queue);
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }

        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }
    }

    public static void main(String[] args) {
//        test();
    test2();

    }
}
