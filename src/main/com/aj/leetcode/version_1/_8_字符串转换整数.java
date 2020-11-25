package com.aj.leetcode.version_1;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 输入: "42"
 * 输出: 42
 * 输入: "   -42"
 * 输出: -42
 * 输入: "4193 with words"
 * 输出: 4193
 * 输入: "words and 987"
 * 输出: 0
 */
public class _8_字符串转换整数 {

    public static void main(String[] args) {
        _8_字符串转换整数 v = new _8_字符串转换整数();
        System.out.println(v.myAtoi("-1"));
    }

    public int myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        //如果遇到空格就跳过,遇到数字和-就停下
        for (int i = 0; i < length; i++) {
            int a = chars[i];
            if (a == ' ') {
                continue;
            }
            if ((a == '+' && i + 1 < length && (chars[i + 1] <= '9' && chars[i + 1] >= '0'))) {
                //表示后面的是负数
                int tmp = i + 1;
                int beginIndex = newCharsBegin(tmp, chars);
                beginIndex = tmp;
                int beginEnd = newCharsEnd(tmp, chars);
                if (beginIndex == -1){
                    return 0;
                }
                //i是chars数组的开始指针,endIndex是chars数组的结尾指针,如果endIndex-i>=9,
                //认为是可能会超过32的最大数(Integer.MAX_VALUE),如果endIndex-i<9,就直接将字符串转换成数字
                int count = beginIndex - tmp;
                if (count > 10) {
                    return Integer.MIN_VALUE;
                } else if (count < 10) {
                    int sum = 0;
                    for (int m = 0; m < count; m++) {
                        sum += getInt(chars[tmp + m]) * getPow(count - m - 1);
                    }
                    return +sum;
                } else {
                    int max = Integer.MAX_VALUE;
                    int sum = 0;
                    boolean firstLessThanTwo = true;
                    int first = 0;
                    for (int m = 0; m < count; m++) {
                        int anInt = getInt(chars[tmp + m]);
                        if (m == 0) {
                            first = anInt;
                        }
                        if (firstLessThanTwo && anInt > 2) {
                            return Integer.MIN_VALUE;
                        }
                        if (first == 2) {
                            max -= anInt * getPow(count - m - 1);
                            if (max < 0) {
                                return Integer.MIN_VALUE;
                            }
                        }
                        sum += anInt * getPow(count - m - 1);
                        firstLessThanTwo = false;
                    }
                    return +sum;
                }
            } else if (a <= '9' && a >= '0') {
                //表示正数,后面的就不计算了
                int endIndex = newCharsBegin(i, chars);
                //i是chars数组的开始指针,endIndex是chars数组的结尾指针,如果endIndex-i>=9,
                //认为是可能会超过32的最大数(Integer.MAX_VALUE),如果endIndex-i<9,就直接将字符串转换成数字
                int count = endIndex - i;
                if (count > 10) {
                    return Integer.MAX_VALUE;
                } else if (count < 10) {
                    int sum = 0;
                    for (int m = 0; m < count; m++) {
                        sum += getInt(chars[i + m]) * getPow(count - m - 1);
                    }
                    return sum;
                } else {
                    int max = Integer.MAX_VALUE;
                    int sum = 0;
                    boolean firstLessThanTwo = true;
                    int first = 0;
                    for (int m = 0; m < count; m++) {
                        int anInt = getInt(chars[i + m]);
                        if (m == 0) {
                            first = anInt;
                        }
                        if (firstLessThanTwo && anInt > 2) {
                            return Integer.MAX_VALUE;
                        }
                        if (first == 2) {
                            max -= anInt * getPow(count - m - 1);
                            if (max < 0) {
                                return Integer.MAX_VALUE;
                            }
                        }
                        sum += anInt * getPow(count - m - 1);
                        firstLessThanTwo = false;
                    }
                    return sum;
                }
            } else if ((a == '-' && i + 1 < length && (chars[i + 1] <= '9' && chars[i + 1] >= '0'))) {
                //表示后面的是负数
                int tmp = i + 1;
                int endIndex = newCharsBegin(tmp, chars);
                //i是chars数组的开始指针,endIndex是chars数组的结尾指针,如果endIndex-i>=9,
                //认为是可能会超过32的最大数(Integer.MAX_VALUE),如果endIndex-i<9,就直接将字符串转换成数字
                int count = endIndex - tmp;
                if (count > 10) {
                    return Integer.MIN_VALUE;
                } else if (count < 10) {
                    int sum = 0;
                    for (int m = 0; m < count; m++) {
                        sum += getInt(chars[tmp + m]) * getPow(count - m - 1);
                    }
                    return -sum;
                } else {
                    int max = Integer.MAX_VALUE;
                    int sum = 0;
                    boolean firstLessThanTwo = true;
                    int first = 0;
                    for (int m = 0; m < count; m++) {
                        int anInt = getInt(chars[tmp + m]);
                        if (m == 0) {
                            first = anInt;
                        }
                        if (firstLessThanTwo && anInt > 2) {
                            return Integer.MIN_VALUE;
                        }
                        if (first == 2) {
                            max -= anInt * getPow(count - m - 1);
                            if (max < -1) {
                                return Integer.MIN_VALUE;
                            }
                        }
                        sum += anInt * getPow(count - m - 1);
                        firstLessThanTwo = false;
                    }
                    return -sum;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    private int getPow(int count) {
        int pow = 1;
        for (int i = 0; i < count; i++) {
            pow *= 10;
        }
        return pow;
    }

    private int newCharsBegin(int beginIndex, char[] oldChars) {
        for (; beginIndex < oldChars.length; beginIndex++) {
            if (oldChars[beginIndex] == '0' && beginIndex + 1 < oldChars.length && oldChars[beginIndex + 1] == '0') {
                return -1;
            }
            if (oldChars[beginIndex] > '9' || oldChars[beginIndex] < '0') {
                return beginIndex;
            }
        }
        return beginIndex;
    }

    private int newCharsEnd(int beginIndex, char[] oldChars) {
        int i = beginIndex;
        for (; beginIndex < oldChars.length; beginIndex++) {
            if (i == beginIndex && oldChars[beginIndex] == '0') {
                return beginIndex;
            }
            if (oldChars[beginIndex] > '9' || oldChars[beginIndex] < '0') {
                return beginIndex;
            }
        }
        return beginIndex;
    }

    private int getInt(char c) {
        if (c == '0') {
            return 0;
        } else if (c == '1') {
            return 1;
        } else if (c == '2') {
            return 2;
        } else if (c == '3') {
            return 3;
        } else if (c == '4') {
            return 4;
        } else if (c == '5') {
            return 5;
        } else if (c == '6') {
            return 6;
        } else if (c == '7') {
            return 7;
        } else if (c == '8') {
            return 8;
        } else {
            return 9;
        }
    }
}
