package binarytree.binarysearchtree;

// 使用官方自定义的
//import binarytree.binarysearchtree.cmp.Comparable;
//import binarytree.binarysearchtree.cmp.Comparator;

import binarytree.binarysearchtree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public E remove(E element) {
        return null;
    }

    public boolean contains(E element) {
        return false;
    }

    /**
     * 判断一棵树是否是完全二叉树，使用层序遍历
     *  1、树为空，返回false
     *  2、树不为空，层序遍历：
     *      度为2：如果node.left != null && node.right != null，将node.left, node.right 按顺序入队
     *      度为1：
     *          左边为空，右边不为空时，不是完全二叉树 node.left == null && node.right != null 返回false
     *          左边不为空或者为空，右边为空时（这个节点以下的所有节点都为叶子节点）即：
     *              node.left != null && node.right == null 或者 node.left == null && node.right == null
     */
    public boolean isComplete() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            // 取出队头元素并返回，访问队头元素
            Node<E> node = queue.poll();
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else {

            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }


    // 二叉树的高度，即根节点的高度
    public int height() {
        return height(root);
    }

    // 节点的高度, 等于左右子节点的高度最大的 + 1，可用递归
    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 二叉树的高度，采用层序遍历的方式计算
    public int heightUseLevelTraversal() {
        if (root == null) return 0;
        int height = 0;
        Queue<Node<E>> queue = new LinkedList<>();
        int levelSize = 1;
        // 将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            // 取出队头元素并返回，将levelSize--
            Node<E> node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) { //意味着即将访问下一层
                levelSize = queue.size();
                height++;
            }
        }
        return height;
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

//    /** 没有传入visitor时，以打印的方式遍历元素。

//      前序遍历，递归的方式
//      根节点，前序遍历左子树，前序遍历右子树
    public void preOrderTraversalRecursively() {
        preOrderTraversalRecursively(root);
    }

    public void preOrderTraversalRecursively(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preOrderTraversalRecursively(node.left);
        preOrderTraversalRecursively(node.right);
    }



//      前序遍历，非递归的方式
//      1、将root入栈
//      循环执行以下操作，直到栈为空
//      2、弹出栈顶节点top，进行访问
//      3、将top.right入栈
//      4、将top.left入栈
    public void preOrderTraversal() {
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.println(currentNode.element);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }


//      中序遍历，递归的方式
//      左子树，根节点，右子树
    public void inOrderTraversalRecursively() {
        inOrderTraversalRecursively(root);
    }

    public void inOrderTraversalRecursively(Node<E> node) {
        if (node == null) return;
        inOrderTraversalRecursively(node.left);
        System.out.println(node.element);
        inOrderTraversalRecursively(node.right);
    }


//      中序遍历，非递归方式
//      1、将root入栈
//      循环执行以下操作
//      2、如果node != null
//           将node.left入栈
//           设置node = node.left
    public void inOrderTraversal() {

    }


//      后序遍历，递归方式
//      左子树，右子树，根节点
    public void postOrderTraversalRecursively() {
        postOrderTraversalRecursively(root);
    }


    public void postOrderTraversalRecursively(Node<E> node) {
        if (node == null) return;
        postOrderTraversalRecursively(node.left);
        postOrderTraversalRecursively(node.right);
        System.out.println(node.element);
    }


//      层序遍历
//      从上到下，从左到右依次访问每一个节点
//      使用队列来实现
//           将根节点入队
//           循环执行以下操作，直到队列为空
//               将队头节点A出队，进行访问
//               将A的左子节点入队
//               将A的右子节点入队
    public void levelOrderTraversal() {
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            // 取出队头元素并返回，访问队头元素
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
//*/
    // 使用visitor的前序遍历
    public void preOrder(Visitor<E> visitor) {
        if (visitor == null) return;
        preOrder(root, visitor);
    }

    public void preOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    // 使用visitor的中序遍历
    public void inOrder(Visitor<E> visitor) {
        if (visitor == null) return;
        inOrder(root, visitor);
    }

    public void inOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        inOrder(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inOrder(node.right, visitor);

    }

    // 使用visitor的后序遍历
    public void postOrder(Visitor<E> visitor) {
        if (visitor == null) return;
        postOrder(root, visitor);

    }

    public void postOrder(Node<E> node, Visitor<E> visitor) {
        // 如果visitor.stop为true, 则不进行递归调用（与下面的语句是不同的）
        if (node == null || visitor.stop) return;
        postOrder(node.left, visitor);
        postOrder(node.right, visitor);
        // 如果为true不执行下面的操作（如果只是在这里返回，上面的递归代码仍然在继续执行）
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }


    // 使用visitor的层序遍历
    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            // 取出队头元素并返回，访问队头元素
            Node<E> node = queue.poll();
            // 真正的访问逻辑, 调用visitor的visit方法，把节点的内容传入进去即可, 如果返回的值为true，则停止遍历
            if (visitor.visit(node.element)) return;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
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
     * 公共的内部接口
     * 允许外界自定义遍历逻辑，也就是说，遍历到这个节点，想要做的操作，是打印呢，还是别的什么操作
     * @param <E>
     */
    public static abstract class Visitor<E> {
        boolean stop;
        // 所要做的操作由外界实现（注意：节点对外是不可见的，对外可见的是节点的数据）
        // 如果返回true，则停止遍历
        public abstract boolean visit(E element);
    }


    /**
     * 利用前序遍历打印二叉树
     *
     * 【7】
     * 【L】【4】
     * 【L】【L】【2】
     * 【L】【L】【L】【1】
     * 【L】【L】【R】【3】
     * 【L】【R】【5】
     * 【R】【9】
     * 【R】【L】【8】
     * 【R】【R】【11】
     * 【R】【R】【L】【10】
     * 【R】【R】【R】【12】
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return ;
        sb.append(prefix)
                .append("【")
                .append(node.element)
                .append("】")
                .append("\n");
        toString(node.left, sb, prefix + "【L】");
        toString(node.right, sb, prefix + "【R】");
    }

    /**
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
