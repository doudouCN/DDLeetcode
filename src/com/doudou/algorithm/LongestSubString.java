package com.doudou.algorithm;

/**
 * @ClassName: LongestSubString
 * @Author: doudou
 * @Datetime: 2019/9/30-10:31
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        /* 使用传统方法
        char[] charArray = s.toCharArray();
        int sourceLength = 0,newLength = 0;
        for (int i = 0; i < charArray.length; i++) {
            newLength = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(charArray[i]);
            for (int j = i+1; j < charArray.length; j++) {
                if (sb.toString().contains(charArray[j]+"")) {
                    newLength = sb.toString().length()>newLength?sb.toString().length():newLength;
                    break;
                } else {
                    sb.append(charArray[j]);
                    newLength++;
                }
            }
            sourceLength = newLength>sourceLength?newLength:sourceLength;
        }
        return sourceLength;*/

        // 使用滑动窗口算法
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    maxLength = Math.max(maxLength, j - leftIndex);
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(a));
    }
}
