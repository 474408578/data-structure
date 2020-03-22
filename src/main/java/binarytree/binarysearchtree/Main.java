package binarytree.binarysearchtree;

import binarytree.binarysearchtree.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    // 也可直接使用匿名内部类来实现
    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    private static class PersonComparator2 implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }
    public static void main(String[] args) {
        // 内置的Java类型大多都实现了Comparable接口
        // Integer本身就实现了Comparable接口（可看源码）
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 12, 1
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        // 打印二叉树，使用代码中的printer进行打印
        BinaryTrees.print(bst);

//        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
//        bst2.add(new Person(12));
//        bst2.add(new Person(15));
//
//        BinarySearchTree<Person> bs3 = new BinarySearchTree<>(new PersonComparator2());
//        bst2.add(new Person(12));
//        bst2.add(new Person(15));



    }
}
