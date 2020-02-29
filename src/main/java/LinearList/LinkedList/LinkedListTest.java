package LinearList.LinkedList;

import LinearList.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(40);
        // size=4, [20, 10, 30, 40]
        System.out.println(list);

    }

}
