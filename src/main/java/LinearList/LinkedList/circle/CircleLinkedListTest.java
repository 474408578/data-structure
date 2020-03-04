package LinearList.LinkedList.circle;

import LinearList.List;

public class CircleLinkedListTest {
    public static void main(String[] args) {
        List<Integer> list = new CircleLinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(40);
        // size=4, [10, 20, 30, 40]
        System.out.println(list);

        list.remove(3);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }

}
