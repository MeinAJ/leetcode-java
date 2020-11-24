package com.aj.leetcode.version_1;

import com.aj.leetcode.ListNode;
import com.aj.leetcode.ListNodeUtil;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class _876_链表的中间结点 {

    public static void main(String[] args) {
        System.out.println(middleNode(ListNodeUtil.create(1, 2, 3, 4, 5, 6, 7, 7, 6, 5, 4, 3, 2, 1)));
    }

    public static ListNode middleNode(ListNode head) {
        //计算出总共n个节点,从 ((n + 1)/2)
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode tmp = head.next;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        System.out.println(count);
        //这是第0个  总共有第n-1个 要取后
        tmp = head;
        for (int i = 0; i < (count >> 1); i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

}
