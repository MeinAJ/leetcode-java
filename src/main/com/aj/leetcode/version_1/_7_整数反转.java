package com.aj.leetcode.version_1;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 * 输入: -123
 * 输出: -321
 * 输入: 120
 * 输出: 21
 */
public class _7_整数反转 {

    public static void main(String[] args) {
        int max = 2147483647;
        int min = -2147483648;
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int count = 0;
        int tmp = x;
        while (tmp != 0) {
            count++;
            tmp = tmp / 10;
        }
        if (x > 0) {
            int result = 0;
            int t = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                int tmp1;
                if (i == 0) {
                    if (count == 10 && x % 10 > 2){
                        return 0;
                    }
                    tmp1 = (x % 10) * ((int) Math.pow(10, count - i - 1));//3;
                } else {
                    tmp1 = (x / (int) Math.pow(10, i) % 10) * (int) Math.pow(10, count - i - 1);//2;
                }
                result += tmp1;
                if (count == 10) {
                    if ((t = (t - tmp1)) < 0) {
                        return 0;
                    }
                }
            }
            return result;
        } else if (x < 0) {
            int result = 0;
            int t = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                int tmp1;
                if (i == 0) {
                    if (count == 10 && x % 10 < -2){
                        return 0;
                    }
                    tmp1 = (x % 10) * ((int) Math.pow(10, count - i - 1));//3;
                } else {
                    tmp1 = (x / (int) Math.pow(10, i) % 10) * (int) Math.pow(10, count - i - 1);//2;
                }
                result += tmp1;
                if (count == 10) {
                    int i1 = t - tmp1;
                    if ((t = i1) > 0) {
                        return 0;
                    }
                }
            }
            return result;
        }
        return 0;
    }

}
