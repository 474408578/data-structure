package lovealgotithms.LinearList.LinkedList.singleLinkedlist;

import lovealgotithms.LinearList.List;

public class SingleLinkedListAddVirtualHeadNodeTest {
    public static void main(String[] args) {
        List<Integer> list = new SingleLinkedListAddVirtualHeadNode<>();
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
