/*
 * Copyright (c) 2019, ABB and/or its affiliates. All rights reserved.
 * ABB PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.aj.leetcode.version_1;

import com.aj.leetcode.ListNode;
import com.aj.leetcode.ListNodeUtil;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author An Jun
 * @date 2020-11-24
 */
public class _2_两数相加 {

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(ListNodeUtil.create(1, 4, 5), ListNodeUtil.create(5, 6, 6)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode resultTmp = result;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        boolean hasCarryBit = false;
        while (tmp1 != null || tmp2 != null) {
            int tmpSum = (tmp1 != null ? tmp1.val : 0) + (tmp2 != null ? tmp2.val : 0) + (hasCarryBit ? 1 : 0);
            if (tmpSum < 10) {
                resultTmp.val = tmpSum;
                hasCarryBit = false;
            } else {
                resultTmp.val = (tmpSum - 10);
                hasCarryBit = true;
            }
            tmp1 = tmp1 != null ? tmp1.next : null;
            tmp2 = tmp2 != null ? tmp2.next : null;
            if (tmp1 != null || tmp2 != null || hasCarryBit) {
                resultTmp = resultTmp.next = new ListNode();
            }
        }
        if (hasCarryBit) {
            resultTmp.val = 1;
        }
        return result;
    }

}
