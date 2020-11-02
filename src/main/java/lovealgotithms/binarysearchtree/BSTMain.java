package lovealgotithms.binarysearchtree;

import lovealgotithms.binarytree.binarysearchtree.Person;
import lovealgotithms.binarytree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * 经验：如果想要构造一棵二叉搜索树，只需要将元素按照顺序以层序遍历的方式去加就可以了。
 * 7, 4, 9, 2, 5, 8, 11, 3, 1
 *
 *            7
 *       4         9
 *    2    5    8     11
 * 1    3
 *
 */

public class BSTMain {
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
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        // 打印二叉树，使用代码中的printer进行打印
        BinaryTrees.print(bst);
//        System.out.println("\n");
//        bst.preOrderTraversalRecursively();
//        System.out.println("\n");
//        bst.preOrderTraversal();
        System.out.println("\n");
        bst.inOrderTraversalRecursively();
        System.out.println("\n");
        bst.postOrderTraversalRecursively();
        System.out.println("\n");
        bst.levelOrderTraversal();
    }

    static void test2() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Person> bst1 = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }

        BinaryTrees.println(bst1);

        BST<Person> bst2 = new BST<>(new Comparator<Person>() {
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
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 30; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        System.out.println("二叉搜索树的高度为: " + bst.height());
        System.out.println("二叉搜索树的高度为: " + bst.heightUseLevelTraversal());

    }

    static void test4() {
        Integer data[] = new Integer[]{
            7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12
        };

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println("\n");

//        bst.levelOrderTraversal();
        System.out.println("\n层序遍历");
        // 实现Visitor接口
        bst.levelOrder(new BST.Visitor<Integer>() {
            public boolean visit(Integer element) {
                // 不换行
                System.out.print("-" + element + "-");
                return element == 2;
            }
        });

        System.out.println("\n前序遍历");
        bst.preOrder(new BST.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("-" + element + "-");
                return element == 1;
            }
        });
        System.out.println("\n中序遍历");
        bst.inOrder(new BST.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("-" + element + "-");
                return element == 4;
            }
        });
        System.out.println("\n后序遍历");
        bst.postOrder(new BST.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("-" + element + "-");
                return element == 5;
            }
        });

        System.out.println("\n" + bst);
    }

    static void test5() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BST<Integer> bst = new BST();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println("是否为完全二叉树：" + bst.isComplete());
    }

    static void test6() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BST<Integer> bst = new BST();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);

        bst.remove(7);
//        bst.remove(3);
//        bst.remove(12);
        BinaryTrees.println(bst);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
//        test4();
//        test5();
//        test6();
    }
}
