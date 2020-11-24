package com.aj.leetcode.链表;

import com.aj.leetcode.ListNode;
import com.aj.leetcode.ListNodeUtil;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环形链表 {

    public static void main(String[] args) {
        System.out.println(hasCycle(ListNodeUtil.create(1, 2, 3, 4, 5, 6, 7, 3, 2)));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast.equals(slow)) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
