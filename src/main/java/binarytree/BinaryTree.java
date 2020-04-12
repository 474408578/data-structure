package binarytree;


import binarytree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;

    protected static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;

        /**
         * 创建了一个节点，必然会有父节点，所以在构造函数中指定其父节点
         *
         * @param element
         * @param parent
         */
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        public boolean hasTwoChildern() {
            return this.left != null && this.right != null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }


    /**
     * 判断一棵树是否是完全二叉树，使用层序遍历：
     * 定义：
     *  叶子节点只会出现在最后两层，且最后一层的节点都靠左对齐
     *  完全二叉树从根节点到倒数第二层为满二叉树
     *
     * 实现：
     *  1、树为空，返回false
     *  2、树不为空，层序遍历：
     *      左不为空，node.left != null 将这个元素入队
     *      左边为空，右边不为空时，不是完全二叉树 node.left == null && node.right != null 返回false
     *      左边不为空或者为空，右边为空时（这个节点以下（按层序遍历的方式）的所有节点都为叶子节点）即：
     *      node.left != null && node.right == null 或者 node.left == null && node.right == null
     */
    public boolean isComplete() {
        // 树为空，返回false
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        boolean leaf = false;
        // 将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            // 已经判定之后的节点是叶子节点，但是这个节点却不是叶子节点的情况
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left != null && node.right == null) {
                queue.offer(node.left);
                leaf = true; //以后的节点都为叶子节点
            } else if (node.left == null && node.right != null) {
                return false;
            } else if (node.left == null && node.right == null) {
                leaf = true;
            }
        }
        return true;
    }
    // 二叉树的高度，即根节点的高度
    public int height() {
        return height(root);
    }

    // 节点的高度, 等于左右子节点的高度最大的 + 1，可用递归
    protected int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
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
    /**
     * 二叉搜索树的前驱节点和后继节点是为了二叉搜索树的删除做准备的
     */

    // 前驱节点：中序遍历时的前一个节点；如果是二叉搜索树，前驱节点就是前一个比它小的节点。
    // node.left != null时，前驱节点为node.left.right.right.right... 直到right=null
    // node.left == null && node.parent != null时，前驱节点为node.parent.parent... 直到node在parent的右子树中
    // node.left == null && node.parent == null时，没有前驱节点。
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        // 前驱节点在左子树中
        if (node.left != null) {
            Node<E> predessorNode = node.left;
            while (predessorNode.right != null) {
                predessorNode = predessorNode.right;
            }
            return predessorNode;
        }
        // 从父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        // node.parent == null
        // node = node.parent.right
        return node.parent;
    }


    // 后继节点：中序遍历时的后一个节点；如果是二叉搜索树树，后继节点就是后一个比它大的节点
    // node.right != null： node.right.left.left ... 直到left为null
    // node.right == null && node.parent != null: node.parent.parent ... 直到node在parent的左子树中
    // node.right == null && node.parent == null 没有前驱节点
    protected Node<E> sucessor(Node<E> node) {
        if (node == null) return null;
        if (node.right != null) {
            Node<E> sucessorNode = node.right;
            while (sucessorNode.left != null) {
                sucessorNode = sucessorNode.left;
            }
            return sucessorNode;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }
    protected void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
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
