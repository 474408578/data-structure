package binarytree.binarysearchtree;

import binarytree.printer.BinaryTrees;

import java.util.Comparator;

public class AVLMain {
    /**
     * 实现比较器
     */
    static void test1() {
        Integer[] data = new Integer[] {
               7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        AVLTree<Integer> avlTree = new AVLTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 > o2) ? -1 : ((o1 == o2) ? 0 : 1);
            }
        });
        for (int i = 0; i < data.length; i++) {
            avlTree.add(data[i]);
        }

        BinaryTrees.println(avlTree);
    }

    static void test2() {
        Integer[] data = new Integer[] {
               7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        AVLTree<Integer> avlTree = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avlTree.add(data[i]);
        }

        BinaryTrees.println(avlTree);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
