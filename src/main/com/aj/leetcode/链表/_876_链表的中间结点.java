package com.aj.leetcode.链表;

import com.aj.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class _876_链表的中间结点 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
//        three.next = four;

        System.out.println(middleNode(one));
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode tmp = head.next;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        tmp = head.next;
        for (int i = 0; i < (count >> 1 + 1); i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

}
