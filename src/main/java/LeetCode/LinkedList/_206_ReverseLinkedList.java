package LeetCode.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class _206_ReverseLinkedList {

    /**
     * null    1  ->  2   ->   3   ->   4   ->   5
     * prev   curr   next
     *
     * null <- 1      2   ->   3   ->   4   ->   5
     * prev  curr    next
     *
     * null <- 1      2   ->   3   ->   4   ->   5
     *       prev    curr     next
     *
     * null <- 1  <-  2        3   ->   4   ->   5
     *               prev     curr     next
     *
     * null <- 1  <-  2   <-   3        4   ->   5
     *                        prev     curr     next
     *
     * null <- 1  <-  2   <-   3    <-  4        5
     *                                 prev     curr
     *
     * null <- 1  <-  2   <-   3    <-  4  <-    5
     *                                          prev  curr
     * @param head
     * @return
     */
    // 迭代的方法
    public ListNode reverseList1(ListNode head) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        while (currentNode != null ) {
            ListNode nextNode = currentNode.next;
            // 将currentNode.next的值指向previousNode
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    /**
     * 4    ->  5  ->  null
     * null <-  4  <-  5
     * null <-  3  <-  4  <-  5
     * null <-  2  <-  3  <-  4  <-  5
     * null <-  1  <-  2  <-  3  <-  4  <-  5
     * @param head
     * @return
     */
    // 递归的方法
    public ListNode reverseList2(ListNode head) {
        // 求解基本问题
        if (head == null || head.next == null) { return head;}
        // 将大问题转变为小问题
        ListNode newHead = reverseList1(head.next);
        // 小问题的解如何变成大问题的解
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
