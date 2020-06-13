package lovealgotithms.binarytree.binarysearchtree;

// 使用官方自定义的
//import binarytree.binarysearchtree.cmp.Comparable;
//import binarytree.binarysearchtree.cmp.Comparator;

import lovealgotithms.binarytree.BinaryTree;
import java.util.Comparator;

/**
 * 二叉搜索树，元素必须具备可比较性
 * 二叉树的定义：
 *  1、允许外界传入一个Comparator自定义比较方案
 *  2、如果没有传入Comparator，强制认定元素实现了Comparable接口
 *
 * 二叉树的遍历：
 *  1、当调用二叉树的调用方法遍历元素的时候，在遍历到这个元素的时候，需要做什么操作，由外界自己去实现。
 *  2、定义一个Visitor的接口，里面是一个visit()方法，这个方法是遍历时的逻辑，外界想要做什么的时候，实现这个方法即可。
 * @param <E>
 */
// E必须实现Comparable的接口compareTo才可以，保证可比较性。
public class BinarySearchTree<E> extends BinaryTree<E> {
    // 比较器
    private Comparator<E> comparator;
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // 不传入比较器
    public BinarySearchTree() {
        this(null);
    }

    public void remove(E element) {
        Node<E> node = node(element);
        remove(node);
    }

    /**
     * 如果节点的度为2，先用前驱或者后继的值覆盖原节点的值；然后删除相应的前驱或者后继节点。
     * 如果一个节点的度为2，那么它的前驱或者后继的节点的度只可能为1或者0
     * 如果节点的度为1，
     * @param node
     */
    private void remove(Node<E> node) {
        if (node == null) return;
        // 节点度为2
        if (node.hasTwoChildern()) {
            // 找到后继节点（前驱节点也可）
            Node<E> sucessorNode = sucessor(node);
            // 用后继节点来覆盖度为2节点的值
            node.element = sucessorNode.element;
            // 删除后继节点
            node = sucessorNode;
        }

        // 删除node节点(node的度必然为1或者0)
        Node<E> replacement = (node.left != null) ? node.left : node.right;
       if (replacement != null) { // node是度为1的节点
            // 更改parent、 更改parent的left或者right的指向
           if (node.parent == null) { // node是度为1的节点并且是根节点
               replacement.parent = null;
               root = replacement;
           } else if (node == node.parent.left) {
               replacement.parent = node.parent;
               node.parent.left = replacement;
           } else {
               replacement.parent = node.parent;
               node.parent.right = replacement;
           }
        } else { // 度为0，即叶子节点
            if (node.parent == null) { // node是根节点
                root = null;
            } else { // 有父节点
                if (node == node.parent.left) { // node在父节点的右边
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }
        }
        size--;
    }

    /**
     * 根据元素寻找节点
     * @param element
     * @return
     */
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        // 说明这个元素不存在
        return null;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public void add(E element) {
        elementNotNullCheck(element);
        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return                                                                                                                             ;
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
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等, 相等时，建议覆盖旧的值
                node.element = element;
                return;
            }
        } while (node != null);

        // 2、插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
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
}