package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class _206_ReverseLinkedList {
    // 迭代的方法
    public ListNode reverseList1(ListNode head) {
        if (head == null ||head.next == null) {
            return head;
        }
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode nextNode = null;
        while(currentNode != null) {
            // 记录当前节点的下一个节点
            nextNode = currentNode.next;
            // 将当前节点的下一个指向previousNode
            currentNode.next = previousNode;
            // previousNode和currentNode都往后挪一位
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
