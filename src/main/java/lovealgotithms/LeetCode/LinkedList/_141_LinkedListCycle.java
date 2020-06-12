package leetcode.linkedList;


/**
 * https://leetcode.com/problems/linked-list-cycle/submissions/
 * 使用快慢指针来判断是否闭环
 */

public class _141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) { return false; }
        // 快慢指针
        ListNode slow = head;
        ListNode quick = head.next;
        // 如果quick为null, 不是环，跳出，同时满足 quick != null && quick.next != null 防止空指针异常
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            // 如果相等，必然是环
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}