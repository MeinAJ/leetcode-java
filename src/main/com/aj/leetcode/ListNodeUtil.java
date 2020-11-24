package com.aj.leetcode;

public class ListNodeUtil {

    public static void main(String[] args) {
        create(1, 2, 3, 5, 7, 3);
    }

    public static ListNode create(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        if (values.length == 1) {
            return new ListNode(values[0]);
        }
        ListNode result = new ListNode(values[0]);
        ListNode tmp = result;
        for (int i = 1; i < values.length; i++) {
            tmp = tmp.next = new ListNode(values[i]);
        }
        System.out.println(result);
        return result;
    }

}
