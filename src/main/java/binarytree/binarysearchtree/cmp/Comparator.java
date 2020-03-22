package binarytree.binarysearchtree.cmp;
/**
 * 个性化定制二叉搜索树的比较逻辑
 * Java官方提供有这个比较器 java.util.Comparator
 */
public interface Comparator<E> {
    int compare(E e1, E e2);
}
