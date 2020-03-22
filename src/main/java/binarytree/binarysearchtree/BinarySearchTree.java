package binarytree.binarysearchtree;

// 使用官方自定义的
//import binarytree.binarysearchtree.cmp.Comparable;
//import binarytree.binarysearchtree.cmp.Comparator;

import binarytree.binarysearchtree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * 二叉搜索树，元素必须具备可比较性
 * 1、允许外界传入一个Comparator自定义比较方案
 * 2、如果没有传入Comparator，强制认定元素实现了Comparable接口
 * @param <E>
 */
// E必须实现Comparable的接口compareTo才可以，保证可比较性。
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    // 比较器
    private Comparator<E> comparator;
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // 不传入比较器
    public BinarySearchTree() {
        this(null);
    }
    /**
     * 节点内部类
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        /**
         * 创建了一个节点，必然会有父节点，所以在构造函数中指定其父节点
         * @param element
         * @param parent
         */
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    /**
     *
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);
        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        /**
         * 添加的不是第一个节点
         * 1、找到父节点
         * 2、看看插入到父节点的那个位置
         */
        // 1、找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return;
            }
        }

        // 2、插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public E remove(E element) {
        return null;
    }

    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 根据用户自定义的比较逻辑来实现比较
     * @param e1
     * @param e2
     * @return 返回值等于0，代表e1==e2; 返回值大于0，代表e1大于e2, 返回值小于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        // 使用比较器进行比较, 也需要实现这个比较器
        if (comparator != null){
            return comparator.compare(e1, e2);
        }

        // 不使用比较器时，做强制转换，如果没有实现Comparable接口的话，Java会自动抛出异常，提示实现这个接口
        return ((Comparable<E>) e1).compareTo(e2);
    }


    /**
     *
     * printer.BinaryTreeInfo的接口，实现打印二叉树。
     */
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
}
