/*
 * Copyright (c) 2019, ABB and/or its affiliates. All rights reserved.
 * ABB PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.aj.leetcode.version_1;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author An Jun
 * @date 2020-11-24
 */
public class _3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("hello,world"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        } else if ("".equals(s)) {
            return 1;
        }
        return cycle(0, s.length(), s.toCharArray());
    }

    private static int cycle(int begin, int end, char[] toCharArray) {
        //todo
        return 0;
    }

}
