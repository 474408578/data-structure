package binarytree.binarysearchtree;

import binarytree.binarysearchtree.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    /**
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
    }*/

    static void test1() {
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
//        System.out.println("\n");
//        bst.preOrderTraversalRecursivly();
//        System.out.println("\n");
//        bst.preOrderTraversal();
        System.out.println("\n");
        bst.inOrderTraversal();
    }

    static void test2() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }

        BinaryTrees.println(bst1);

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }
        BinaryTrees.println(bst2);
    }

    static void test3() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 30; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
    }


    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
    }
}
