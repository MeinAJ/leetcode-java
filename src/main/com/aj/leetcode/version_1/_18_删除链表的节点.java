package com.aj.leetcode.version_1;

import com.aj.leetcode.ListNode;
import com.aj.leetcode.ListNodeUtil;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class _18_删除链表的节点 {

    public static void main(String[] args) {
        ListNode listNode = deleteNode(ListNodeUtil.create(1, 2, 3, 4, 5, 6, 7, 3, 2), 1);
        System.out.println(listNode);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //如果是第一个节点,直接把第一个的next返回
        if (head.val == val) {
            return head.next;
        }
        ListNode currentNode = head.next;
        ListNode preNode = head;
        while (currentNode != null) {
            if (currentNode.val == val) {
                //把上一个的next指向该节点的next
                preNode.next = currentNode.next;
                break;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        return head;
    }

}
