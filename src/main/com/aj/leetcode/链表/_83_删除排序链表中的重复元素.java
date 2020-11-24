package com.aj.leetcode.链表;

import com.aj.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 输入: 1->1->2
 * 输出: 1->2
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class _83_删除排序链表中的重复元素 {

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(4);
        ListNode seven = new ListNode(5);
        ListNode eight = new ListNode(1);
        ListNode nine = new ListNode(8);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;

        System.out.println(deleteDuplicates(one));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        System.out.println(head);
        ListNode result = new ListNode(head.val);
        ListNode lastResultNode = result;
        ListNode tmp = head.next;
        while (tmp != null) {
            ListNode resultTmp = result;
            boolean flag = true;
            while (resultTmp != null) {
                if (tmp.val == resultTmp.val) {
                    flag = false;
                    break;
                }
                resultTmp = resultTmp.next;
            }
            if (flag) {
                lastResultNode = lastResultNode.next = new ListNode(tmp.val);
                lastResultNode.next = null;
            }
            tmp = tmp.next;
        }
        return result;
    }

}

