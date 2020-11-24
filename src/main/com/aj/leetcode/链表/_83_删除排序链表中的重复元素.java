package com.aj.leetcode.链表;

import com.aj.leetcode.ListNode;
import com.aj.leetcode.ListNodeUtil;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 输入: 1->1->2
 * 输出: 1->2
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class _83_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNodeUtil.create(1, 2, 3, 4, 5, 6, 7, 3, 2)));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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

