package LinearList;

import LinearList.DynamicArray.ArrayList;
import LinearList.LinkedList.circle.CircleLinkedList;
import LinearList.LinkedList.single.SingleLinkedList;
import tools.AssertTool;

public class Main {
    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 65); // [55, 11, 65, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 65, 22, 33, 44, 77]

        list.remove(0); // [11, 65, 22, 33, 44, 77]
        list.remove(2); // [11, 65, 33, 44, 77]
        list.remove(list.size()-1); // [11, 65, 33, 44]


        AssertTool.test(list.indexOf(44) == 3);
        AssertTool.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        AssertTool.test(list.contains(33));
        AssertTool.test(list.get(0) == 11);
        AssertTool.test(list.get(1) == 65);
        AssertTool.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    public static void main(String[] args) {
        testList(new ArrayList<>());
        testList(new SingleLinkedList<>());
        testList(new CircleLinkedList<>());
    }
}
