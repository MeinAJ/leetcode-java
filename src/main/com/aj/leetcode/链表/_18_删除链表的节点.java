package com.aj.leetcode.链表;

import com.aj.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class _18_删除链表的节点 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;


        ListNode listNode = deleteNode(one, 1);
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
