package leetcode.binarysearchtree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 翻转二叉树
 * 实现思想：
 *      将二叉树中所有节点的左右子树的位置交换
 * 实现步骤：
 * 1、遍历二叉树（前、中、后、层）
 * 2、交换左右子树的位置
 */
public class _226_InvertBinaryTree {
    // 前序遍历
    public TreeNode invertTreePreTraversal(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreePreTraversal(root.left);
        invertTreePreTraversal(root.right);
        return root;
    }

    // 中序遍历
    public TreeNode invertTreeInTraversal(TreeNode root) {
        if (root == null) return null;
        invertTreeInTraversal(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 此处需要使用root.left， 因为交换了left和right
        invertTreeInTraversal(root.left);
        return root;
    }

    // 后续遍历
    public TreeNode invertTreePostTraversal(TreeNode root) {
        if (root == null) return null;
        invertTreePostTraversal(root.left);
        invertTreePostTraversal(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    // 层序遍历
    public TreeNode invertTreeLevelTraversal(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
