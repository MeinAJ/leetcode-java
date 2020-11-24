/*
 * Copyright (c) 2019, ABB and/or its affiliates. All rights reserved.
 * ABB PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.aj.leetcode.version_1;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author An Jun
 * @date 2020-11-24
 */
public class _1_两数之和 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 7};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int n = i + 1; n < nums.length; n++) {
                if (nums[i] + nums[n] == target) {
                    result[0] = i;
                    result[1] = n;
                    return result;
                }
            }
        }
        return result;
    }

}
